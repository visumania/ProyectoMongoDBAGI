package Modelo;

import com.mongodb.Block;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import org.bson.Document;

public class TweetDAO 
{
    Conexion conexion = null; 
    //MongoClient mongoClient = null;
    MongoDatabase db = null;
    
    public TweetDAO(Conexion c)
    {
        this.conexion = c;
        db = c.getConexion().getDatabase("Twitter");
    }
    
    public void metodoPrueba()
    {
        // Seleccionamos la colección "tweets"
        MongoCollection<Document> collection = db.getCollection("tweets");

        // Creamos nuestro pipelina de operaciones, primero con el operador $match
        Document match = new Document("$match", new Document("username", "dailyheadliner"));  

        // Juntamos nuestro pipeline de operaciones en una lista
        List<Document> pipeline = Arrays.asList(match);

        // Hacemos la agregación 
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        // Convertimos el resultado a un objeto que sea iterable
        MongoCursor<Document> result2 = result.iterator();
        
        while (result2.hasNext()) {
          Document document = result2.next();

          System.out.println(document.getString("username"));
        }
        
        String prueba = "Hola mundo Hola Adrian mundo @Adri @Adrian @Adri";
        String[] tokens = prueba.split("\\s+|\n");
        
        /*for(int i=0; i<tokens.length; i++)
        {
            System.out.println(tokens[i]);
        }*/
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        //map.put(tokens[0], 1);
        //System.out.println(map.);
        
        for(int i=0; i<tokens.length; i++)
        {
            if(tokens[i].startsWith("@") && tokens[i].length()>1)
            {
                if(map.putIfAbsent(tokens[i], 1) != null)
                {
                    map.put(tokens[i], map.get(tokens[i])+1);
                }
            }
            
        }
        
        System.out.println(map.toString());
        
    }
    
    //1.- Función que devuelve el número de tweets almacenados en la colección
    public int numTweets() throws MongoException
    {
        MongoCollection colec = db.getCollection("tweets");
        
        return (int) colec.countDocuments();
    }    
    
    //2.1.- Función que devuelve la fecha más reciente de todos los tweets almacenados
    public Date fechaMasReciente() throws MongoException
    {
        Date fecha = null;
        MongoCollection<Document> collection = db.getCollection("tweets");
        
        Document sort = new Document("$sort", new Document("created", -1));
        Document limit = new Document("$limit",1);
        
        List<Document> pipeline = Arrays.asList(sort, limit);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        if(result2.hasNext())
        {
            Document document = result2.next();
            
            fecha = document.getDate("created");
        }
        
        return fecha;
    }
    
    //2.2.- Función que devuelve la fecha menos reciente de todos los tweets almacenados
    public Date fechaMenosReciente() throws MongoException
    {
        Date fecha = null;
        MongoCollection<Document> collection = db.getCollection("tweets");
        
        Document sort = new Document("$sort", new Document("created", -1));
        Document limit = new Document("$limit",1);
        
        List<Document> pipeline = Arrays.asList(sort, limit);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        if(result2.hasNext())
        {
            Document document = result2.next();
            
            fecha = document.getDate("created");
        }
        
        return fecha;
    }
    
    //3.- Función que devuelve el nombre del usuario con más seguidores y el número de seguidores
    public Tweet usuarioConMasSeguidores() throws MongoException
    {
        Tweet tweet = new Tweet();
        MongoCollection<Document> collection = db.getCollection("tweets");
        
        Document sort = new Document("$sort", new Document("followers",-1));
        Document limit = new Document("$limit", 1);
        
        List<Document> pipeline = Arrays.asList(sort, limit);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        if(result2.hasNext())
        {
            Document document = result2.next();
            
            tweet.setId(document.getString("id"));
            tweet.setUsername(document.getString("username"));
            tweet.setFollowers(document.getInteger("followers"));
            tweet.setText(document.getString("text"));
            tweet.setLanguage(document.getString("language"));
            tweet.setDate(document.getDate("created"));
        }
        
        return tweet;
    }
    
    //4.- Función que devuelve a los 5 usuarios más mencionados junto con su frecuencia en todos los tweets
    public List<Entry<String, Integer>> usuariosMasMencionados() throws MongoException
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
        MongoCollection<Document> collection = db.getCollection("tweets");
        
        Document project = new Document("$project", new Document("_id",0).append("text", 1));
        
        List<Document> pipeline = Arrays.asList(project);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        while(result2.hasNext())
        {
            Document document = result2.next();
            
            String tweet = document.getString("text");
            String tokens[] = tweet.split("\\s+|\n");
            
            for(int i=0; i<tokens.length; i++)
            {
                if(tokens[i].startsWith("@") && tokens[i].length()>1)
                {  
                    if(map.containsKey(tokens[i]))
                    {
                        map.put(tokens[i], map.get(tokens[i])+1);
                    }
                    else
                    {
                        map.put(tokens[i], 1);
                    }
                }
            }            
        }
        
        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        
        List<Entry<String, Integer>> ret = new ArrayList<Entry<String, Integer>>();
        
        ret.add(list.get(list.size()-1));
        ret.add(list.get(list.size()-2));
        ret.add(list.get(list.size()-3));
        ret.add(list.get(list.size()-4));
        ret.add(list.get(list.size()-5));
        
        return ret;  
    }
    
    //5.- Función que devuelve los 5 #Hashtags más utilizados en los tweets con su frecuencia
    public ArrayList<String> hashtagsMasUtilizados() throws MongoException
    {
        MongoCollection<Document> collection = db.getCollection("tweets");
        ArrayList<String> ret = new ArrayList<String>(); 
        
        Document unwind = new Document("$unwind", new Document("path", "$hashtags"));
        Document group = new Document("$group", new Document("_id", "$hashtags.text").append("frecuencia", new Document("$sum", 1)));
        Document sort = new Document("$sort", new Document("frecuencia", -1));
        Document limit = new Document("$limit", 5);
        
        List<Document> pipeline = Arrays.asList(unwind, group, sort, limit);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        while(result2.hasNext())
        {
            Document document = result2.next();
            
            ret.add("#" + document.getString("_id") + " aparece " + document.getInteger("frecuencia") + " veces");
        }
        
        return ret; 
    }
    
    //6.- Función que devuelve el número de idiomas diferentes utilizados en los tweets almacenados en la colección
    public int numeroIdiomasDiferentes() throws MongoException
    {
        MongoCollection<Document> collection = db.getCollection("tweets");
        int numIdiomasDiferentes = 0; 
        
        Document group = new Document("$group", new Document("_id", "$language"));
        Document count = new Document("$count", "Numero");
        
        List<Document> pipeline = Arrays.asList(group, count);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        if(result2.hasNext())
        {
            Document document = result2.next();
            numIdiomasDiferentes = document.getInteger("Numero");
        }
        
        return numIdiomasDiferentes; 
    }
    
    //7.- Función que devuelve los 5 idiomas más frecuentes en los tweets junto con su frecuencia
    public ArrayList<String> idiomasMasFrecuentes() throws MongoException
    {
        MongoCollection<Document> collection = db.getCollection("tweets");
        ArrayList<String> ret = new ArrayList<String>();
        
        Document group = new Document("$group", new Document("_id", "$language").append("count", new Document("$sum", 1)));
        Document sort = new Document("$sort", new Document("count",-1));
        Document limit = new Document("$limit", 5);
        
        List<Document> pipeline = Arrays.asList(group, sort, limit);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        while(result2.hasNext())
        {
            Document document = result2.next();
            
            ret.add(document.getString("_id") + ". Utilizado en " + document.getInteger("count") + " tweets");
        }
        
        return ret;
    }
    
    //8.- Función que devuelve los número de tweets que son RT's
    public int numeroDeRT() throws MongoException
    {
        MongoCollection<Document> collection = db.getCollection("tweets");
        int numeroRT = 0;
        
        Document project = new Document("$project", new Document("_id",0).append("text", 1));

        List<Document> pipeline = Arrays.asList(project);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        while(result2.hasNext())
        {
            Document document = result2.next();
            
            if(document.getString("text").startsWith("RT @"))
            {
                numeroRT++;
            }
        }
        
        return numeroRT; 
    }
    
    //9.- Función que devuelve el número de usuario diferentes de los cuales se almacenan tweets en la colección
    public int numeroDeUsuariosDiferentes() throws MongoException
    {
        MongoCollection<Document> collection = db.getCollection("tweets");
        int nUsuariosDiferentes = 0;
        
        Document group = new Document("$group", new Document("_id", "$username"));
        Document count = new Document("$count", "Numero");
        
        List<Document> pipeline = Arrays.asList(group, count);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        if(result2.hasNext())
        {
            Document document = result2.next();
            
            nUsuariosDiferentes = document.getInteger("Numero");
        }
        
        return nUsuariosDiferentes;
    }
    
    //10.- Función que devuelve a los usuarios que más tweets tienen almacenados en la colección junto con su frecuencia
    public ArrayList<String> usuariosFrecuenciaTweets() throws MongoException
    {
        MongoCollection<Document> collection = db.getCollection("tweets");
        ArrayList<String> ret = new ArrayList<String>();
        
        Document group = new Document("$group", new Document("_id", "$username").append("count", new Document("$sum", 1)));
        Document sort = new Document("$sort", new Document("count",-1));
        Document limit = new Document("$limit", 5);
        
        List<Document> pipeline = Arrays.asList(group, sort, limit);
        
        AggregateIterable<Document> result = collection.aggregate(pipeline);
        
        MongoCursor<Document> result2 = result.iterator();
        
        while(result2.hasNext())
        {
            Document document = result2.next();
            
            ret.add("@" + document.getString("_id") + " con " + document.getInteger("count") + " tweets");
        }
        
        return ret;
    }
        
    //Ejemplo de función para recuperar toda la información de una tabla
    /*public ArrayList<Tweet> listaTweets() throws MongoException
    {
        ArrayList<Tweet> listaTweets = new ArrayList();
        
        MongoCollection colec = db.getCollection("tweets");
        
        MongoCursor cursor = colec.find();
        
        while(cursor.hasNext())
        {
            Tweet tweet = new Tweet(cursor.next().get("id").toString(), cursor.curr().get("username").toString(), Integer.parseInt(cursor.curr().get("followers").toString()), cursor.curr().get("text").toString(), cursor.curr().get("language").toString(), cursor.curr().get("created").toString());
            listaTweets.add(tweet);
        }
        
        cursor.close();
        
        return listaTweets;
    }*/
    
    //Función que devuelve un array cuya primera posición [0] es el tweet más antiguo y la segunda posición [1] es el último tweet almacenado
    /*public ArrayList<Tweet> periodoDescarga() throws MongoException
    {
        ArrayList<Tweet> listaTweets = new ArrayList();
        
        DBCollection colec = db.getCollection("tweets");
        
        
        return listaTweets;
    }*/
    
    //Función que devuelve el tweet más antiguo almacenado en la colección
    /*public String tweetMasAntiguo() throws MongoException
    {
        //DBCollection colec = db.getCollection("tweet");
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("tweet");
        
        MongoCollection<Document> colec = db.getCollection("tweet");
        /*colec.aggregate(
            Arrays.asList(
                Aggregates.match(
                    Filters.eq("username", "dailyheadliner")
                ),
                Aggregates.project(
                    Projections.fields(
                            Projections.excludeId(), 
                            Projections.exclude("followers"), 
                            Projections.exclude("text"), 
                            Projections.exclude("hashtag"),
                            Projections.exclude("language"),
                            Projections.exclude("created")
                    )
                ),
                Aggregates.limit(1)
            )
        );    
        
        colec.aggregate();
        
        return "";
    }*/
}
