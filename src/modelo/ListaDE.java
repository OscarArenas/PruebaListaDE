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
 * Lista doblemente enlazada (ListaDE).
 *
 * @author Oscar Arenas
 */
public class ListaDE {

    // Campos
    private NodoDE primerNodo;
    private NodoDE ultimoNodo;
    private int n;

    // Métodos
    public ListaDE() {
        primerNodo = null;
        ultimoNodo = null;
        n = 0;
    }

    public void agregar(double dato) {
        NodoDE nuevoNodo = new NodoDE(dato);

        if (primerNodo != null) {
            nuevoNodo.anterior = ultimoNodo;
            ultimoNodo.siguiente = nuevoNodo;
        } else {
            primerNodo = nuevoNodo;
        }

        ultimoNodo = nuevoNodo;
        n++;
    }

    public boolean agregar(int indice, double dato) {
        if (indice >= 0 && indice <= n) {
            if (indice == n) {
                agregar(dato);
            } else {//Inserta al principio o entre dos nodos de la lista
                NodoDE actual = primerNodo;
                int i = 0;
                while (i < indice) {
                    i++;
                    actual = actual.siguiente;
                }

                NodoDE anterior = actual.anterior;
                NodoDE nuevoNodo = new NodoDE(dato);

                if (anterior == null) {
                    nuevoNodo.siguiente = actual;
                    actual.anterior = nuevoNodo;
                    primerNodo = nuevoNodo;
                } else {
                    nuevoNodo.anterior = anterior;
                    nuevoNodo.siguiente = actual;
                    anterior.siguiente = nuevoNodo;
                    actual.anterior = nuevoNodo;
                }
                n++;
            }
            return true;
        }
        return false;
    }

    public boolean eliminar(int indice) {
        return false;
    }

    public double obtener(int indice) {
        return 0;
    }

    public int tamanio() {
        return n;
    }

    public boolean esVacia() {
        return false;
    }

    @Override
    public String toString() {
        String cadena = "";

        if (primerNodo != null) {
            NodoDE actual = primerNodo;

            while (actual.siguiente != null) {
                cadena = cadena + actual.dato + ", ";
                actual = actual.siguiente;
            }
            cadena = cadena + actual.dato;
        }
        return "[" + cadena + "]";
    }

    private class NodoDE {

        double dato;
        NodoDE anterior;
        NodoDE siguiente;

        public NodoDE(double dato) {
            this.dato = dato;
            anterior = null;
            siguiente = null;
        }

        public NodoDE(NodoDE anterior, double dato, NodoDE siguiente) {
            this.dato = dato;
            this.anterior = anterior;
            this.siguiente = siguiente;
        }

        public NodoDE(NodoDE anterior, double dato) {
            this.dato = dato;
            this.anterior = anterior;
            siguiente = null;
        }
    }
}
