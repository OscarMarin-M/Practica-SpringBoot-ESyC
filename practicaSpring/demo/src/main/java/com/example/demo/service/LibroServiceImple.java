package com.example.demo.service;

import com.example.demo.dto.LibroDto;
import com.example.demo.entity.Autor;
import com.example.demo.entity.Libro;
import com.example.demo.mapper.LibroMapper;
import com.example.demo.repository.AutorRepository;
import com.example.demo.repository.LibroRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LibroServiceImple implements LibroService{

  private LibroRepository libroRepository;
  private LibroMapper libroMapper;
  private AutorService autorService;

  @Override
  public Libro createLibro(LibroDto libroaux) {
    Libro libroinprocess=libroMapper.librofromMapper(libroaux);
    Autor autor=autorService.getById(libroaux.getAutor_id());
    UUID uuid = UUID.randomUUID();
    String uuidString =uuid.toString();
    libroinprocess.setId(uuidString);

    libroinprocess.setAutor(autor);
    return libroRepository.save(libroinprocess);
  }

  @Override
  public Libro getById(String id) {
    return libroRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("LIBRO NO ENCONTRADO"));
  }

  @Override
  public Libro updateLibro(LibroDto dto, String id) {
    Libro librotoupdate =libroRepository.findById(id).get();
    librotoupdate.setTitulo(dto.getTitulo());
    librotoupdate.setApub(dto.getApub());
    Autor autor=autorService.getById(dto.getAutor_id());
    librotoupdate.setAutor(autor);
    return libroRepository.save(librotoupdate);
  }

  @Override
  public Libro deleteById(String id) {
    Libro libroaux =this.getById(id);
    libroRepository.deleteById(libroaux.getId());
    return null;
  }

  @Override
  public List<Libro> findByApub(String apub) {
    return libroRepository.findByApub(apub);
  }

}
