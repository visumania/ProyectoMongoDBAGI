import PyQt5
import sys
from PyQt5.QtWidgets import QApplication, QWidget

if __name__ == "__main__":
    app = QApplication(sys.argv)
    w = QWidget()
    w.resize(300,300)
    w.setWindowTitle("Prueba de nueva ventana")
    w.show()
    sys.exit(app.exec_())