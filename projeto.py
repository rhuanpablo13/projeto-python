from random import randint
from sys import argv

class Inputs:


    @staticmethod
    def getCoordenadas():
        print('Informe as coordenadas:')
        print('Linha:')
        a = Inputs.getInt()
        print('Coluna')
        b = Inputs.getInt()
        return (a, b)


    @staticmethod
    def getInts(min, max):
        flag = True
        while(flag):
            i = int(input())
            if i < min or i > max:
                print('Informe um número válido entre {} e {}'.format(min, max))
                flag = True
            else:
                flag = False
        return i

    @staticmethod
    def getInt():
        return Inputs.getInts(0,8)
    
    
    
class Tabuleiro:

    __nrBombas  = 0
    __tabuleiro = []
    __mapBombs  = []
    __default   = '[#]'
    __empty     = '[ ]'
    __bomb      = '[@]'
    __flag      = '[?]'


    def __init__(self, nrBombas):
        self.__nrBombas = nrBombas
        self.initTabuleiro()
        self.initMapBombs()


        
        
    def acertouBomba(self, coordenadas):
        if self.__mapBombs[coordenadas[0]][coordenadas[1]] == self.__bomb:
            return True
        return False
    
        
    def setLocalTabuleiroBranco(self, coordenadas):
        self.__tabuleiro[coordenadas[0]][coordenadas[1]] = self.__empty
        
        
    def setLocalTabuleiroMarcado(self, coordenadas):
        self.__tabuleiro[coordenadas[0]][coordenadas[1]] = self.__flag
        
        
    def setLocalTabuleiroBomba(self, coordenadas):
        self.__tabuleiro[coordenadas[0]][coordenadas[1]] = self.__bomb
        
        
    def isMarcado(self, coordenadas):
        if self.__tabuleiro[coordenadas[0]][coordenadas[1]] == self.__flag:
            return True
        return False
        

    def initMapBombs(self):        
        for i in range(self.__nrBombas):
            a = randint(0,8)
            b = randint(0,8)
            self.__mapBombs[a][b] = self.__bomb 
                
    
    def initTabuleiro(self):
        for i in range(9):
            self.__tabuleiro.append([])
            self.__mapBombs.append([])
            for j in range(9):
                self.__tabuleiro[i].append( self.__default )
                self.__mapBombs[i].append( self.__default )
                
                
                
                
    def getMapBombs(self):
        return self.__mapBombs
    
    def getTabuleiro(self):
        return self.__tabuleiro

    def getDefault(self):
        return self.__default

    def getEmpty(self):
        return self.__empty

    def getBomb(self):
        return self.__bomb

    def getFlag(self):
        return self.__flag

    def setNrBombas(self, nrBombas):
        self.__nrBombas = nrBombas
        
    def getNrBombas(self):
        return self.__nrBombas

    def subtraiNrBombas(self):
        self.__nrBombas = self.__nrBombas -1
   
    def isBranco(self, coordenadas):
        if self.__tabuleiro[coordenadas[0]] [coordenadas[1]] == self.__empty:
            return True
        return False
        






tabuleiro = Tabuleiro(10)

def printTabuleiro(tabuleiro):
    print('   ')

    for i in range(len(tabuleiro)):
        print(i, '  ', end='')

    print('\n')
    for j in range(len(tabuleiro)):
        for k in range(len(tabuleiro)):
            print(tabuleiro[j][k], end=' ')
        print('\n')


def userInterface():
    print('Pisar[1] ou Marcar[2] ?')
    a = Inputs.getInts(1,2)

    if a == 1:
        #pisa
        coordenadas = Inputs.getCoordenadas()
        if tabuleiro.isBranco(coordenadas):
            print('Este local já foi verificado! Escolha outro...')
            return True

        if tabuleiro.acertouBomba(coordenadas):
            print('----------------', 'Você pisou em uma bomba! Perdeu!', '----------------')
            return False
        else:
            print('Você pisou em um lugar seguro! Prossiga...')
            tabuleiro.setLocalTabuleiroBranco(coordenadas)
            return True
    else:
        #marcar
        coordenadas = Inputs.getCoordenadas()
        if tabuleiro.isBranco(coordenadas):
            print('Este local já foi verificado! Escolha outro...')
            return True

        if tabuleiro.isMarcado(coordenadas):
            print('Este local ja foi marcado! Escolha outro...')
            return False

        if tabuleiro.acertouBomba(coordenadas):
            tabuleiro.setLocalTabuleiroBomba(coordenadas)
            print('Bomba encontrada, parabéns!')
            tabuleiro.subtraiNrBombas()
            return True
        else:
            print('\n')
            tabuleiro.setLocalTabuleiroMarcado(coordenadas)
            return True


def main(args):    
    flag = True
    print('Mapa das bombas:')
    printTabuleiro(tabuleiro.getMapBombs())

    while(flag):
        if tabuleiro.getNrBombas() == 0:
            print('Parabéns, você venceu!')
            break;
            
        print('Tabuleiro:')    
        printTabuleiro(tabuleiro.getTabuleiro())
        print('-----------------------------')
        print('\t\tNúmero de bombas: {}'.format(tabuleiro.getNrBombas()), '\n')
        flag = userInterface()




if __name__ == "__main__":
    print(main(argv))

