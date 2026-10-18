package com.krakedev.fitzone.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.krakedev.fitzone.entidades.Socio;
import com.krakedev.fitzone.services.ServicioSocio;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private ServicioSocio servicioSocio;

    @PostMapping
    public ResponseEntity<Socio> crearSocio(@RequestBody Socio socio) {
        try {
            Socio nuevoSocio = servicioSocio.crear(socio);
            return new ResponseEntity<>(nuevoSocio, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Reemplaza la línea anterior por esta:
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Socio>> listarSocios() {
        List<Socio> socios = servicioSocio.listar();
        return new ResponseEntity<>(socios, HttpStatus.OK);
    }

    @GetMapping("/estado")
    public ResponseEntity<List<Socio>> buscarPorEstado(@RequestParam boolean activo) {
        List<Socio> socios = servicioSocio.buscarPorEstado(activo);
        return new ResponseEntity<>(socios, HttpStatus.OK);
    }
}