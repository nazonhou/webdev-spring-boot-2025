package bj.uac.ine.webdev.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {
    private String name;
    private String color;
    private Double price;
    private Integer quantity;
}
