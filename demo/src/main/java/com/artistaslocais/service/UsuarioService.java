package com.artistaslocais.service;

import com.artistaslocais.model.Artista;
import com.artistaslocais.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private ArtistaRepository usuarioRepository;

    public Artista save(Artista usuario) throws DataIntegrityViolationException {
        if (usuarioRepository.existsByCPF(usuario.getCPF())) {
            throw new DataIntegrityViolationException("CPF já cadastrado");
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new DataIntegrityViolationException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }
}