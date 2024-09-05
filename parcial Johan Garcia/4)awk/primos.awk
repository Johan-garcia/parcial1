# Función para verificar si un número es primo
function es_primo(num) {
    if (num < 2) {
        return 0;
    }
    for (i = 2; i <= int(sqrt(num)); i++) {
        if (num % i == 0) {
            return 0;  # No es primo
        }
    }
    return 1;  # Es primo
}

# Procesar cada número del archivo
{
    if (es_primo($1)) {
        print $1 " es primo.";
    }
}

