package Controlador;

import Modelo.*;
import Vista.*;
import com.mongodb.MongoException;
import com.mongodb.client.MongoIterable;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador implements ActionListener
{
    private Conexion conexion = null;
    
    private VistaMensajes vMensajes = null;
    private VistaPrincipal vPrincipal = null;
    private VistaEstadisticas vEstadisticas = null;
    private VistaConsultas vConsultas = null;
    private VistaPorDefecto vPorDefecto = null;
    private Vistas vistas = null;
    
    private TweetDAO tweetDAO = null;
    
    private MongoIterable<String> nColecciones = null;
    
    public Controlador(Conexion conexion)
    {
        this.conexion = conexion;
        vMensajes = new VistaMensajes();
        vPrincipal = new VistaPrincipal();
        vEstadisticas = new VistaEstadisticas();
        vConsultas = new VistaConsultas();
        vPorDefecto = new VistaPorDefecto();
        vistas = new Vistas();
        
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
        
        //vEstadisticas.jComboBoxColecciones.addActionListener(this);
        vEstadisticas.jButtonCambiarColeccionEstadisticas.addActionListener(this);
        
        vConsultas.jButtonConsultar.addActionListener(this);
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
               vistas.dibujarTablaTweets(vConsultas);
               vConsultas.jSpinnerNumMaxSeguidores.setValue(tweetDAO.usuarioConMasSeguidores("tweets").getFollowers());
               vConsultas.jListIdiomas.removeAll();
               vConsultas.jListIdiomas.setListData(tweetDAO.listadoIdiomas("tweets").toArray(new String[0]));
               vConsultas.jListIdiomas.removeAll();
               List<String> listaIdiomas = vConsultas.jListIdiomas.getSelectedValuesList();
           
               try {
                   muestraTweets("tweets", 0, tweetDAO.usuarioConMasSeguidores("tweets").getFollowers(), "", "", "", listaIdiomas);
               } catch (Exception ex) {
                   Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
               }
           
               break;

               
           case "Estadisticas":
               vEstadisticas.setVisible(true);
               vConsultas.setVisible(false);
                              
               vEstadisticas.jComboBoxColecciones.removeAllItems();
               
               nColecciones = tweetDAO.nombreColecciones();
               
               //Rellenamos el ComboBox
               for(String nColeccion:nColecciones)
               {
                   vEstadisticas.jComboBoxColecciones.addItem(nColeccion);
               }
                              
               vEstadisticas.jLabelNTweetsAlmacenados.setText(String.valueOf(tweetDAO.numTweets(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()))) + " tweets");
               
               vEstadisticas.jLabelUsername.setText(tweetDAO.usuarioConMasSeguidores(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem())).getUsername());
               vEstadisticas.jLabelNFollowers.setText(String.valueOf(tweetDAO.usuarioConMasSeguidores(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem())).getFollowers()));
               
               vEstadisticas.jLabelFechaMasReciente.setText(tweetDAO.fechaMasReciente(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem())).toString());
               vEstadisticas.jLabelFechaMenosReciente.setText(tweetDAO.fechaMenosReciente(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem())).toString());
               
               List<Map.Entry<String, Integer>> lista = tweetDAO.usuariosMasMencionados(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()));
               vEstadisticas.jLabelUsuarioConMasSeguidores1.setText(lista.get(0).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores2.setText(lista.get(1).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores3.setText(lista.get(2).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores4.setText(lista.get(3).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores5.setText(lista.get(4).toString() + " seguidores");
               
               ArrayList<String> hashtagsMasUtilizados = tweetDAO.hashtagsMasUtilizados(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()));
               vEstadisticas.jLabelHashtagMasUtilizado1.setText(hashtagsMasUtilizados.get(0));
               vEstadisticas.jLabelHashtagMasUtilizado2.setText(hashtagsMasUtilizados.get(1));
               vEstadisticas.jLabelHashtagMasUtilizado3.setText(hashtagsMasUtilizados.get(2));
               vEstadisticas.jLabelHashtagMasUtilizado4.setText(hashtagsMasUtilizados.get(3));
               vEstadisticas.jLabelHashtagMasUtilizado5.setText(hashtagsMasUtilizados.get(4));
               
               vEstadisticas.jLabelNumeroIdiomasDiferentes.setText(String.valueOf(tweetDAO.numeroIdiomasDiferentes(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()))));
               
               ArrayList<String> idiomasMasFrecuentes = tweetDAO.idiomasMasFrecuentes(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()));
               vEstadisticas.jLabelIdiomaMasUtilizado1.setText(idiomasMasFrecuentes.get(0));
               vEstadisticas.jLabelIdiomaMasUtilizado2.setText(idiomasMasFrecuentes.get(1));
               vEstadisticas.jLabelIdiomaMasUtilizado3.setText(idiomasMasFrecuentes.get(2));
               vEstadisticas.jLabelIdiomaMasUtilizado4.setText(idiomasMasFrecuentes.get(3));
               vEstadisticas.jLabelIdiomaMasUtilizado5.setText(idiomasMasFrecuentes.get(4));
               
               vEstadisticas.jLabelNumeroRTs.setText(String.valueOf(tweetDAO.numeroDeRT(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()))) + " RTs");
               
               vEstadisticas.jLabelNUsuariosDiferentes.setText(String.valueOf(tweetDAO.numeroDeUsuariosDiferentes(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()))) + " usuarios");
               
               ArrayList<String> usuariosConMasTweets = tweetDAO.usuariosFrecuenciaTweets(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()));
               vEstadisticas.jLabelUsuarioConMasTweets1.setText(usuariosConMasTweets.get(0));
               vEstadisticas.jLabelUsuarioConMasTweets2.setText(usuariosConMasTweets.get(1));
               vEstadisticas.jLabelUsuarioConMasTweets3.setText(usuariosConMasTweets.get(2));
               vEstadisticas.jLabelUsuarioConMasTweets4.setText(usuariosConMasTweets.get(3));
               vEstadisticas.jLabelUsuarioConMasTweets5.setText(usuariosConMasTweets.get(4));
               
               break;
               
           case "cambiarColeccion":
               /*vEstadisticas.jComboBoxColecciones.removeAllItems();
               
               nColecciones = tweetDAO.nombreColecciones();
               
               for(String nColeccion:nColecciones)
               {
                   vEstadisticas.jComboBoxColecciones.addItem(nColeccion);
                    System.out.println(nColeccion);

               }*/
               
               vEstadisticas.jLabelNTweetsAlmacenados.setText(String.valueOf(tweetDAO.numTweets(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()))) + " tweets");
               
               vEstadisticas.jLabelUsername.setText(tweetDAO.usuarioConMasSeguidores(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem())).getUsername());
               vEstadisticas.jLabelNFollowers.setText(String.valueOf(tweetDAO.usuarioConMasSeguidores(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem())).getFollowers()));
               
               vEstadisticas.jLabelFechaMasReciente.setText(tweetDAO.fechaMasReciente(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem())).toString());
               vEstadisticas.jLabelFechaMenosReciente.setText(tweetDAO.fechaMenosReciente(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem())).toString());
               
               List<Map.Entry<String, Integer>> lista2 = tweetDAO.usuariosMasMencionados(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()));
               vEstadisticas.jLabelUsuarioConMasSeguidores1.setText(lista2.get(0).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores2.setText(lista2.get(1).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores3.setText(lista2.get(2).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores4.setText(lista2.get(3).toString() + " seguidores");
               vEstadisticas.jLabelUsuarioConMasSeguidores5.setText(lista2.get(4).toString() + " seguidores");
               
               ArrayList<String> hashtagsMasUtilizados2 = tweetDAO.hashtagsMasUtilizados(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()));
               vEstadisticas.jLabelHashtagMasUtilizado1.setText(hashtagsMasUtilizados2.get(0));
               vEstadisticas.jLabelHashtagMasUtilizado2.setText(hashtagsMasUtilizados2.get(1));
               vEstadisticas.jLabelHashtagMasUtilizado3.setText(hashtagsMasUtilizados2.get(2));
               vEstadisticas.jLabelHashtagMasUtilizado4.setText(hashtagsMasUtilizados2.get(3));
               vEstadisticas.jLabelHashtagMasUtilizado5.setText(hashtagsMasUtilizados2.get(4));
               
               vEstadisticas.jLabelNumeroIdiomasDiferentes.setText(String.valueOf(tweetDAO.numeroIdiomasDiferentes(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()))));
               
               ArrayList<String> idiomasMasFrecuentes2 = tweetDAO.idiomasMasFrecuentes(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()));
               vEstadisticas.jLabelIdiomaMasUtilizado1.setText(idiomasMasFrecuentes2.get(0));
               vEstadisticas.jLabelIdiomaMasUtilizado2.setText(idiomasMasFrecuentes2.get(1));
               vEstadisticas.jLabelIdiomaMasUtilizado3.setText(idiomasMasFrecuentes2.get(2));
               vEstadisticas.jLabelIdiomaMasUtilizado4.setText(idiomasMasFrecuentes2.get(3));
               vEstadisticas.jLabelIdiomaMasUtilizado5.setText(idiomasMasFrecuentes2.get(4));
               
               vEstadisticas.jLabelNumeroRTs.setText(String.valueOf(tweetDAO.numeroDeRT(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()))) + " RTs");
               
               vEstadisticas.jLabelNUsuariosDiferentes.setText(String.valueOf(tweetDAO.numeroDeUsuariosDiferentes(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()))) + " usuarios");
               
               ArrayList<String> usuariosConMasTweets2 = tweetDAO.usuariosFrecuenciaTweets(String.valueOf(vEstadisticas.jComboBoxColecciones.getSelectedItem()));
               vEstadisticas.jLabelUsuarioConMasTweets1.setText(usuariosConMasTweets2.get(0));
               vEstadisticas.jLabelUsuarioConMasTweets2.setText(usuariosConMasTweets2.get(1));
               vEstadisticas.jLabelUsuarioConMasTweets3.setText(usuariosConMasTweets2.get(2));
               vEstadisticas.jLabelUsuarioConMasTweets4.setText(usuariosConMasTweets2.get(3));
               vEstadisticas.jLabelUsuarioConMasTweets5.setText(usuariosConMasTweets2.get(4));
               break;
               
           case "Consultar":
           
               try {
                   //ArrayList<Tweet> lTweets = tweetDAO.busquedaNombreUsuario("tweets", vConsultas.jTextFieldNombreUsuario.getText());
                   
                   //public ArrayList<Tweet> listaTweets(String coleccion, int numeroMinSeguidores, int numeroMaxSeguidores, String usuario, 
                   //String hashtag, String palabra, List<String> idiomas) throws MongoException

                   muestraTweets("tweets", 
                                Integer.parseInt(vConsultas.jSpinnerNumMinSeguidores.getValue().toString()), 
                                Integer.parseInt(vConsultas.jSpinnerNumMaxSeguidores.getValue().toString()), 
                                vConsultas.jTextFieldNombreUsuario.getText(),
                                vConsultas.jTextFieldHashtag.getText(), 
                                vConsultas.jTextFieldPalabra.getText(),
                                vConsultas.jListIdiomas.getSelectedValuesList());
               } catch (Exception ex) {
                   Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
               }
           
               break;

       }
    }
    
    /*private void pideTweets() throws MongoException
    {
        ArrayList<Tweet> lTweets = tweetDAO.listaTweets();
        vPrincipal.vaciarTablaTweets();
        vPrincipal.rellenarTablaTweets(lTweets);
    }*/
    
    private void muestraTweets(String coleccion, int nMinSeguidores, int nMaxSeguidores, String usuario, String hashtag, String palabra, List<String> idiomas) throws Exception
    {
        ArrayList<Tweet> lTweets = tweetDAO.listaTweets(coleccion, nMinSeguidores, nMaxSeguidores, usuario, hashtag, palabra, idiomas);
        vistas.vaciarTablaConsultas();
        vistas.rellenarTablaConsulta(lTweets);
    }
}
