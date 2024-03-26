package com.example.demo.mapper;

import com.example.demo.dto.LibroDto;
import com.example.demo.entity.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {


  public Libro librofromMapper(LibroDto librodtoaux){

    Libro libro=new Libro();
    libro.setTitulo(librodtoaux.getTitulo());
    libro.setApub(librodtoaux.getApub());

    return libro;
  }
}
