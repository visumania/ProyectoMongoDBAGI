import tweepy
from tweepy import Stream
import json
from pymongo import MongoClient
from pymongo.errors import ConnectionFailure
import datetime
from keys import *


class MiClaseTwitter(Stream):

    def __init__(self, consumer_key, consumer_secret, access_token, access_token_secret, bd, limite):
        Stream.__init__(self, consumer_key=consumer_key, consumer_secret=consumer_secret, access_token=access_token, access_token_secret=access_token_secret)
        self.contador = 0
        self.limite = limite
        self.coleccion = bd.tweets
        
    def on_connection_error(self):
        self.disconnect()
    
    def on_connect(self):
        print("Conexión correcta!!!!")
        
        
    def on_data(self, data):
        if self.contador < self.limite:

               
        # Decode the JSON data from Twitter
            tweet = json.loads(data)
       
            #if tweet['lang'] == 'es':
            print("Tweet número " ,self.contador)
            print(tweet['created_at']) 
            print(tweet['user']['screen_name'])
            print(tweet['text'])
            if 'text' in tweet:
                text = tweet['text']
            if 'extended_tweet' in tweet:
                text = tweet['extended_tweet']['full_text']
            if 'retweeted_status' in tweet:
                tweet_RT = tweet['retweeted_status']
                if 'text' in tweet_RT:
                    text = 'RT @' + tweet['retweeted_status']['user']['screen_name'] + tweet_RT['text']    
                if 'extended_tweet' in tweet_RT:
                    extended_RT = tweet_RT['extended_tweet']
                    text = 'RT @' + tweet['retweeted_status']['user']['screen_name'] + extended_RT['full_text']
        
            tweet_id = tweet['id_str']                      # El ID en formato cadena
            username = tweet['user']['screen_name']         # El autor del tweet
            followers = tweet['user']['followers_count']    # Número de seguidores
            hashtags = tweet['entities']['hashtags']        # Los hashtags usados
            dt = tweet['created_at']                        # El timestamp cuando fue creado
            language = tweet['lang']                        # El idioma

        	# # Convierte dt en un formato más adecuado para MongoDB
            created = datetime.datetime.strptime(dt, '%a %b %d %H:%M:%S +0000 %Y')

            tweetSimplificado = {'id':tweet_id, 'username':username, 'followers':followers, 
                          'text':text, 'hashtags':hashtags, 'language':language, 'created':created }

        
            self.coleccion.insert_one(tweetSimplificado)
            #self.coleccion.insert_one(tweet)
         
            self.contador += 1
        else:
            print('Límite de tweets alcanzado')
            self.disconnect()
            

    def on_error(self, status_code):
        print("Error", status_code)

if __name__ == '__main__':

    # Si queremos conectarnos a un cluster de Atlas, se usa la misma cadena que para conectarse desde los programas (Compass, Studio 3T, etc.)
    # En este caso se conecta a un cluster "local" en el que uno de los nodos "escucha" por el puerto 27017
    stringConexion='mongodb://localhost:27017'
    
    try:

        cliente = MongoClient(stringConexion)
        limite = 27944
        bd = cliente.Twitter
        MiStream = MiClaseTwitter(consumer_key, consumer_secret, access_token, access_token_secret, bd=bd, limite=limite)
        MiStream.filter(track = ['Qatar2022' , 'Ukraine' , 'Messi' , 'Inflation' , 'Health', 'Huelva', 'UHU', 'Recreativo de Huelva', 'Nuevo Colombino', 'USA', 'Goku'])

    except ConnectionFailure:
        print('Failed to connect to replicaSet')

