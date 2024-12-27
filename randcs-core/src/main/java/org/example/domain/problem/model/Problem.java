package org.example.domain.problem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class Problem {
    private final UUID id;

    private final UUID textbookId;

    private final String context;

    private final String type;

    private final String choice;
}
