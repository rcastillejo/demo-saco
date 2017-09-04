/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sacooliveros.security.login.mapper;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.sacooliveros.security.login.bean.Matricula;
import java.io.IOException;

/**
 *
 * @author ricardo
 */
public class JsonMapper {

    private final ObjectMapper mapper;

    public JsonMapper() {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);

    }

    public Matricula mapIn(String json) throws IOException {
        Matricula matricula = mapper.readValue(json, Matricula.class);
        return matricula;
    }

    public String mapOut(Matricula matricula) throws JsonProcessingException {
        String json = mapper.writeValueAsString(matricula);
        return json;
    }
}
