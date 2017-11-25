/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apilolpi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author victor.etrindade
 */
public class BuscaCampeao {
    
    String nomeCamp;
    int lvlMst, mstPoints, championId;

    BuscaCampeao(String server, int sId, String key) throws MalformedURLException, IOException {
        
        //criando conexao com a API
        URL lolApiChampionMsr = new URL("https://"+server+"1.api.riotgames.com/lol/champion-mastery/v3/champion-masteries/by-summoner/"+sId+"?api_key="+key);
        
        //criando buffer para ler e armazenar todos os dados da api 
        BufferedReader readChampMast = new BufferedReader(new InputStreamReader(lolApiChampionMsr.openStream()));
        String lerApi5 = readChampMast.readLine();
        
        //criando array json da informações buscadas para o armazenamento
        JSONArray mastery = new JSONArray(lerApi5);
        
        for (int i = 0; i < 1; i++) {
            JSONObject mst = mastery.getJSONObject(i);//criando um objeto json para cada array encontrado
            
            /*Armazena nas variaveis apenas os dados que queremos trabalhar.
            No JSON pedimos para armazenar os dado que está em sequencia do nosso parametro*/
            lvlMst = mst.getInt("championLevel");//armazendo o level de maestria do principal campeão do invocador. Exemplo no json ={\"championLevel\" : \"level_de_maestria\"}
            mstPoints = mst.getInt("championPoints");//armazendo os pontos de maestria do principal campeão do invocador. Exemplo no json ={\"championPoints\" : \"pontos_de_maestria\"}
            championId = mst.getInt("championId");//armazendo o id do principal campeão do invocador. Exemplo no json ={\"championId\" : \"id_do_campeão\"}
        }
        
        
        URL lolApiChampion = new URL("https://"+server+"1.api.riotgames.com/lol/static-data/v3/champions/"+championId+"?locale=pt_BR&api_key="+key);
        
        BufferedReader readChampions = new BufferedReader(new InputStreamReader(lolApiChampion.openStream()));
        String lerApi4 = readChampions.readLine();
        
        JSONObject champ = new JSONObject(lerApi4);
        
        nomeCamp = champ.getString("name");
        
        
        /*System.out.println("nome do campeão: "+nomeCamp);
        System.out.println("nivel de maestria: "+lvlMst);
        System.out.println("pontos de maestria: "+mstPoints);*/
        
    }
    
    
}
