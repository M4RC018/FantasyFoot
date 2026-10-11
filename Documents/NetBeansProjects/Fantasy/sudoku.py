# El 0 significa casilla vacía.
tablero = [
    [1, 0, 3, 4],
    [0, 4, 1, 0],
    [2, 1, 0, 3],
    [4, 3, 2, 1]
]

# Repetir mientras se puedan rellenar casillas.
cambio = True
while cambio:
    cambio = False
    for fila in range(4):
        for columna in range(4):
            if tablero[fila][columna] == 0:
                posibles = []
                for numero in range(1, 5):
                    usado = numero in tablero[fila]

                    # Comprobar la columna.
                    for f in range(4):
                        if tablero[f][columna] == numero:
                            usado = True

                    # Comprobar el bloque de 2x2.
                    inicio_fila = (fila // 2) * 2
                    inicio_columna = (columna // 2) * 2
                    for f in range(inicio_fila, inicio_fila + 2):
                        for c in range(inicio_columna, inicio_columna + 2):
                            if tablero[f][c] == numero:
                                usado = True

                    if not usado:
                        posibles.append(numero)

                # Rellenar solo si hay una única posibilidad.
                if len(posibles) == 1:
                    tablero[fila][columna] = posibles[0]
                    cambio = True

# Guardar el resultado con el mismo formato.
with open("solución.txt", "w", encoding="utf-8") as archivo:
    for fila in tablero:
        archivo.write("|" + "|".join(str(numero) for numero in fila) + "|\n")

if any(0 in fila for fila in tablero):
    print("Quedan casillas sin resolver. Avance guardado en solución.txt")
else:
    print("Sudoku resuelto y guardado en solución.txt")
