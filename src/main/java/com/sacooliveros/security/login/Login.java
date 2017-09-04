/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.security.login;

/**
 *
 * @author ricardo
 */
public class Login {

    boolean autenticar(String usuario, String contrasenia) {
        if(usuario.length() > MAX_SIZE_USERNAME){
            throw new RuntimeException("Usuario no puede ser mayor de 5 caracteres");
        }
        return usuario.equals(ADMIN_USERNAME) && contrasenia.equals(ADMIN_PASSWORD);
    }
    private static final int MAX_SIZE_USERNAME = 5;
    private static final String ADMIN_PASSWORD = "1234";
    private static final String ADMIN_USERNAME = "admin";
    
}
