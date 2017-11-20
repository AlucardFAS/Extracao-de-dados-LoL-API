
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
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InterfaceGrafica().setVisible(true);
            }
        });

    }

    
    
}
