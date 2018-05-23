#Practica2

#Definimos algunas de las funciones del Stack
class Stack:
     def __init__(self):
         self.items = []

     def isEmpty(self):
         return self.items == []

     def push(self, item):
         self.items.append(item)

     def pop(self):
         return self.items.pop()

     def peek(self):
         return self.items[len(self.items)-1]

     def size(self):
         return len(self.items)

#Definimos las transiciones del automata
#https://stackoverflow.com/questions/35272592/how-are-finite-automata-implemented-in-code
estados = {0:{'a':1, 'c':5},
		   1:{'b':2},
		   2:{'a':3, 'c':5},
		   3:{'b':4},
		   4:{'a':3, 'c':5}	
			}

fallo_previo = {}

DFA = ({0,1,2,3,4,5},{'a','b','c'},estados,0,{2,5})

def aceptacion(transiciones, inicial, aceptacion, s):
	estado = inicial
	for c in s:			#0		#1
		estado = (transiciones[estado])[c]
	return estado in aceptacion

def Tokenize(DFA, cadena):
	for q in DFA[0]:
		for i in xrange(0,len(cadena)):
			fallo_previo[(q,i)] = False
	pila = Stack()
	i=0
	contador=0
	while(True):
		q = DFA[3]
		pila.push("Bottom")
		while(i<= len(cadena)):
			try:
				if fallo_previo[(q,i)]:
					break
				if q in DFA[4]:
					pila = Stack()
				pila.push(q)
				q = DFA[2][q][cadena[i]]
				i = i+1
			except KeyError, e:
				break
		while not(q in DFA[4]):
			fallo_previo[(q,i)] = True
			q = pila.pop()
			i = i-1
			if( q == "Bottom"):
				return "Failure: tokenization not possible"
			print(i-1)
		print "Expresion regular: ",cadena[contador:i]
		contador=i
		if(i >= len(cadena)):
			return "Success"
			
#Abrimos el archivo .txt para su analisis lexico
archivo = open("pruebaLexico.txt", "r") 
expRegular = archivo.read()
print(Tokenize(DFA, expRegular))
archivo.close();
