package com.alura.dnd.models.spellModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public record SpellData(String url,
                        String name,
                        @JsonProperty("school") School school,
                        int level,
                        String higher_level,
                        boolean ritual,
                        String range_text,
                        Integer range,
                        String casting_time,
                        boolean verbal,
                        boolean somatic,
                        String material_specified,
                        String duration,
                        String desc) {

    @Override
    public String toString(){
        return "\nUrl: " + url + "\n" +
                "Magic School: " + school.name() + "\n" +
                "Name: " + name + "\n" +
                "Spell Level: " + level + "\n" +
                "Casting Time: " + casting_time + "\n" +
                "Range: " + range_text + "(" + String.format("%.2f", (double) range * 0.3048) + " meters)" + "\n" +
                "Components: " + (verbal == true ? "V " : "") + (somatic == true ? "S " : " ") + "\n" +
                "Material: " + (material_specified == null ? material_specified : "none") + "\n" +
                "Duration: " + duration + "\n" +
                "Description: \n" +
                "--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
                + desc + "\n\n" +
                (higher_level == null ? "" : "At higher levels: ") + higher_level +
                "\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
    }
}
