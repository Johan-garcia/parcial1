# Función para verificar si un carácter es un dígito
def es_digito(caracter):
    return '0' <= caracter <= '9'

# Función para reconocer el token basado en la expresión de entrada
def reconocer_token(entrada):
    estado = 0
    
    for i, caracter in enumerate(entrada):
        if estado == 0:
            if caracter == '+':
                estado = 1
            elif es_digito(caracter):
                estado = 3
            else:
                return "Error: Símbolo no reconocido"
        
        elif estado == 1:
            if caracter == '+':
                estado = 2
            else:
                return "Error: Símbolo no reconocido"
        
        elif estado == 3:
            if es_digito(caracter):
                continue
            elif caracter == '.':
                estado = 4
            else:
                return "Error: Símbolo no reconocido"
        
        elif estado == 4:
            if es_digito(caracter):
                estado = 5
            else:
                return "Error: Símbolo no reconocido"
    
    # Verificación de estados finales para devolver los tokens correctos
    if estado == 1:
        return 'SUMA'
    elif estado == 2:
        return 'INCR'
    elif estado == 3:
        return 'ENTERO'
    elif estado == 5:
        return 'REAL'
    else:
        return "Error: Expresión no válida"

# Programa principal
if __name__ == "__main__":
    entrada = input("Introduce una expresión: ")
    token = reconocer_token(entrada)
    print(f"Token: {token}")

