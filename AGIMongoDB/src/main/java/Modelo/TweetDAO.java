package Modelo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import java.util.ArrayList;

public class TweetDAO 
{
    Conexion conexion = null; 
    DB db = null;
    
    public TweetDAO(Conexion c)
    {
        this.conexion = c;
        db = this.conexion.getConexion().getDB("Twitter");
    }
    
    //Ejemplo de función para recuperar toda la información de una tabla
    public ArrayList<Tweet> listaTweets() throws MongoException
    {
        ArrayList<Tweet> listaTweets = new ArrayList();
        
        DBCollection colec = db.getCollection("tweets");
        
        DBCursor cursor = colec.find();
        
        while(cursor.hasNext())
        {
            Tweet tweet = new Tweet(cursor.next().get("id").toString(), cursor.curr().get("username").toString(), Integer.parseInt(cursor.curr().get("followers").toString()), cursor.curr().get("text").toString(), cursor.curr().get("language").toString(), cursor.curr().get("created").toString());
            listaTweets.add(tweet);
        }
        
        cursor.close();
        
        return listaTweets;
    }
    
    //Función que devuelve el número de tweets almacenados en la colección
    public int numTweets() throws MongoException
    {
        DBCollection colec = db.getCollection("tweets");
        
        return colec.find().count();
    }
    
    //Función que devuelve un array cuya primera posición [0] es el tweet más antiguo y la segunda posición [1] es el último tweet almacenado
    /*public ArrayList<Tweet> periodoDescarga() throws MongoException
    {
        ArrayList<Tweet> listaTweets = new ArrayList();
        
        DBCollection colec = db.getCollection("tweets");
        
        
        return listaTweets;
    }*/
}
