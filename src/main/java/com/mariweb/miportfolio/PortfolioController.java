package com.mariweb.miportfolio;

import clases.Portfolio;
import java.sql.SQLException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import persistencia.PortfolioDAO;

@RestController
@RequestMapping("/api")
public class PortfolioController {

    @GetMapping("/portfolio/persona/{codigoPersona}")
    public Portfolio obtenerPortfolioPorCodigoPersona(@PathVariable int codigoPersona) 
            throws SQLException {
        PortfolioDAO portfolioDAO = new PortfolioDAO();
        return portfolioDAO.obtenerPortfolioPorCodigoPersona(codigoPersona);
    }
}

//gg