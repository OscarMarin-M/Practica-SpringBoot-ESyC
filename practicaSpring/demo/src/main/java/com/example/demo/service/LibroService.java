package com.example.demo.service;

import com.example.demo.dto.LibroDto;
import com.example.demo.entity.Autor;
import com.example.demo.entity.Libro;
import java.util.List;

public interface LibroService {

  Libro createLibro(LibroDto libroaux);

  Libro getById(String id);

  Libro updateLibro(LibroDto dto, String id);

  Libro deleteById(String id);

  List<Libro> findByApub(String apub);
}
