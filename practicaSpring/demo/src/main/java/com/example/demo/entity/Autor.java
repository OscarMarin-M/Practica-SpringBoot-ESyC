package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="autors")
public class Autor {
  @Id
  @Column(columnDefinition = "varchar(50) not null")
  private String id;
  private String nombre;
  private String pais_origen;
  private String sexo;
  private LocalDateTime nacimiento;
  private String defuncion;
}