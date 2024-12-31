package bj.uac.ine.webdev.dtos;

import jakarta.validation.constraints.*;

public record CreateProductDto(
        @NotBlank(message = "Ne doit pas être vide")
        @Size(min = 3, message = "Doit avoir une longueur minimale de 3")
        String name,
        String color,
        @NotNull
        @Digits(integer = 6, fraction = 2)
        @Positive
        Double price,
        @NotNull
        @Digits(integer = 6, fraction = 0)
        @PositiveOrZero
        Integer quantity) {
}
