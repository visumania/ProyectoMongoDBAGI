# ProyectoFinalAGI
En este repositorio iremos subiendo el proyecto y sus respectivos actualizaciones
El archivo README.md se quedará para ir escribiendo notas y decisiones que iremos tomando a lo largo del desarrollo de la aplicación.

*Link interesantes:*
- [Numero 1](http://ualmtorres.github.io/howtos/MongoDBJava/)

**Temática de los tweets** *(no están repartidos equitativamente)*:
- Qatar2022
- Ukraine
- Messi
- Inflation
- Health
- Huelva
- UHU
- Recreativo de Huelva
- Nuevo Colombino
- USA
- Goku

En archivo *tweets.json* están los 50k tweets con las diferentes temáticas
En archivo *Tweets_Streaming_To_MongoDB.py* está el script utilizado para la descarga de los tweets en la base de datos de mongoDB en *localhost*. 

###### Datos estadísticos a sacar de la base de datos:
1. Número de tweets almacenados --> HECHO E IMPLEMENTADO EN JAVA
```mongodb
db.tweets.countDocument()
```
2. Periodo de descarga (fecha del primer y del último tweet) --> HECHO E IMPLEMENTADO EN JAVA
```mongodb
db.tweets.aggregate([
  {$sort:{created:1}},
  {$limit:1}
  ])

db.tweets.aggregate([
  {$sort:{created:-1}},
  {$limit:1}
  ])
```
3. Usuario con más seguidores junto con el número de seguidores --> HECHO E IMPLEMENTADO EN JAVA
```mongodb
db.tweets.aggregate([
  {$sort:{followers:-1}},
  {$limit:1}
  ])
```
4. Usuarios más mencionados junto con su frecuencia (top 5) --> HECHO E IMPLEMENTADO EN JAVA (De todas maneras, mirar el métodoPrueba para recordar como he implementado lo del diccionario [map])
```mongodb
db.tweets.aggregate([
  {$project:{_id:0, text:1}}
  ])
```
5. Hashtag's más frecuentes junto con su frecuencia (top 5) -->HECHO E IMPLEMENTADO EN JAVA
```mongodb
db.tweets.aggregate([
  {$unwind:"$hashtags"},
  {$group:{_id:"$hashtags.text", frecuencia:{$sum:1}}},
  {$sort:{frecuencia:-1}},
  {$limit:5}
  ])
```
6. Número de idiomas diferentes --> HECHO E IMPLEMENTADO EN JAVA
```mongodb
db.tweets.aggregate([
  {$group:{_id:"$language"}},
  {$count:"Numero de idiomas diferentes"}
  ])
```
7. Idiomas más frecuentes junto con su frecuencia (top 5) --> HECHO E IMPLEMENTADO EN JAVA
```mongodb 
db.tweets.aggregate([
  {$group:{_id:"$language", count:{$sum:1}}},
  {$sort:{count:-1}},
  {$limit:5}
  ])
```
8. Número de tweets almacenados que son RT's --> HECHO E IMPLEMENTADO EN JAVA
```mongodb
db.tweets.aggregate([
  {$project:{_id:0, text:1}}
  ])
```
9. Usuarios diferentes almacenados en la base de datos Twitter --> HECHO E IMPLEMENTADO EN JAVA
```mongodb
db.tweets.aggregate([
  {$group:{_id:"$username"}},
  {$count:"Número de usuarios diferentes: "}
  ])
```
10.   Usuarios que mas tweets tienen en la base de datos --> HECHO E IMPLEMENTADO EN JAVA
```mongodb
db.tweets.aggregate([
  {$group:{_id:"$username", count:{$sum:1}}},
  {$sort:{count:-1}},
  {$limit:5}
  ])
```

###### Consultas parametrizadas
Mostrar una tabla con todos los tweets de la colección seleccionada y abajo diferentes campos que pueden ser rellenados y que vaya filtrando datos. También tendrá un botón para crear nuevas colecciones (habrá que introducirle un nombre y no podrá coincidir con ninguno de las colecciones que ya estén creadas anteriormente).

**Criterios de búsqueda de la consulta parametrizada** 
1. Búsqueda por rango de seguidores (Único obligatorio)
2. Busqueda por usuario
3. Busqueda por hashtag
4. Búsqueda por palabra o expresiones específica del tweet (necesito índice de texto). Índice:
```mongodb
db.tweets.createIndex( { "text": "text" }, { default_language: "english", language_override: "english" } )
```
5. Búsqueda por idioma/s

###### Conexión al cluster:
[Página web](https://cloud.mongodb.com/v2/63c5b733d422044a0372b3b4#/clusters/detail/ProyectoFinalAGI)
usuario: pablian
contraseña: pablian

**Acciones que me quedan pendientes antes de terminar el proyecto al 100%**
- Creación de más índices (a parte del de texto que ya tengo creado) y hacer un estudio de la eficiencia de las consultas comparando su ejecución utilizando y sin utulizar los índices. 
- Creación de mecanismos de seguridad (opcional, mirar diapositivas de seguridad)
- Modificación del script de descarga y almacenamiento de los tweets para que permita interacción con el usuario --> Pedir palabras que desea buscar en los tweets y la cantidad de tweets que quiere almacenar.