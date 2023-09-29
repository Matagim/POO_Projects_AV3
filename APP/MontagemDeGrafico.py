import matplotlib.pyplot as plt

class MontagemDeGrafico:

    #Método de montagem do gráfico
    @staticmethod
    def montagem(dado, dadoAlvo, legenda, titulo):
        # Criação do gráfico de mapas
        for jogador, campeonatos in dado.items():
            x = list(campeonatos.keys())
            y = [dados[dadoAlvo] for dados in campeonatos.values()]
    
            # Criando uma linha para cada jogador
            plt.plot(x, y, marker='o', linestyle='-', label=f'{jogador}')

             # Adiciona rótulos aos pontos de dados
            for i in range(len(x)):
                valor = campeonatos[x[i]][dadoAlvo]
                plt.annotate(f'{valor:.2f}', (x[i], y[i]), textcoords="offset points", xytext=(0,5), ha='center')
            

        # Personaliza os "arredores" do gráfico
        plt.xlabel(r'$\mathbf{CAMPEONATO}$')
        plt.ylabel(legenda)
        plt.title(titulo)
        plt.legend(fontsize='small')
        plt.grid()
        plt.xticks(rotation=5)
        plt.show()


    


    