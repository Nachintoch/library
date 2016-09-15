package mx.nachintoch.datatypes;

/*
 * Nachintoch utils library for Java and Android.
 * Copyright 2012, 2013, Manuel Castillo.
 * This code is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License
 * along with this code.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * Define un objeto comparable especial que adem&aacute;s de poder ser
 * comparado, contiene un valor n&uacute;merico al que se le puede considerar un
 * peso.
 * @author <a href="mailto:contact@nachintoch.mx">Manuel Castillo,
 * nachintoch</a>
 * @version 1.0, abril 2013.
 * @see java.lang.Comparable
 */
public interface ComparableValue extends Comparable {

    /**
     * Devuelve un valor entero que representa el "peso" de &eacute;ste objeto.
     * @return int - El peso del objeto.
     */
    int getValue();

}//ComparableValue interface

