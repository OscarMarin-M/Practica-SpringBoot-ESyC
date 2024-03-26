package com.example.demo.controller;

import com.example.demo.dto.LibroDto;
import com.example.demo.entity.Autor;
import com.example.demo.entity.Libro;
import com.example.demo.service.LibroService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/libro")
public class LibroController {


  private LibroService libroService;

  @PostMapping
  public ResponseEntity<Libro> createlibro(@RequestBody LibroDto dto) {
    Libro librosaved = libroService.createLibro(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(librosaved);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Libro> findById(@PathVariable String id) {
    Libro librofound = libroService.getById(id);
    return ResponseEntity.status(HttpStatus.OK).body(librofound);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Libro> updatelibro(@RequestBody LibroDto librodto,
      @PathVariable String id) {
    Libro libroaux = libroService.updateLibro(librodto, id);

    return ResponseEntity.status(HttpStatus.OK).body(libroaux);
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<Libro> deletelibro(@PathVariable String id) {
    Libro libroaux = libroService.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).body(libroaux);
  }


  @GetMapping("apub/{apub}")
  public ResponseEntity<List<Libro>> getByName(@PathVariable String apub){
    List<Libro> libros = libroService.findByApub(apub);
    return ResponseEntity.status(HttpStatus.OK).body(libros);
  }
}
