package com.example.demo.repository;

import com.example.demo.entity.Autor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,String> {
    List<Autor> findByNombre(String nombre);

    List<Autor> findByNacimientoGreaterThanEqual(LocalDateTime nacimiento);
}
