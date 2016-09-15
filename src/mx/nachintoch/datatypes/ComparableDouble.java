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
 * Real especial que implementa la interfaz <tt>ComparableValue</tt>. Es muy
 * similar a <tt>java.lang.Double</tt>.
 * @author <a href="mailto:contact@nachintoch.mx">Manuel Castillo,
 * nachintoch</a>
 * @version 1.0, abril 2013.
 */
public class ComparableDouble extends Number implements ComparableValue {

    // atributos de clase
    
    /**
     * El entero primitivo envuelto en &eacute;sta clase.
     */
    private double value;

    // métodos constructores
    
    /**
     * Construye un <tt>EnteroComparable</tt> con el valor especificado.
     * @param value - El valor del entero.
     */
    public ComparableDouble(double value) {
        super();
        this.value = value;
    }//constructor con valor entero
    
    /**
     * Construye un <tt>EnteroComparable</tt> con la cadena dada. &Eacute;sta
     * debe lexicogr&acute;ficamente representar un n&uacute;mero real
     * de 64 bits v&aacute;lido para <tt>Java</tt>.
     * @param s - La cadena a partir de la cual se va a tomar el valor del
     * entero representado.
     */
    public ComparableDouble(String s) {
        super();
        value = Double.parseDouble(s);
    }//constructor con cadena
    
    // métodos de implementación
    
    @Override
    public int getValue() {
        return (int) value;
    }//getValue

    @Override
    public int compareTo(Object obj) {
        if(obj instanceof Number) {
            Number aux = (Number) obj;
            int otherValue = aux.intValue();
            if(otherValue > value)
                return -1;
            if(otherValue < value)
                return 1;
            return 0;
        } else
            throw new ClassCastException("Not an enclosing number object for "
                +obj.toString());
    }//compareTo
    
    @Override
    public double doubleValue() {
        return value;
    }//doubleValue
    
    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj instanceof Number) {
            return ((Number) obj).intValue() == value;
        } else
            return false;
    }//equals
    
    @Override
    public float floatValue() {
        return (float) value;
    }//floatValue
    
    @Override
    public int hashCode() {
        Double aux = new Double(value);
        return aux.hashCode();
    }//hashCode
    
    @Override
    public int intValue() {
        return (int) value;
    }//intValue
    
    @Override
    public long longValue() {
        return (long) value;
    }//longValue
    
    @Override
    public String toString() {
        return String.valueOf(value);
    }//toString

}//ComparableValue

