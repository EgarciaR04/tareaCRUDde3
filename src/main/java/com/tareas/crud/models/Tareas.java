package com.tareas.crud.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "La tarea tiene que tener un titulo")
    @Size(min = 5, max = 20, message = "El titulo debe tener entre 5 y 20 caracteres")
    @Column(nullable = false)
    private String title;

    @NotNull()
    @Size(max = 100)
    private String description;

    @NotBlank(message = "La tarea debe de tener una fecha de vencimiento")
    @Column(nullable = false)
    private LocalDate dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId", nullable = false)
    private Proyecto project;
}
