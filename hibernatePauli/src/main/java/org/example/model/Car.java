package org.example.model;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Table(name = "SAMOCHOD")
@Getter
@Setter
@NoArgsConstructor// <- konstruktor bezargumentowy
//@AllArgsConstructor // <- kontruktor ze wszystkimi polami
//@RequiredArgsConstructor // <- konstruktor tylko dla pol final
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    @Column(name = "MAX_SPEED")
    private Integer maxSpeed;

    public Integer getId() {
        return id;
    }
}