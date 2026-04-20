package com.example.tareas.repository;

import com.example.tareas.domain.model.EstadoTarea;
import com.example.tareas.domain.model.Tarea;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByEstado(EstadoTarea estado);

    List<Tarea> findByTituloContainingIgnoreCase(String titulo);
}
