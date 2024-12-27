package org.example.domain.textbook.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@RequiredArgsConstructor
public class Textbook {
    private final UUID id;

    private final String userEmail;

    private final String coverImage;

    private final String title;
}
