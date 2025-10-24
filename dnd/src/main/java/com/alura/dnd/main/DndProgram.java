package com.alura.dnd.main;

import com.alura.dnd.models.spellModels.SpellData;
import com.alura.dnd.service.ConsumeApi;
import com.alura.dnd.service.ConvertData;

import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DndProgram {
    public static void encontrarClasse() {
        String exit = null;
        do {
            try {
                Scanner leitura = new Scanner(System.in);
                ConsumeApi consumeApi = new ConsumeApi();
                ConvertData convertData = new ConvertData();
                System.out.println("Digite qual feitiço procurar: ");
                String spell = leitura.nextLine().toLowerCase().replace(" ", "-");
                exit = spell;
                String json = consumeApi.getData("https://api.open5e.com/v2/spells/a5e-ag_" + spell + "/");
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
