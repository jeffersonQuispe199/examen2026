package com.krakedev.fitzone.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.repository.SocioRepository;

@Service
public class ServicioSocio {

    @Autowired
    private SocioRepository socioRepository;

    public Socio crear(Socio s) {
        // Regla de validación solicitada en el examen
        if (s.getEdad() < 14) {
            throw new IllegalArgumentException("La edad mínima permitida es 14 años.");
        }
        return socioRepository.save(s);
    }

    public List<Socio> listar() {
        return socioRepository.findAll();
    }

    public List<Socio> buscarPorEstado(boolean activo) {
        return socioRepository.findByActivo(activo);
    }
}