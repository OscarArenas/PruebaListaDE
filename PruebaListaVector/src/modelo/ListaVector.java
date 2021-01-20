/*
 * Copyright (C) 2020 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package modelo;

/**
 *
 * @author Oscar Arenas
 */
public class ListaVector {

    // Campos (Atributos)
    private int[] datos;
    private int n; // Tamaño de la lista

    // Métodos (Comportamientos)
    public ListaVector() {
        datos = new int[1];
        n = 0;
    }

    public ListaVector(int capacidadInicial) {
        if (capacidadInicial < 1) {
            throw new IllegalArgumentException("Capacidad inicial incorrecta: " + capacidadInicial);
        }
        datos = new int[capacidadInicial];
        n = 0;
    }

    /**
     * Adiciona el dato especificado al final de la lista. Permite almacenar
     * valores repetidos.
     *
     * @param dato valor que se agregará a esta lista
     * @return Retorna true después de adicionar el dato a la lista
     */
    public boolean agregar(int dato) {
        if (datos.length == n) {
            cambiarCapacidad(2 * n);
        }

        // Agregamos el dato al vector 'datos'
        datos[n++] = dato;

        return true;
    }

    /**
     * Adiciona el dato en el índice especificado de la lista. Si en la posición
     * indicada existe un dato, este se desplaza una posición a la derecha al
     * igual que todos los que le siguen. Una vez se inserte el dato se retorna
     * true. Si no existe el índice o es mayor que el tamaño de lista no se
     * inserta el dato y retorna false.
     *
     * @param indice índice en el que se insertará el dato especificado
     * @param dato valor entero que se agregará a esta lista
     * @return Retorna true si inserta el dato o false en caso contrario
     */
    public boolean agregar(int indice, int dato) {
        if (indice >= 0 && indice <= n) {//Precondicion
            if (datos.length == n) {
                cambiarCapacidad(2 * n);
            }

            for (int i = n; i > indice; i--) {
                datos[i] = datos[i - 1];
            }
            datos[indice] = dato;
            n++;
            return true;
        }
        return false;
    }

    /**
     * Borra de la lista el valor ubicado en el índice especificado. El borrado
     * se realiza desplazando todos los elementos que estan después del ubicado
     * en el índice especificado una posición a la izquierda.
     *
     * @param indice Entero que indica la posición del valor a borrar
     * @return Retorna true si elimina el valor y false en caso contrario
     */
    public boolean eliminar(int indice) {
        if (indice >= 0 && indice < n) {
            n--;
            for (int i = indice; i < n; i++) {
                datos[i] = datos[i + 1];
            }
            if (n > 0 && datos.length / 4 == n) {
                cambiarCapacidad(datos.length / 2);
            }
            return true;
        }
        return false;
    }

    /**
     * Devuelve el valor ubicado en el índice especificado. Si no existe la
     * posición se lanza la excepción IndexOutOfBoundsException.
     *
     * @param indice Entero que indica la posición del valor a retornar.
     * @return Retorna el valor ubicado en el índice especificado. Si no existe
     * la posición se lanza la excepción IndexOutOfBoundsException.
     */
    public int obtener(int indice) throws IndexOutOfBoundsException {
        if (indice >= 0 && indice < n) {
            return datos[indice];
        }
        throw new IndexOutOfBoundsException("No existe el índice: " + indice);
    }

    public int tamanio() {
        return n;
    }

    public boolean esVacia() {
        return n == 0;
    }

    /**
     * Crea un nuevo vector con capacidad igual o mayor a la del vector 'datos'.
     *
     * @param nc Entero que indica la nueva capacidad del vector 'datos'
     */
    private void cambiarCapacidad(int nc) {
        if (nc > 0 && nc >= n) {
            int[] nuevoVector = new int[nc];

            for (int i = 0; i < n; i++) {
                nuevoVector[i] = datos[i];
            }
            datos = nuevoVector;
        }
    }

    @Override
    public String toString() {
        String cadena = "";

        if (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                cadena += datos[i] + ", ";
            }
            cadena += datos[n - 1];
        }
        return "[" + cadena + "]";
    }
}
