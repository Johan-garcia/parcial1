#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 1024

// Función para contar las coincidencias de la palabra clave en una línea
int contar_coincidencias(char *linea, const char *clave) {
    int count = 0;
    char *pos = linea;
    while ((pos = strstr(pos, clave)) != NULL) {
        count++;
        pos += strlen(clave); // Mover el puntero más allá de la coincidencia encontrada
    }
    return count;
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Uso: %s <archivo> <clave>\n", argv[0]);
        return EXIT_FAILURE;
    }

    const char *nombre_archivo = argv[1];
    const char *clave = argv[2];
    
    FILE *archivo = fopen(nombre_archivo, "r");
    if (archivo == NULL) {
        perror("Error al abrir el archivo");
        return EXIT_FAILURE;
    }

    char linea[MAX_LINE_LENGTH];
    int total_coincidencias = 0;

    // Leer el archivo línea por línea
    while (fgets(linea, sizeof(linea), archivo)) {
        total_coincidencias += contar_coincidencias(linea, clave);
    }

    fclose(archivo);

    printf("La palabra '%s' se repite %d veces en el texto.\n", clave, total_coincidencias);

    return EXIT_SUCCESS;
}

