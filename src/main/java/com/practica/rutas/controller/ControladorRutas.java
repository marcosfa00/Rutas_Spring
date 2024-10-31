package com.practica.rutas.controller;

import com.practica.rutas.model.Persona;
import com.practica.rutas.service.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class ControladorRutas {
    PersonaService personaService;
    public ControladorRutas(PersonaService personaService) {
        this.personaService = personaService;
    }
    @GetMapping()
    public Persona verPersonas() {
        Persona marcos = new Persona("Marcos","Fernandez Avendaño",null);
        personaService.add(marcos);
        return personaService.getPrimeraPersona();
    }



}
