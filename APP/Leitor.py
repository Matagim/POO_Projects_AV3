import csv
import tkinter as tk
from tkinter import filedialog
from collections import defaultdict

class Leitor:

    dado = {}

    #Método de leitura
    @staticmethod
    def leitura_de_dados(arquivo_path):
        with open(arquivo_path, "r") as arquivo:
            arquivo_csv = csv.reader(arquivo, delimiter=';')
            next(arquivo_csv, None)  # Pula a primeira linha do CSV
            for linha in arquivo_csv:
                campeonato, jogador, abate, adrr, impact, ratin, maps, tkk, data = linha
                abate, adrr, impact, ratin, tkk, data = map(float, [abate, adrr, impact, ratin, tkk, data])
                maps = int(maps)
                if jogador not in Leitor.dado:
                    Leitor.dado[jogador] = {}
                Leitor.dado[jogador][campeonato] = {
                    'abate': abate,
                    'adr': adrr,
                    'impacto': impact,
                    'rating': ratin,
                    'mapas': maps,
                    'tk/tm': tkk,
                    'data': data
                }
    #Método para que o usuário escolha o arquivo do seu sistema
    @staticmethod
    def escolher_arquivo():
        root = tk.Tk()
        root.withdraw()  # Esconde a janela principal do tkinter

        arquivo_path = filedialog.askopenfilename(title="Escolher arquivo CSV", filetypes=[("CSV Files", "*.csv")])

        if arquivo_path:
            
            Leitor.leitura_de_dados(arquivo_path)
            