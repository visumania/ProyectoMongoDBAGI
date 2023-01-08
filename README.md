# ProyectoFinalAGI
En este repositorio iremos subiendo el proyecto y sus respectivos actualizaciones
El archivo README.md se quedará para ir escribiendo notas y decisiones que iremos tomando a lo largo del desarrollo de la aplicación.

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
1. Número de tweets almacenados
2. Periodo de descarga (fecha del primer y del último tweet)
3. Usuario con más seguidores junto con el número de seguidores
4. Usuarios más mencionado junto con su frecuencia (top 5)
5. Hashtag's más frecuentes junto con su frecuencia (top 5)
6. Número de idiomas diferentes
7. Idiomas más frecuentes junto con su frecuencia (top 5)
8. Número de tweets almacenados que son RT's
9. Usuarios diferentes almacenados en la base de datos Twitter
10. Usuarios que mas tweets tienen en la base de datos

###### Consultas parametrizadas
*Por rellenar*