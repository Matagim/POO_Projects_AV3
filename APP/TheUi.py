from PyQt5 import QtCore, QtGui, QtWidgets
from PyQt5.QtWidgets import QLabel
from PyQt5.QtGui import QPixmap
from Leitor import Leitor
from MontagemDeGrafico import MontagemDeGrafico


class Ui(object):
    def setupUi(self, MainWindow):
        # Configurar o objeto da janela principal
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(1280, 720)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        

        # Criar uma QLabel para exibir o título
        self.label = QtWidgets.QLabel(self.centralwidget)
        self.label.setGeometry(QtCore.QRect(640, 65, 47, 13))
        self.label.setAlignment(QtCore.Qt.AlignCenter)
        self.label.setObjectName("label")
        self.label.setText("CS:GO")

        # Criar botões para ações
        self.abates = QtWidgets.QPushButton(self.centralwidget)
        self.abates.setGeometry(QtCore.QRect(400, 270, 100, 26))
        self.abates.setObjectName("abates")
        self.abates.clicked.connect(lambda: MontagemDeGrafico.montagem(Leitor.dado,'abate',r'$\mathbf{Abates}$', 'Abates em cada campeonato'))
        self.abates.setText("Abates")

        self.adr = QtWidgets.QPushButton(self.centralwidget)
        self.adr.setGeometry(QtCore.QRect(760, 270, 100, 26))
        self.adr.setObjectName("adr")
        self.adr.clicked.connect(lambda: MontagemDeGrafico.montagem(Leitor.dado, 'adr',r'$\mathbf{ADR}$', 'ADR em cada campeonato'))
        self.adr.setText("Adr")

        self.mapas = QtWidgets.QPushButton(self.centralwidget)
        self.mapas.setGeometry(QtCore.QRect(400, 350, 100, 26))
        self.mapas.setObjectName("mapas")
        self.mapas.clicked.connect(lambda: MontagemDeGrafico.montagem(Leitor.dado,'mapas',r'$\mathbf{Total\ De\ Mapas}$', 'Total de mapas em cada campeonato'))
        self.mapas.setText("Mapas")

        self.rating = QtWidgets.QPushButton(self.centralwidget)
        self.rating.setGeometry(QtCore.QRect(760, 350, 100, 26))
        self.rating.setObjectName("rating")
        self.rating.clicked.connect(lambda: MontagemDeGrafico.montagem(Leitor.dado, 'rating',r'$\mathbf{Rating}$', 'Rating em cada campeonato'))
        self.rating.setText("Rating")

        self.impacto = QtWidgets.QPushButton(self.centralwidget)
        self.impacto.setGeometry(QtCore.QRect(400, 430, 100, 26))
        self.impacto.setObjectName("impacto")
        self.impacto.clicked.connect(lambda: MontagemDeGrafico.montagem(Leitor.dado,'impacto',r'$\mathbf{Impacto}$', 'IMPACTO em cada campeonato'))
        self.impacto.setText("Impacto")

        self.tk = QtWidgets.QPushButton(self.centralwidget)
        self.tk.setGeometry(QtCore.QRect(760, 430, 100, 26))
        self.tk.setObjectName("tk")
        self.tk.clicked.connect(lambda: MontagemDeGrafico.montagem(Leitor.dado,'tk/tm', r'$\mathbf{TK/\ TM}$', 'Total de abates/Total de mapas em cada campeonato'))
        self.tk.setText("Tk/Tm")

        self.info = QtWidgets.QPushButton(self.centralwidget)
        self.info.setGeometry(QtCore.QRect(580, 500, 125, 26))
        self.info.setObjectName("info")
        self.info.clicked.connect(lambda: Ui.mostrar_informacoes())
        self.info.setText("Mostrar informações")

        self.arquivocsv = QtWidgets.QPushButton(self.centralwidget)
        self.arquivocsv.setGeometry(QtCore.QRect(570, 540, 145, 26))
        self.arquivocsv.setObjectName("arquivocsv")
        self.arquivocsv.clicked.connect(lambda: Leitor.escolher_arquivo())
        self.arquivocsv.setText("Selecione o arquivo csv")

        # Criar uma QLabel para o título secundário
        self.label_2 = QtWidgets.QLabel(self.centralwidget)
        self.label_2.setGeometry(QtCore.QRect(565, 100, 181, 16))
        self.label_2.setAlignment(QtCore.Qt.AlignCenter)
        self.label_2.setObjectName("label_2")
        self.label_2.setText("Counter-Strike: Graphic Overview")

        # Configurar a janela principal
        MainWindow.setCentralWidget(self.centralwidget)

        # Configurar a imagem de fundo
        self.setup_background_image()

        
        

    #colocar a imagem
    def imagem_de_fundo(self):
        # Criar uma QLabel para exibir a imagem de fundo
        self.background_label = QLabel(self.centralwidget)

        # Carregar a imagem de fundo usando QPixmap
        pixmap = QPixmap("csOV.png")  # Substituir pelo caminho da sua imagem

        # Definir a geometria da QLabel para cobrir toda a janela
        self.background_label.setGeometry(0, 0, 1280, 720)

        # Definir a imagem na QLabel
        self.background_label.setPixmap(pixmap)

        # Tornar a QLabel uma camada subjacente para outros widgets
        self.background_label.setScaledContents(True)
        self.background_label.lower()
    
    
    #Caixa de informações sobre os botões
    def mostrar_informacoes():
        informacoes = "ADR - Dano médio por rodada.\n\nIMPACTO - Influência/Relevância de um jogador na partida.\n\nRATING -  Comparação de três estatísticas: eliminações feitas em um round, rounds sobrevividos e um valor baseado no número de rounds onde o jogador fez mais de uma eliminação.\n\nTK/TM - Quantidade total de abates dividido pela quantidade total de mapas."
    
        # Cria um diálogo de mensagem com as informações
        msgBox = QtWidgets.QMessageBox()
        msgBox.setWindowTitle("Informações")
        msgBox.setText(informacoes)
        msgBox.exec_()

#inicialização
if __name__ == "__main__":
    import sys
    app = QtWidgets.QApplication(sys.argv)
    style ="""
            QLabel {
                background-color: qlineargradient(
                    x1: 0, y1: 0, x2: 0, y2: 1,
                    stop: 0 #090a0c,
                    stop: 0.2 #38424b,
                    stop: 1 #191d22
                );
                color: white;
                font-family: "Arial";
                font-size: 12px;
            }

            QPushButton {
                background-color: qlineargradient(
                    x1: 0, y1: 0, x2: 0, y2: 1,
                    stop: 0 #090a0c,
                    stop: 0.2 #38424b,
                    stop: 1 #191d22
                );
                border: none; /* Remover a borda */
                border-radius: 0px;
                color: white;
                font-family: "Arial";
                font-size: 12px;
                padding: 0px 0px;
            }
            
            QPushButton:hover {
                background-color: qlineargradient(
                    x1: 0, y1: 0, x2: 0, y2: 1,
                    stop: 0 #20262b,
                    stop: 1 #191d22
                );
                color: #d0d0d0;
            }
            """
        
    app.setStyleSheet(style)
    MainWindow = QtWidgets.QMainWindow()
    ui = Ui()
    ui.setupUi(MainWindow)
    MainWindow.show()
    sys.exit(app.exec_())
