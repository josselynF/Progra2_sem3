package com.semana3.semana3.repository;

import com.semana3.semana3.model.Alumno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String>{
    @Query(value = "SELECT o FROM Alumno o WHERE o.id=?1")
    Optional <Alumno> findById(String id);
}
