
package apilolpi;

import java.io.IOException;
import java.net.MalformedURLException;


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
