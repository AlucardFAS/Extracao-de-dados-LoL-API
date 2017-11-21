
package apilolpi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public class BuscaMatches {

    String lane;

    BuscaMatches(int id, String server)throws MalformedURLException, IOException
    {
        URL lolApiMatches = new URL("https://"+server+"1.api.riotgames.com/lol/match/v3/matchlists/by-account/"+id+"?api_key=RGAPI-b9b9033d-86e6-4e21-be14-4f08ceadd960");
        BufferedReader readMatches = new BufferedReader(new InputStreamReader(lolApiMatches.openStream()));
        String lerApi2 = readMatches.readLine();
        
        JSONObject ApiMCH = new JSONObject(lerApi2);
        
        
        
        
        
        
        
        System.out.println(lerApi2);
        
    }
    
    
}
