package bj.uac.ine.webdev.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Cart> carts;
}
