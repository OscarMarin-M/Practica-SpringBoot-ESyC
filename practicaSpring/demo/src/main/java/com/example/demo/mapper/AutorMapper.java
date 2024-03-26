package com.example.demo.mapper;

import com.example.demo.dto.AutorDto;
import com.example.demo.entity.Autor;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper {

  public Autor autorfromMapper(AutorDto autordtoaux){

    Autor autor=new Autor();
    autor.setNombre(autordtoaux.getNombre());
    autor.setPais_origen(autordtoaux.getPais_origen());
    autor.setSexo(autordtoaux.getSexo());
    autor.setNacimiento(autordtoaux.getNacimiento());
    autor.setDefuncion(autordtoaux.getDefuncion());

    return autor;
  }
}
