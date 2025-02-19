package org.example.global.thirdparty.ollama;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpHeaders;
import org.example.common.service.OllamaService;
import org.example.global.thirdparty.ollama.dto.response.OllamaPromptResponseDto;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OllamaServiceAdapter implements OllamaService {

    @Override
    public String sendPrompt(String prompt) {
        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMinutes(3))
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(3, TimeUnit.MINUTES))
                                  .addHandlerLast(new WriteTimeoutHandler(3, TimeUnit.MINUTES))
                );

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:11434/api/generate")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();

        Mono<Map<String, String>> requestBody = Mono.just(Map.of(
                "model", "deepseek-r1:14b",
                "prompt", prompt
        ));

        List<OllamaPromptResponseDto> responses = webClient.post()
                .body(requestBody, Map.class)
                .retrieve()
                .bodyToFlux(OllamaPromptResponseDto.class)
                .collectList()
                .block();

        boolean foundThinkEndTag = false;
        List<String> responseStrings = new ArrayList<>();

        for (OllamaPromptResponseDto response : responses) {
            if (foundThinkEndTag && !response.response().trim().isEmpty()) {
                responseStrings.add(response.response());
            }
            if (response.response().equals("</think>")) {
                foundThinkEndTag = true;
            }
        }

        return responseStrings.stream().collect(Collectors.joining());
    }
}