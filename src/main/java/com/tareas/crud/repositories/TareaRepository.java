package com.tareas.crud.repositories;

import com.tareas.crud.models.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tareas, Long> {
    @Query("SELECT t FROM Tareas t WHERE t.project.id = :id_get")
    List<Tareas> getTareasByProyectoId(@Param("id_get") long id_get);
}
