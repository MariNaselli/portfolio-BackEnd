/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.mariweb.miportfolio;

import clases.Persona;
import java.sql.SQLException;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PostMapping;
>>>>>>> main
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import persistencia.PersonaDAO;

/**
 *
 * @author Daskalos
 */
@RestController
@RequestMapping("/api")
public class PersonaController {

    @GetMapping("/listar-personas")
    public List<Persona> getPersonas() throws SQLException {
<<<<<<< HEAD
        PersonaDAO personaDAO = new PersonaDAO();
=======
        PersonaDAO personaDAO = null;
>>>>>>> main
        return personaDAO.listarPersonas();
    }

    @GetMapping("/obtener-persona/{codigo}")
    @SuppressWarnings("CallToPrintStackTrace")
    public ResponseEntity<Persona> obtenerPersonaPorId(@PathVariable int codigo) {
        PersonaDAO personaDAO = new PersonaDAO();
        try {
            Persona persona = personaDAO.obtenerPorCodigo(codigo);
            if (persona != null) {
                return new ResponseEntity<>(persona, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/actualizar-persona")
    public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona) {
        PersonaDAO personaDAO = new PersonaDAO();
        try {
            personaDAO.actualizarPersona(persona);
            return new ResponseEntity<>(persona, HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
