/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.mariweb.miportfolio;

import clases.Seccion;
import java.sql.SQLException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import persistencia.SeccionDAO;

/**
 *
 * @author Daskalos
 */
@RestController
@RequestMapping("/api")
public class SeccionController {

    @GetMapping("/seccion/{codigoSeccion}/persona/{codigoPersona}")
    public Seccion obtenerPorCodigoPersona(@PathVariable int codigoPersona, @PathVariable int codigoSeccion) throws SQLException {
        SeccionDAO seccionDAO = new SeccionDAO();
        return seccionDAO.obtenerPorCodigoPersona(codigoPersona, codigoSeccion);
    }
}
