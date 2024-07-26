/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controller;

import model.CategoriaDAO;

/**
 *
 * @author Propietario
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        System.out.println(categoriaDAO.todasLasCategorias());
        
        
    }
    
}
