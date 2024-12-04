package bj.uac.ine.webdev.dtos;

public record CreateProductDto(
        String name,
        String color,
        Double price,
        Integer quantity) {
}
