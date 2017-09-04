/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.security.login.mapper;

import com.sacooliveros.security.login.bean.Matricula;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author ricardo
 */
public class JsonMapperTest {
     
    private JsonMapper mapper;
    
    @Before
    public void setUp(){
        mapper = new JsonMapper();
    }
    
    @Test
    public void testMapIn() throws IOException {
        String json = "{"
                + "\"codigo\":\"123456\", "
                + "\"precio\":\"123.89\", "
                + "\"fechaMatricula\":\"01-09-2017\", "
                + "\"fechaCreacion\":\"2017-09-03T21:45:37.000Z\", "
                + "\"fechaActualizacion\":\"2017-09-03T22:54:59.000Z\""
                + "}";
        
        Matricula resultado = mapper.mapIn(json);
        assertNotNull(resultado);
        assertEquals("123456", resultado.getCodigo());
        assertEquals(new Double(123.89), resultado.getPrecio());
        assertNotNull(resultado.getFechaMatricula());
        assertNotNull(resultado.getFechaCreacion());
        assertNotNull(resultado.getFechaActualizacion());
    }
    
    
    @Test
    public void testMapOut() throws IOException {
        Matricula matricula = new Matricula();
        matricula.setCodigo("123456");
        matricula.setPrecio(123.89);
        Calendar calendar = Calendar.getInstance();
        matricula.setFechaMatricula(calendar.getTime());
        matricula.setFechaCreacion(calendar.getTime());
        matricula.setFechaActualizacion(calendar.getTime());
        
        String resultado = mapper.mapOut(matricula);
        assertNotNull(resultado);
    }
    
}
