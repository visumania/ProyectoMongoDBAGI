package Controlador;

import Modelo.*;
import Vista.*;
import com.mongodb.MongoException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener
{
    private Conexion conexion = null;
    
    private VistaMensajes vMensajes = null;
    private VistaPrincipal vPrincipal = null;
    
    private TweetDAO tweetDAO = null;
    
    public Controlador(Conexion conexion)
    {
        this.conexion = conexion;
        vMensajes = new VistaMensajes();
        vPrincipal = new VistaPrincipal();
        
        tweetDAO = new TweetDAO(conexion);
        
        addListeners();
        
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
        /*vPrincipal.dibujarTablaTweets(vPrincipal);
        vPrincipal.jLabelNTweetsAlmacenados.setText(String.valueOf(tweetDAO.numTweets()));
        pideTweets();*/
        
    }
    
    private void addListeners()
    {
        vPrincipal.jMenuItemSalir.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
       switch(e.getActionCommand())
       {
           case "CerrarVentanaPrincipal":
               vPrincipal.dispose();
               System.exit(0);
               break;
       }
    }
    
    private void pideTweets() throws MongoException
    {
        ArrayList<Tweet> lTweets = tweetDAO.listaTweets();
        vPrincipal.vaciarTablaTweets();
        vPrincipal.rellenarTablaTweets(lTweets);
    }
}
