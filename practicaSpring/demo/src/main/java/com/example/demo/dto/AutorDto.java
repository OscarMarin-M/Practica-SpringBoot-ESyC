package com.example.demo.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AutorDto {

  private String nombre;
  private String pais_origen;
  private String sexo;
  private LocalDateTime nacimiento;
  private String defuncion;
}
