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
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class BuscaJogador extends MostraInvocador {
    
        public String nome;
        public int id;
        public int level;
        public int accountId;
        public String server;
    
    protected void BuscaJogador () throws MalformedURLException, IOException{
        String summonerName = JOptionPane.showInputDialog("Digite seu nome de invocador");//crianda caixa de texto para armazenar nome do invocador
        server = JOptionPane.showInputDialog("Digite seu servidor");//caixa para armazenar o server
        
        //criando conexao com a API
        URL lolApiName = new URL("https://"+server+"1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+summonerName+"?api_key=RGAPI-9bcd74a7-e1b1-43ed-9a69-ed37973cd0b7");//url da api com a chave para o acesso
        
        //criando buffer para ler e armazenar todos os dados da api 
        BufferedReader readName = new BufferedReader(new InputStreamReader(lolApiName.openStream()));
        String lerApi = readName.readLine();
        
        //criando objeto json da informações buscadas para o armazenamento
        JSONObject ApiSN = new JSONObject(lerApi);
        
        /*Armazena nas variaveis apenas os dados que queremos trabalhar.
        No JSON pedimos para armazenar os dado que está em sequencia do nosso parametro*/
        this.nome = ApiSN.getString("name");//armazendo o nome do invocador. Exemplo no json ={\"name\" : \"nome_do_invocador\"} 
        this.id = ApiSN.getInt("id");//armazendo o id do invocador. Exemplo no json ={\"id\" : \"id_do_invocador\"} 
        this.level = ApiSN.getInt("summonerLevel");//armazendo o level do invocador. Exemplo no json ={\"summonerLeval\" : \"level_do_invocador\"} 
        this.accountId = ApiSN.getInt("accountId");//armazendo o id da conta do invocador. Exemplo no json ={\"accountId\" : \"id_da_conta_do_invocador\"} 
        
        //printa os dados que queremos
        System.out.println("--------Invocador---------");
        System.out.println("nome de invocador: "+nome);
        System.out.println("id do invocador: "+id);
        System.out.println("level do invocador: "+level);
        
        
        
        //instância as classes com os dados necessarios para outra api como parametros dos metodos construtores 
        BuscaMatches partida = new BuscaMatches(this.accountId,server);
        BuscaLiga elo = new BuscaLiga(this.id,server);
        
    }
    
    
    
    
    
    protected void BuscaCompara () throws MalformedURLException, IOException{
        String summonerName = JOptionPane.showInputDialog("Digite o nome do invocador");//crianda caixa de texto para armazenar nome do invocador
        String server = JOptionPane.showInputDialog("Digite o servidor");//caixa para armazenar o server
        
        //criando conexao com a API
        URL lolApiName = new URL("https://"+server+"1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+summonerName+"?api_key=RGAPI-9bcd74a7-e1b1-43ed-9a69-ed37973cd0b7");//url da api com a chave para o acesso
        
        //criando buffer para ler e armazenar todos os dados da api 
        BufferedReader readName = new BufferedReader(new InputStreamReader(lolApiName.openStream()));
        String lerApi = readName.readLine();
        
        //criando objeto json da informações buscadas para o armazenamento
        JSONObject ApiSN = new JSONObject(lerApi);
        
        /*Armazena nas variaveis apenas os dados que queremos trabalhar.
        No JSON pedimos para armazenar os dado que está em sequencia do nosso parametro*/
        this.nome = ApiSN.getString("name");//armazendo o nome do invocador. Exemplo no json ={\"name\" : \"nome_do_invocador\"} 
        this.id = ApiSN.getInt("id");//armazendo o id do invocador. Exemplo no json ={\"id\" : \"id_do_invocador\"} 
        this.level = ApiSN.getInt("summonerLevel");//armazendo o level do invocador. Exemplo no json ={\"summonerLeval\" : \"level_do_invocador\"} 
        this.accountId = ApiSN.getInt("accountId");//armazendo o id da conta do invocador. Exemplo no json ={\"accountId\" : \"id_da_conta_do_invocador\"} 
        
        //printa os dados que queremos
        System.out.println("--------Invocador---------");
        System.out.println("nome de invocador: "+nome);
        System.out.println("id do invocador: "+id);
        System.out.println("level do invocador: "+level);

        
        //instância as classes com os dados necessarios para outra api como parametros dos metodos construtores 
        BuscaMatches partida = new BuscaMatches(this.accountId,server);
        BuscaLiga elo = new BuscaLiga(this.id,server);
        
    }
    
    
    
    
}
