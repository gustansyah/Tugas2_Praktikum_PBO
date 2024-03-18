/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gustansyah.javaswing;

import javax.swing.SwingUtilities;

/**
 *
 * @author Gustansyah
 */
public class Javaswing {
    
     public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true); // Tampilkan frame LoginPage
        });
       
    }
    
}
