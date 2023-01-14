package Controlador;

import Modelo.*;
import Vista.*;
import com.mongodb.MongoException;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
               
               vEstadisticas.jLabelNTweetsAlmacenados.setText(String.valueOf(tweetDAO.numTweets()) + " tweets");
               
               vEstadisticas.jLabelUsername.setText(tweetDAO.usuarioConMasSeguidores().getUsername());
               vEstadisticas.jLabelNFollowers.setText(String.valueOf(tweetDAO.usuarioConMasSeguidores().getFollowers()));
               
               vEstadisticas.jLabelFechaMasReciente.setText(tweetDAO.fechaMasReciente().toString());
               vEstadisticas.jLabelFechaMenosReciente.setText(tweetDAO.fechaMenosReciente().toString());
               
               List<Map.Entry<String, Integer>> lista = tweetDAO.usuariosMasMencionados();
               vEstadisticas.jLabelUsuarioConMasSeguidores1.setText(lista.get(0).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores2.setText(lista.get(1).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores3.setText(lista.get(2).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores4.setText(lista.get(3).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores5.setText(lista.get(4).toString() + " seguidores");
               
               ArrayList<String> hashtagsMasUtilizados = tweetDAO.hashtagsMasUtilizados();
               vEstadisticas.jLabelHashtagMasUtilizado1.setText(hashtagsMasUtilizados.get(0));
               vEstadisticas.jLabelHashtagMasUtilizado2.setText(hashtagsMasUtilizados.get(1));
               vEstadisticas.jLabelHashtagMasUtilizado3.setText(hashtagsMasUtilizados.get(2));
               vEstadisticas.jLabelHashtagMasUtilizado4.setText(hashtagsMasUtilizados.get(3));
               vEstadisticas.jLabelHashtagMasUtilizado5.setText(hashtagsMasUtilizados.get(4));
               
               vEstadisticas.jLabelNumeroIdiomasDiferentes.setText(String.valueOf(tweetDAO.numeroIdiomasDiferentes()));
               
               ArrayList<String> idiomasMasFrecuentes = tweetDAO.idiomasMasFrecuentes();
               vEstadisticas.jLabelIdiomaMasUtilizado1.setText(idiomasMasFrecuentes.get(0));
               vEstadisticas.jLabelIdiomaMasUtilizado2.setText(idiomasMasFrecuentes.get(1));
               vEstadisticas.jLabelIdiomaMasUtilizado3.setText(idiomasMasFrecuentes.get(2));
               vEstadisticas.jLabelIdiomaMasUtilizado4.setText(idiomasMasFrecuentes.get(3));
               vEstadisticas.jLabelIdiomaMasUtilizado5.setText(idiomasMasFrecuentes.get(4));
               
               vEstadisticas.jLabelNumeroRTs.setText(String.valueOf(tweetDAO.numeroDeRT()) + " RTs");
               
               vEstadisticas.jLabelNUsuariosDiferentes.setText(String.valueOf(tweetDAO.numeroDeUsuariosDiferentes()) + " usuarios");
               
               ArrayList<String> usuariosConMasTweets = tweetDAO.usuariosFrecuenciaTweets();
               vEstadisticas.jLabelUsuarioConMasTweets1.setText(usuariosConMasTweets.get(0));
               vEstadisticas.jLabelUsuarioConMasTweets2.setText(usuariosConMasTweets.get(1));
               vEstadisticas.jLabelUsuarioConMasTweets3.setText(usuariosConMasTweets.get(2));
               vEstadisticas.jLabelUsuarioConMasTweets4.setText(usuariosConMasTweets.get(3));
               vEstadisticas.jLabelUsuarioConMasTweets5.setText(usuariosConMasTweets.get(4));

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
