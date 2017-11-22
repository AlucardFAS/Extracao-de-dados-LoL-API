/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apilolpi;

import java.awt.Label;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class BuscaJogador {
    
        String nome;
        int id;
        int level;
        int accountId;
    
    public void BuscaJogador () throws MalformedURLException, IOException{
        
    
        String summonerName = JOptionPane.showInputDialog("Digite seu nome de invocador");
        String server = JOptionPane.showInputDialog("Digite seu servidor");
        
        URL lolApiName = new URL("https://"+server+"1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+summonerName+"?api_key=RGAPI-c566d7d3-c9e4-4c0f-8f4b-b1927d145ee7");
        
        BufferedReader readName = new BufferedReader(new InputStreamReader(lolApiName.openStream()));
        String lerApi = readName.readLine();
        
        
        
        JSONObject ApiSN = new JSONObject(lerApi);
        
        this.nome = ApiSN.getString("name");
        this.id = ApiSN.getInt("id");
        this.level = ApiSN.getInt("summonerLevel");
        this.accountId = ApiSN.getInt("accountId");
        
        System.out.println("nome de invocador: "+nome);
        System.out.println("id do invocador: "+id);
        System.out.println("level do invocador: "+level);
        
        
        BuscaMatches partida = new BuscaMatches(this.accountId,server);
        
        
    }
    
    
}
