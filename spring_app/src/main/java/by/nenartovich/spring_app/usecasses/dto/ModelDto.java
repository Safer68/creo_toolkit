package by.nenartovich.spring_app.usecasses.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record ModelDto(String name) implements Serializable {
}