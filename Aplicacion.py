import PyQt5
import sys
from PyQt5.QtWidgets import QApplication, QWidget
from pymongo import MongoClient
from PyQt5 import uic

if __name__ == "__main__":

    """app = QApplication(sys.argv)
    w = QWidget()
    w.resize(300,300)
    w.setWindowTitle("Prueba de nueva ventana")
    w.show()
    sys.exit(app.exec_())"""

    stringConexion='mongodb://localhost:27017'
    cliente = MongoClient(stringConexion)

    bd = cliente.Twitter
    tweets = bd.tweets

    # Consulta con find sin criterios de selección (solo proyección)
    """tResultado = tweets.find({},{"created":1, "username":1, "_id":0})
    for t in tResultado:
        print(f"Fecha: {t['created']}\tUsuario: {t['username']}")"""

    # Consulta con aggregate aceptando un parámetro
    numSeguidores = input("Introduce número de seguidores: ")

    # Obtiene los usuario que tienen más de "numSeguidores"
    resultado = tweets.aggregate([{'$match':{'followers':{'$gt': int(numSeguidores)}}},
                                 {'$project':{'username':1, 'followers':1}},
                                 {'$sort':{'followers':-1}}])

    listaResultado = list(resultado)

    if len(listaResultado)!=0:
        for i in listaResultado:
            print (f"{i['username']}: {i['followers']}")
    else:
        print("No se ha encontrado a ningún usuario con más de " + numSeguidores + " seguidores")

    resultado = tweets.aggregate([{'$project':{'username':1, 'followers':1}}])
    listaResultado = list(resultado)

    Form, Window = uic.loadUiType("Interfaz.ui")

    app = QApplication([])
    window = Window()
    form = Form()
    form.setupUi(window)
    window.show()
    app.exec()