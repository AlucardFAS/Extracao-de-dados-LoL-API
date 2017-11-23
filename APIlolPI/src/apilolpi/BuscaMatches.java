
package apilolpi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class BuscaMatches {

    String lanes,champions;
    int top, jungle, mid, bottom = 0;

    BuscaMatches(int id, String server)throws MalformedURLException, IOException
    {
        URL lolApiMatches = new URL("https://"+server+"1.api.riotgames.com/lol/match/v3/matchlists/by-account/"+id+"?api_key=RGAPI-9bcd74a7-e1b1-43ed-9a69-ed37973cd0b7");
        BufferedReader readMatches = new BufferedReader(new InputStreamReader(lolApiMatches.openStream()));
        String lerApi2 = readMatches.readLine();
        
        JSONObject ApiMCH = new JSONObject(lerApi2);
        JSONArray ApiArrMCHs = ApiMCH.getJSONArray("matches");
        
        for (int i = 0; i < ApiArrMCHs.length(); i++) {
            
            JSONObject lane = ApiArrMCHs.getJSONObject(i);
            
            lanes = lane.getString("lane");
            if ("TOP".equals(lanes)){
                top += 1;
            }
            if ("JUNGLE".equals(lanes)){
                jungle += 1;
            }
            if ("MID".equals(lanes)){
                mid += 1;
            }
            if ("BOTTOM".equals(lanes)){
                bottom += 1;
            }
        }
        /*System.out.println("--------partidas---------");
        System.out.println("jogos de TOP: "+top);
        System.out.println("jogos de JUNGLE: "+jungle);
        System.out.println("jogos de MID: "+mid);
        System.out.println("jogos no BOT: "+bottom);
        System.out.println("--------Elo---------");*/
    }
    
    
}
