/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.mariweb.miportfolio;

import clases.Item;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import persistencia.ItemDAO;

/**
 *
 * @author Daskalos
 */
@RestController
@RequestMapping("/api")
public class ItemController {

    ItemDAO itemDAO = new ItemDAO();

    @GetMapping("/listar-items")
    public List<Item> getItems() throws SQLException {
        return itemDAO.listarItems();
    }

    @GetMapping("/obtener-item/{codigo}")
    public ResponseEntity<Item> obtenerItemPorCodigo(@PathVariable int codigo) throws SQLException {
        Item item = itemDAO.obtenerPorCodigo(codigo);
        if (item != null) {
            return new ResponseEntity<>(item, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear-item")
    public ResponseEntity<Item> crearItem(@RequestBody Item item) {
        itemDAO.crearItem(item);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

@PutMapping("/actualizar-item/{codigo}")
public ResponseEntity<Item> actualizarItem(@PathVariable int codigo, @RequestBody Item item) {
    Item currentItem;
    try {
        currentItem = itemDAO.obtenerPorCodigo(codigo);
        if (currentItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentItem.setNombre(item.getNombre());
        currentItem.setTitulo(item.getTitulo());
        currentItem.setPeriodo(item.getPeriodo());
        currentItem.setDescripcion(item.getDescripcion());
        currentItem.setUrl(item.getUrl());
        currentItem.setNivel_progreso(item.getNivel_progreso());
        currentItem.setCodigo_persona(item.getCodigo_persona());
        currentItem.setCodigo_seccion(item.getCodigo_seccion());
        itemDAO.actualizarItem(currentItem);
        return new ResponseEntity<>(currentItem, HttpStatus.OK);
    } catch (SQLException e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    @DeleteMapping("/eliminar-item/{codigo}")
    public ResponseEntity<Void> eliminarItem(@PathVariable int codigo) {
        try {
            itemDAO.eliminarItem(codigo);
            System.out.println("Eliminó un item");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
