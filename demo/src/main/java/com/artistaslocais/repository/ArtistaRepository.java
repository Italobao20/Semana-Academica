package com.artistaslocais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.artistaslocais.model.Artista;
import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {  
    // Busca usuário por email 
    Optional<Artista> findByEmail(String email);
    
    // Verifica se email já existe
    boolean existsByEmail(String email);
    
    // Verifica se CPF já existe 
    boolean existsByCPF(String cpf);
    
    // Busca usuário por CPF
    Optional<Artista> findByCPF(String cpf); 

    List<Artista> findByTipoArteContainingIgnoreCase(String tipoArte);
    
}
