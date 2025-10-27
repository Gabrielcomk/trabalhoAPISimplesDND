package com.alura.dnd.controller;

import com.alura.dnd.models.spellModels.SpellData;
import com.alura.dnd.service.ConsumeApi;
import com.alura.dnd.service.ConvertData;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class FindSpell {
    public static void findSpell() {
        String exit = null;
 final String HTTP = "https://api.open5e.com/v2/spells/a5e-ag_";

        do {
            try {
                Scanner read = new Scanner(System.in);
                ConsumeApi consumeApi = new ConsumeApi();
                ConvertData convertData = new ConvertData();
                System.out.println("Digite qual feitiço procurar: ");
                String spell = read.nextLine().toLowerCase().replace(" ", "-");
                exit = spell;
                String json = consumeApi.getData(HTTP + spell + "/");
                SpellData spellData = convertData.getData(json);
                System.out.println(spellData);
            } catch (Exception e){
                if (Objects.equals(exit, "0")) {
                    System.out.println("Finalizando.");
                } else{
                    System.out.println("Erro");
                }
                } finally {
                if(Objects.equals(exit,"0")) {
                    break;
                 }
                }
        } while (true);
    }
}
