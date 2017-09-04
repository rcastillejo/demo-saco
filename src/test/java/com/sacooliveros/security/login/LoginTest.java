/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.security.login;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author ricardo
 */
public class LoginTest {
    

    @Test
    public void testLogin() {
        //1. Configuracion
        String usuario = "admin";
        String contrasenia = "1234";
        Login login = new Login();
        //2. Ejecucion
        boolean exitoso = login.autenticar(usuario, contrasenia);
        //3. Verificacion
        assertTrue(exitoso);
    }
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test//usuario max 5 caracters
    public void testLoginWrongSizeUsername() {
        String usuario = "admin6";
        String contrasenia = "1234";
        Login login = new Login();
        //2. Ejecucion
        //Nueva!
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Usuario no puede ser mayor de 5 caracteres");
        
        login.autenticar(usuario, contrasenia);
        
        /* Antigua forma de valida
        try{
            login.autenticar(usuario, contrasenia);
            fail();
        }catch(Exception e){
            //3. Verificacion
            assertEquals("Usuario no puede ser mayor de 5 caracteres", e.getMessage());
        }*/
    }
    
}
