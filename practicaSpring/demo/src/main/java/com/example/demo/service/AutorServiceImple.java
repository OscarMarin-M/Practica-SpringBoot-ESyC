package com.example.demo.service;

import com.example.demo.dto.AutorDto;
import com.example.demo.entity.Autor;
import com.example.demo.mapper.AutorMapper;
import com.example.demo.repository.AutorRepository;
import jakarta.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AutorServiceImple implements AutorService {
  private AutorRepository autorRepository;
  private AutorMapper autorMapper;
  @Override
  public Autor createautor(AutorDto autoraux) {
    Autor autorinprocess=autorMapper.autorfromMapper(autoraux);
    UUID uuid = UUID.randomUUID();
    String uuidString =uuid.toString();
    autorinprocess.setId(uuidString);

    return autorRepository.save(autorinprocess);
  }

  @Override
  public List<Autor> getAll() {
    return autorRepository.findAll();
  }

  @Override
  public Autor getById(String id) {
    return autorRepository.findById(id).orElseThrow(()->new EntityNotFoundException("AUTOR NOT FOUND"));
  }

  @Override
  public Autor update(AutorDto autordto, String id) {
    Autor autortoupdate =autorRepository.findById(id).get();
    autortoupdate.setNombre(autordto.getNombre());
    autortoupdate.setPais_origen(autordto.getPais_origen());
    autortoupdate.setSexo(autordto.getSexo());
    autortoupdate.setNacimiento(autordto.getNacimiento());
    autortoupdate.setDefuncion(autordto.getDefuncion());

    return autorRepository.save(autortoupdate);
  }

  @Override
  public Autor deleteById(String id) {
    Autor autoraux =this.getById(id);
    autorRepository.deleteById(autoraux.getId());
    return null;
  }

  @Override
  public List<Autor> getAutorByNombre(String nombre) {
    return autorRepository.findByNombre(nombre);
  }

  @Override
  public List<Autor> getAutorByNacimiento(LocalDateTime nacimiento) {
    return autorRepository.findByNacimientoGreaterThanEqual(nacimiento);
  }


}
