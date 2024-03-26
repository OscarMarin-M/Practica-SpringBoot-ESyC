package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name ="libros")
public class Libro {

  @Id
  @Column(columnDefinition = "varchar(50) not null")
  private String id;
  private String titulo;
  private String apub;

@ManyToOne
  @JoinColumn(name = "autor_id")
  private Autor autor;
}
