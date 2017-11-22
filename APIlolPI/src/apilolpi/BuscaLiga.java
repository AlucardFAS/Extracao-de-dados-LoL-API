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
public class BuscaLiga {
    
    int wins,losses,pdls;
    String ln,tier,rank,queue;
    
    BuscaLiga (int id, String server) throws MalformedURLException, IOException {
        URL lolApiLigas = new URL("https://"+server+"1.api.riotgames.com/lol/league/v3/positions/by-summoner/"+id+"?api_key=RGAPI-a6039025-1302-445d-9b06-205b197b6ddc");
        BufferedReader readLeague = new BufferedReader(new InputStreamReader(lolApiLigas.openStream()));
        String lerApi3 = readLeague.readLine();
        
        JSONArray ApiArrLiga = new JSONArray(lerApi3);
        
        for (int i = 0; i < ApiArrLiga.length(); i++) {
            JSONObject elo =  ApiArrLiga.getJSONObject(i);
            
            wins = elo.getInt("wins");
            losses = elo.getInt("losses");
            pdls = elo.getInt("leaguePoints");
            
            ln = elo.getString("leagueName");
            tier = elo.getString("tier");
            rank = elo.getString("rank");
            queue = elo.getString("queueType");
            
            
            System.out.println(queue);
            System.out.println(tier+":"+rank+" -- "+ln);
            System.out.println("partidas vencidas: "+wins);
            System.out.println("partidas perdidas: "+losses);
            System.out.println("pontos: "+pdls);
            System.out.println(" ");
            
           
        }
        
        //System.out.println(ApiArrLiga);
    }
    
}
