package Main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import ButtonsActions.InfoBouton;
import Caisses.Caisse;
import Fenetre.Fenetre;
import Simulateur.Simulateur;

public class Main {
	

	public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Caisse>> data_AL = new ArrayList<ArrayList<Caisse>>();
        data_AL = importTheJSON();        
		InfoBouton infoBouton = new InfoBouton();
		Fenetre fenetre = new Fenetre(data_AL, infoBouton);
        infoBouton.addObserver(fenetre);
        fenetre.paint();
        Simulateur simulateur = new Simulateur (fenetre, data_AL.size(), infoBouton);
	}
	
	public static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
	
	
	public static ArrayList<ArrayList<Caisse>> importTheJSON(){
		String name,status, statusClient;
        double max_speed, avg_speed, theta_s;
        int total_clients, happy_client, unhappy_client;        
		
		JSONParser parser = new JSONParser();
		
        JSONArray jsonDataArray;
        JSONArray jsonCaisseArray;
        JSONArray jsonClientsArray;
        
        ArrayList<ArrayList<Caisse>> data_AL = new ArrayList<ArrayList<Caisse>>();
        ArrayList<Caisse> ti_AL = new ArrayList<Caisse>(); 
        ArrayList<ArrayList<Object>> clients_AL = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> clientSeul_AL = new ArrayList<Object>();
        
        try {
        	String content = readFile("simulation/results.json", StandardCharsets.UTF_8);
            JSONObject jsonRootObject = new JSONObject(content);
            jsonDataArray = jsonRootObject.optJSONArray("data");
            
            // Pour tous les temps ti
            for(int i = 0; i < jsonDataArray.length(); i++){ 
            	// On sélectionne le jsonObject temps ti
            	JSONObject time_JSONobj = jsonDataArray.getJSONObject(i); 
            	ti_AL = new ArrayList<Caisse>();
            	// Le tableau des caisses
            	jsonCaisseArray = time_JSONobj.optJSONArray("checkouts");
            	// pour chaque caisse j
            	
            	for(int j = 0; j < jsonCaisseArray.length(); j++){ 
            		JSONObject caisse_JSONobj = jsonCaisseArray.getJSONObject(j);            		            		
            		name = caisse_JSONobj.optString("name");
            		status = caisse_JSONobj.optString("status");
            		max_speed = caisse_JSONobj.optDouble("max_speed");
            		avg_speed = caisse_JSONobj.optDouble("avg_speed");
            		total_clients = caisse_JSONobj.optInt("total_clients");
            		happy_client = caisse_JSONobj.optInt("happy_client");
            		unhappy_client = caisse_JSONobj.optInt("unhappy_client");

            		if(caisse_JSONobj.optJSONArray("clients") != null){
            			// Le tableau des clients
	            		jsonClientsArray = caisse_JSONobj.optJSONArray("clients"); 
	            		clients_AL = new ArrayList<ArrayList<Object>>();
	            		
	            		// pour chaque client k
	            		for(int k = 0; k < jsonClientsArray.length(); k++){ 
	            			JSONObject client_JSONobj = jsonClientsArray.getJSONObject(k);
	            			clientSeul_AL = new ArrayList<Object>();
	            			statusClient = client_JSONobj.optString("status");
	            			theta_s = client_JSONobj.optDouble("theta_s");
	            			clientSeul_AL.add(statusClient);
	            			clientSeul_AL.add(theta_s);
	            			clients_AL.add(clientSeul_AL);
	            		}
            		}else{
            			clients_AL = new ArrayList<ArrayList<Object>>();
            			clientSeul_AL = new ArrayList<Object>();
            			clientSeul_AL.add("fake");
            			clientSeul_AL.add(0.0);
            			clients_AL.add(clientSeul_AL);
            		}
            		ti_AL.add(new Caisse(name,status,avg_speed,max_speed,total_clients, happy_client, unhappy_client,clients_AL));
            		}
            	data_AL.add(ti_AL);
            }
            int a = 2 ;
          }catch (Exception e){
        	  e.printStackTrace();
          }
        return data_AL;
	}
}