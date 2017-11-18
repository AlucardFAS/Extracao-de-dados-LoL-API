
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
        URL lolApiSite = new URL("https://"+server+".api.riotgames.com/lol/summoner/v3/summoners/by-name/"+summonerName);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(lolApiSite.openStream()));
        String lerApi = in.readLine();
        
        JSONObject ApiSN = new JSONObject(lerApi);
        
        String nome = ApiSN.getJSONObject(summonerName).getString("name");
        int level = ApiSN.getJSONObject(summonerName).getInt("summonerLevel");
        int id = ApiSN.getJSONObject(summonerName).getInt("id");
        int accountId = ApiSN.getJSONObject(summonerName).getInt("accountId");
        
        
        buscaDados jogador = new buscaDados();

    }
    
}
