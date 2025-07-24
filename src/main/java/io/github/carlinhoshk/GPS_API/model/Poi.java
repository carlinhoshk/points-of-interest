package io.github.carlinhoshk.GPS_API.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Poi {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String nome;
    @PositiveOrZero
    private int coord_x;
    @PositiveOrZero
    private int coord_y;
}
