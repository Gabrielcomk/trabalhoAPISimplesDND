package com.alura.dnd.service;

import com.alura.dnd.models.spellModels.SpellData;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData {
    private ObjectMapper mapper = new ObjectMapper();

    public SpellData getData(String json){
        try {
            return mapper.readValue(json, SpellData.class);
        } catch(Exception e){
            throw new RuntimeException("Error converting the JSON to Data");
        }
    }

}
