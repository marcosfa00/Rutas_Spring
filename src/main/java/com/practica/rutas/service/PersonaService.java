package com.practica.rutas.service;

import com.practica.rutas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService {
    private final List<Persona> personas = new ArrayList<>();

    public void add(Persona persona) {
        personas.add(persona);
    }
    public List<Persona> getPersonas(){
        return personas;
    }

    public Persona getPrimeraPersona(){
        return personas.get(0);
    }
}
