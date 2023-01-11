package Controlador;

import Modelo.*;
import Vista.*;
import com.mongodb.MongoException;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener
{
    private Conexion conexion = null;
    
    private VistaMensajes vMensajes = null;
    private VistaPrincipal vPrincipal = null;
    private VistaEstadisticas vEstadisticas = null;
    private VistaConsultas vConsultas = null;
    private VistaPorDefecto vPorDefecto = null;
    
    private TweetDAO tweetDAO = null;
    
    public Controlador(Conexion conexion)
    {
        this.conexion = conexion;
        vMensajes = new VistaMensajes();
        vPrincipal = new VistaPrincipal();
        vEstadisticas = new VistaEstadisticas();
        vConsultas = new VistaConsultas();
        vPorDefecto = new VistaPorDefecto();
        
        tweetDAO = new TweetDAO(conexion);
        
        addListeners();
        
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
        
        vPrincipal.getContentPane().setLayout(new CardLayout());
        vPrincipal.add(vEstadisticas);
        vEstadisticas.setVisible(false);
        
        vPrincipal.getContentPane().setLayout(new CardLayout());
        vPrincipal.add(vConsultas);
        vConsultas.setVisible(false);
        
        vPrincipal.getContentPane().setLayout(new CardLayout());
        vPrincipal.add(vPorDefecto);
        vPorDefecto.setVisible(true);
        /*vPrincipal.dibujarTablaTweets(vPrincipal);
        vPrincipal.jLabelNTweetsAlmacenados.setText(String.valueOf(tweetDAO.numTweets()));
        pideTweets();*/
        
    }
    
    private void addListeners()
    {
        vPrincipal.jMenuItemSalir.addActionListener(this);
        vPrincipal.jMenuItemEstadisticas.addActionListener(this);
        vPrincipal.jMenuItemConsultas.addActionListener(this);
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
               
           case "Consultas":
               vConsultas.setVisible(true);
               vEstadisticas.setVisible(false);
               break;
               
           case "Estadisticas":
               vEstadisticas.setVisible(true);
               vConsultas.setVisible(false);
               
              vEstadisticas.jLabelNTweetsAlmacenados.setText(String.valueOf(tweetDAO.numTweets()));
               break;
       }
    }
    
    /*private void pideTweets() throws MongoException
    {
        ArrayList<Tweet> lTweets = tweetDAO.listaTweets();
        vPrincipal.vaciarTablaTweets();
        vPrincipal.rellenarTablaTweets(lTweets);
    }*/
}
