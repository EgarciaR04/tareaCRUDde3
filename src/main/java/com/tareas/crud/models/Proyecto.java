package com.tareas.crud.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "El campo nombre es obligatorio")
    @Size(max = 50, message = "No puede colocar mas de 50 caracteres")
    @Column(nullable = false)
    private String name;

    @Size(max = 100)
    private String description;

    @NotNull(message = "Fecha de inicio es obligatorio")
    @Column(nullable = false)
    private LocalDate startDate;
}
