
package apilolpi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JOptionPane;
import java.net.MalformedURLException;
import org.json.JSONObject;


public class APIlolPI {

    
    public static void main(String[] args)throws MalformedURLException, IOException{
        
        String summonerName = JOptionPane.showInputDialog("Digite seu nome de invocador");
        String server = JOptionPane.showInputDialog("Digite seu servidor");
        
        URL lolApiSite;
        lolApiSite = new URL("https://"+server+"1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+summonerName+"?api_key=RGAPI-d47a10c3-04ff-4432-a2db-101fbd42bb75");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(lolApiSite.openStream()));
        String lerApi = in.readLine();
        
        System.out.println(lerApi);
        
        JSONObject ApiSN = new JSONObject(lerApi);
        
        
        System.out.println("nome de invocador: " + (ApiSN.getString("name")));
        System.out.println("id do invocador: " + (ApiSN.getInt("id")));
        System.out.println("level do invocador: " + (ApiSN.getInt("summonerLevel")));
        

    }
    
}
