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
package pruebalistade;

import modelo.ListaDE;

/**
 *
 * @author Oscar Arenas
 */
public class PruebaListaDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDE listaDE = new ListaDE();

        listaDE.agregar(-23);
        listaDE.agregar(57);
        listaDE.agregar(89);
        listaDE.agregar(91.28);
        listaDE.agregar(45);
        listaDE.agregar(7);

        System.out.println("ListaDE:");
        System.out.println(listaDE);
    }
}
