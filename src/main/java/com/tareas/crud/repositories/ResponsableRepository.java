package com.tareas.crud.repositories;

import com.tareas.crud.models.Responsables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface ResponsableRepository extends JpaRepository<Responsables, Long> {
    @Query("SELECT r FROM Responsables r WHERE r.task.id = :id_get")
    List<Responsables> getResponsablesByid(@Param("id_get") long id);
}
