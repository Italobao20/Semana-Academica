package com.artistaslocais.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@Entity
@Table(name = "usuarios")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 60)
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Column(name = "CPF", nullable = false, length = 11, unique = true)
    @NotBlank(message = "CPF é obrigatório")
    @JsonProperty("CPF")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    private String CPF;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('M', 'F')")
    private Sexo sexo;

    public enum Sexo{
        M, F
    }

    @Column(name = "nascimento", nullable = false)
    private LocalDate nascimento;

    @Column(length = 60, unique = true, nullable = false)
    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @Column(nullable = false)
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")

    @NotBlank(message = "Senha é Obrigatória")
    private String senha;

    @Column(name = "local_exposicao", length = 100)
    @NotBlank(message = "Local de exposição é obrigatório")
    private String localExposicao; 

    @Column(length = 20)
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "Formato: (XX) XXXXX-XXXX")
    private String contatoArtista; 

    @Column(length = 500)  
    private String biografia;  

    @Column(name = "tipo_arte")  
    private String tipoArte;     
}