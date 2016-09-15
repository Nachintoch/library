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
 * <p>Implementa un n&uacute;mero de acuerdo a <tt>java.lang.Number</tt> </p>
 * Su &uacute;nico prop&oacute;sito es dar una instancia de <tt>Number</tt>; ya
 * que es abstacta.
 * @author <a href="mailto:contact@nachintoch.mx">Manuel Castillo,
 * "nachintoch"</a>
 * @version 1.0, mayo 2013
 */
public class NachintochNumber extends Number implements ComparableValue {

    // atrubutos de clas
    
    /**
     * Contiene el valor del n&uacute;meto.
     */
    private double value;

    // métodos constructores
    
    /**
     * Construye un n&uacute;mero a partir del <tt>Number</tt> dado.
     * @param num - El n&uacute;mero a partir del cual se va a construir
     * &eacute;ste.
     */
    public NachintochNumber(Number num) {
        value = num.doubleValue();
    }//constructor de copia
    
    /**
     * Consturye un n&uacute;mero a partir del <tt>double</tt> dado.
     * @param num - El <tt>double</tt> a partir del cual se va a construir
     * &eacute;ste.
     */
    public NachintochNumber(double num) {
        value = num;
    }//constructor con valor numérico

    // métodos de implementación
    
    @Override
    public int intValue() {
        return (int) value;
    }//intValue
    
    @Override
    public long longValue() {
        return (long) value;
    }//lonogValue
    
    @Override
    public float floatValue() {
        return (float) value;
    }//floatValue
    
    @Override
    public double doubleValue() {
        return value;
    }//doubleValue
    
    @Override
    public byte byteValue() {
        return (byte) value;
    }//byteValue
    
    @Override
    public short shortValue() {
        return (short) value;
    }//shortValue
    
    @Override
    public int getValue() {
        return (int) value;
    }//getValue
    
    @Override
    public int compareTo(Object obj) {
        if(obj instanceof Number) {
            Number other = (Number) obj;
            if(other.doubleValue() > value)
                return -1;
            else if(other.doubleValue() < value)
                return 1;
            else
                return 0;
        } else
            return -1;
    }//cmpareTo
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Number) {
            return (compareTo(obj)) == 0;
        } else
            return false;
    }//equals

}//NachintochNumber class

