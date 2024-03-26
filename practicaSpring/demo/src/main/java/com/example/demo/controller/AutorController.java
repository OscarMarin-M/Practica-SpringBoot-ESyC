package com.example.demo.controller;

import com.example.demo.dto.AutorDto;
import com.example.demo.entity.Autor;
import com.example.demo.service.AutorService;
import jakarta.persistence.EntityNotFoundException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import netscape.javascript.JSObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autors")
@AllArgsConstructor
public class AutorController {

  private AutorService autorService;


  @PostMapping
  public ResponseEntity<Autor> createautor(@RequestBody AutorDto dto) {
    Autor autorSaved = autorService.createautor(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(autorSaved);
  }

  @GetMapping
  public ResponseEntity<List<Autor>> getAll() {
    List<Autor> autores = autorService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(autores);
  }

  @GetMapping("/{id}")
public ResponseEntity<Autor> getById(@PathVariable String id){
    Autor autoraux =autorService.getById(id);

    return ResponseEntity.status(HttpStatus.OK).body(autoraux);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Autor> updateautor(@RequestBody AutorDto autordto, @PathVariable String id){
        Autor autoraux = autorService.update(autordto, id);

        return ResponseEntity.status(HttpStatus.OK).body(autoraux);
  }

  @DeleteMapping("/{id}")

  public ResponseEntity<Autor> deleteautor(@PathVariable String id) {
      Autor autoraux = autorService.deleteById(id);
      return ResponseEntity.status(HttpStatus.OK).body(autoraux);
  }


  @GetMapping("nombre/{nombre}")

  public ResponseEntity<List<Autor>> getByName(@PathVariable String nombre){
    List<Autor> autores = autorService.getAutorByNombre(nombre);
    return ResponseEntity.status(HttpStatus.OK).body(autores);
  }

  @GetMapping("nacimiento/{nacimiento}")
  public ResponseEntity<List<Autor>> getByNacimiento(@PathVariable LocalDateTime nacimiento){
    List<Autor> autores = autorService.getAutorByNacimiento(nacimiento);
    return ResponseEntity.status(HttpStatus.OK).body(autores);
  }
}
