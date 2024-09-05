import random

def generar_numeros(cantidad, rango_min, rango_max, nombre_archivo):
    with open(nombre_archivo, 'w') as archivo:
        for _ in range(cantidad):
            numero = random.randint(rango_min, rango_max)
            archivo.write(f"{numero}\n")

# Llamada a la función
generar_numeros(1000, 1, 1000, 'numeros_aleatorios.txt')

