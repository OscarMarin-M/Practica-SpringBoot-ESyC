package com.example.demo.repository;

import com.example.demo.entity.Autor;
import com.example.demo.entity.Libro;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, String> {
  List<Libro> findByApub(String apub);

}
