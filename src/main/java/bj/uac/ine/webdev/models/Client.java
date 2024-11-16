package bj.uac.ine.webdev.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Client {
    private String name;
    private String phoneNumber;
}
