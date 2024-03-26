package com.example.demo.service;

import com.example.demo.dto.AutorDto;
import com.example.demo.entity.Autor;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface AutorService {

  Autor createautor(AutorDto autoraux);
  List<Autor> getAll();

  Autor getById(String id);

  Autor update(AutorDto autordto, String id);

  Autor deleteById(String id);


  List<Autor> getAutorByNombre(String nombre);


  List<Autor> getAutorByNacimiento(LocalDateTime nacimiento);
}
