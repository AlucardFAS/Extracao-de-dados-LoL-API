
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
        
        URL lolApiName = new URL("https://"+server+"1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+summonerName+"?api_key=RGAPI-d47a10c3-04ff-4432-a2db-101fbd42bb75");
        
        BufferedReader readName = new BufferedReader(new InputStreamReader(lolApiName.openStream()));
        String lerApi = readName.readLine();
        
        
        
        JSONObject ApiSN = new JSONObject(lerApi);
        
        String nome = ApiSN.getString("name");
        int id = ApiSN.getInt("id");
        int level = ApiSN.getInt("summonerLevel");
        
        URL lolApiMatches = new URL("https://"+server+"1.api.riotgames.com/lol/match/v3/matchlists/by-account/"+ApiSN.getInt("accountId")+"?api_key=RGAPI-d47a10c3-04ff-4432-a2db-101fbd42bb75");
        BufferedReader readMatches = new BufferedReader(new InputStreamReader(lolApiMatches.openStream()));
        String lerApi2 = readMatches.readLine();
        
        JSONObject ApiMCH = new JSONObject(lerApi2);
        
        System.out.println("nome de invocador: " + nome);
        System.out.println("id do invocador: " + id);
        System.out.println("level do invocador: " + level);
        
        System.out.println(lerApi2);
        
        
        
        
        

    }

    
    
}
