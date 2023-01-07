package Modelo;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import java.util.List;
import javax.swing.JOptionPane;

public class Conexion {
    
    private MongoClient mongo = null;
    
    /*public Conexion() throws MongoException
    {
        String servidor = "localhost";
        int puerto = 27017;
        
        mongo = new MongoClient(servidor, puerto);
    }*/
    
    public Conexion(String servidor, int puerto) throws MongoException
    {
        mongo = new MongoClient(servidor, puerto);
    }
    
    public MongoClient getConexion()
    {
        return mongo;
    }
    
    public void desconexion() throws MongoException
    {
        mongo.close();
    }
}
