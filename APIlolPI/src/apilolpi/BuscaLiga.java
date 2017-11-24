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
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author victor.etrindade
 */
public class BuscaLiga {
    
    int wins,losses,pdls,wins2,losses2,pdls2;
    int winrate;
    String ln,tier,rank,queue,ln2,tier2,rank2,queue2;
    
    BuscaLiga (int id, String server) throws MalformedURLException, IOException {
        //criando conexao com a API
        URL lolApiLigas = new URL("https://"+server+"1.api.riotgames.com/lol/league/v3/positions/by-summoner/"+id+"?api_key=RGAPI-9f6b7394-cf1d-4866-a663-44b2bcb18633");
       
        //criando buffer para ler e armazenar todos os dados da api 
        BufferedReader readLeague = new BufferedReader(new InputStreamReader(lolApiLigas.openStream()));
        String lerApi3 = readLeague.readLine();
        
        //criando array do json da informações buscadas para o armazenamento
        JSONArray ApiArrLiga = new JSONArray(lerApi3);
        
        for (int i = 0; i < ApiArrLiga.length(); i++) {
            JSONObject elo =  ApiArrLiga.getJSONObject(i);//criando um objeto json para cada array encontrado 
            
            /*Armazena nas variaveis apenas os dados que queremos trabalhar.
            No JSON pedimos para armazenar os dado que está em sequencia do nosso parametro*/
            if(i==0){
                wins = elo.getInt("wins");//armazendo o número de vitorias do invocador. Exemplo no json ={\"wins\" : \"nº_vitorias\"}
                losses = elo.getInt("losses");//armazendo o número de derrotas do invocador. Exemplo no json ={\"losses\" : \"nº_derrotas\"}
                pdls = elo.getInt("leaguePoints");//armazendo os pontos do invocador. Exemplo no json ={\"leaguePoints\" : \"pontos\"}
            
                ln = elo.getString("leagueName");//armazendo o nome da liga do invocador. Exemplo no json ={\"leagueName\" : \"nome\"}
                tier = elo.getString("tier");//armazendo em qual camada da liga em que está o invocador. Exemplo no json ={\"tier\" : \"GOLD\"}
                rank = elo.getString("rank");//armazendo o rank da liga em que está o invocador. Exemplo no json ={\"rank\" : \"III\"}
                queue = elo.getString("queueType");//armazendo o tipo da liga de vitorias do invocador. Exemplo no json ={\"queueType\" : \"RANKED_SOLO\"}
            }
            if(i==1){
                wins2 = elo.getInt("wins");//armazendo o número de vitorias do invocador. Exemplo no json ={\"wins\" : \"nº_vitorias\"}
                losses2 = elo.getInt("losses");//armazendo o número de derrotas do invocador. Exemplo no json ={\"losses\" : \"nº_derrotas\"}
                pdls2 = elo.getInt("leaguePoints");//armazendo os pontos do invocador. Exemplo no json ={\"leaguePoints\" : \"pontos\"}
            
                ln2 = elo.getString("leagueName");//armazendo o nome da liga do invocador. Exemplo no json ={\"leagueName\" : \"nome\"}
                tier2 = elo.getString("tier");//armazendo em qual camada da liga em que está o invocador. Exemplo no json ={\"tier\" : \"GOLD\"}
                rank2 = elo.getString("rank");//armazendo o rank da liga em que está o invocador. Exemplo no json ={\"rank\" : \"III\"}
                queue2 = elo.getString("queueType");//armazendo o tipo da liga de vitorias do invocador. Exemplo no json ={\"queueType\" : \"RANKED_SOLO\"}
             
            }
            
            
            //printa os dados que queremos
            /*System.out.println(Arrays.toString(queue));
            System.out.println(Arrays.toString(tier)+":"+Arrays.toString(rank)+" -- "+Arrays.toString(ln));
            System.out.println("partidas vencidas: "+Arrays.toString(wins));
            System.out.println("partidas perdidas: "+Arrays.toString(losses));
            System.out.println("pontos: "+Arrays.toString(pdls));
            System.out.println(" ");*/
            
           
        }
        
        
    }
    
}
