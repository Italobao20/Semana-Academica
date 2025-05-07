package com.artistaslocais.controller;

import com.artistaslocais.model.Artista;
import com.artistaslocais.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios") 
public class ArtistaController {
    
    @Autowired
    private ArtistaRepository artistaRepository; // Nome consistente
    
    // Cadastrar artista
    @PostMapping
    public ResponseEntity<?> criarArtista(@Valid @RequestBody Artista artista, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        
        try {
            if (artistaRepository.existsByCPF(artista.getCPF())) {
                return ResponseEntity.badRequest().body("Erro: CPF já cadastrado!");
            }
            
            if (artistaRepository.existsByEmail(artista.getEmail())) {
                return ResponseEntity.badRequest().body("Erro: Email já está em uso!");
            }
            
            Artista artistaSalvo = artistaRepository.save(artista);
            return ResponseEntity.ok(artistaSalvo);
            
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Erro: Violação de integridade de dados");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                .body("Erro ao cadastrar artista: " + e.getMessage());
        }
    }
    
    // Busca por tipo de arte
    @GetMapping("/tipo/{tipoArte}")
    public List<Artista> buscarPorTipo(@PathVariable String tipoArte) {
        return artistaRepository.findByTipoArteContainingIgnoreCase(tipoArte);
    }

    // Listar todos
    @GetMapping
    public List<Artista> listarArtistas() {
        return artistaRepository.findAll();
    }
}