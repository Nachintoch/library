/*
 * Copyright 2012 - 2016, Manuel "Nachintoch" Castillo.
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
 * 
 * Get more & contribute to open source software/hardware at
 * http://www.nachintoch.mx/ or just any other open source comunity...
 */
package mx.nachintoch.datatypes;

/**
 * Modela un vector en el plano real. Un vector tiene: magnitud en X, magnitud
 * en Y, direcci&oacute;n, magnitud (norma).
 * 
 * @author <a href="mailto:contact@nachintoch.mx" >Manuel
 * "nachintoch" Castillo</a>
 * @version 1.0, september 2016
 * @since Nachintoch Library for Java SE &amp; Android 2016
 */
public class NachintochVector {
    
    // atributos de clase
    
    /**
     * Magnitud del vector en X.
     * @since Nachintoch Vector 1.0, september 2016
     */
    protected double x;
    
    /**
     * Magnitud del vector en Y.
     * @since Nachintoch Vector 1.0, september 2016
     */
    protected double y;
    
    /**
     * &Aacute;ngulo de direcci&oacute;n del vector con respecto al eje X.
     * @since Nachintoch Vector 1.0, september 2016
     */
    protected double a;
    
    // métodos constructores
    
    /**
     * Construye un vector con las magnitudes y direcci&oacute;n dadas.
     * @param x - La magnitud del vector en X.
     * @param y - La magnitud del vector en Y.
     * @param a - La direcci&oacute;n del vector.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public NachintochVector(double x, double y, double a) {
        this.x = NachintochVector.rotateX(x, a);
        this.y = NachintochVector.rotateY(y, a);
        this.a = a;
    }//constructor con todo wero
    
    /**
     * Inicializa un vector con todos sus atributos en 0. Posteriormente pueden
     * ser alterados a necesidad.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public NachintochVector() {
        this.x = this.y = this.a = 0;
    }//constructor muerto de hambre
    
    // métodos de acceso
    
    /**
     * Devuelve la magnitud en X del vector.
     * @return double - La magnitud del vector en X.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public double getX() {
        return x;
    }//getX
    
    /**
     * Devuelve la magnitud en Y del vector.
     * @return double - La magnitud del vector en Y.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public double getY() {
        return y;
    }//getY
    
    /**
     * Devuelve la direcci&oacute;n del vector.
     * @return double - La direcci&oacute;n del vector.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public double getAngle() {
        return a;
    }//getAngle
    
    // métodos de modificación
    
    /**
     * Cambia el valor del &aacute;ngulo de direcci&oacute;n del vector.
     * @param a - El nuevo valor del &aacute;ngulo de rotaci&oacute;n.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public void setAngle(double a) {
        double norm = this.getNorm();
        this.x = NachintochVector.rotateX(norm, a);
        this.y = NachintochVector.rotateY(norm, a);
        this.a = a;
    }//setAngle
    
    /**
     * Cambia el valor de la magnitud en X.
     * @param x - El nuevo valor de la magnitud en X.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public void setX(double x) {
        this.x = x;
    }//setX
    
    /**
     * Cambia el valor de la magnitud en Y.
     * @param y - El nuevo valor de la magnitud en Y.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public void setY(double y) {
        this.y = y;
    }//setY
    
    /**
     * Cambia el valor de las magnitudes del vector.
     * @param x - El nuevo valor de la magnitud en X.
     * @param y - El nuevo valor de la magnitud en Y.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public void setMagnitudes(double x, double y) {
        this.x = x;
        this.y = y;
    }//setMagnitudes
    
    // métodos de implementación
    
    /**
     * Suma los radianes dados al &aacute;ngulo de direcci&oacute;n del vector.
     * @param a - Los radianes a sumar a la direcci&oacute;n.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public void addAngle(double a) {
        this.setAngle(this.a +a);
    }//addAngle
    
    /**
     * Realiza la suma de vectores, tambi&eacute;n conocida como la regla del
     * paralelogramo. El resultado afecta a este vector.
     * @param o - El otro vector que se quiere sumar con este.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public void sum(NachintochVector o) {
        this.sum(o.x, o.y);
    }//suma de vectores
    
    /**
     * Realiza la suma de vectores, tambi&eacute;n conocida como la regla del
     * paralelogramo. El resultado afecta a este vector.
     * @param a - El valor a sumar a la magnitud X de este vector.
     * @param b - El valor a sumar a la magnitud Y de este vector.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public void sum(double a, double b) {
        this.x += a;
        this.y += b;
    }//suma de vectores; usando escalares
    
    /**
     * Realiza el producto por un escalar. El resultado altera a este vector.
     * @param s - El escalar a multiplicar por este vector.
     * @since Nachintoch Vector 1.0, septeber 2016
     */
    public void scalarProd(double s) {
        this.x *= s;
        this.y *= s;
    }//scalarProd
    
    /**
     * Realza el producto punto entre este vector y el dado como
     * par&aacute;metro.
     * @param o - El escalar con el que se quiere realizar el producto punto.
     * @return double - El resultado de realizar el producto punto.
     * @since Nachintoch Vector 1.0, septeber 2016
     */
    public double dotProd(NachintochVector o) {
        return this.x *o.x +this.y *o.y;
    }//dotProd
    
    /**
     * Calcula la norma del vector.
     * @return double - La norma del vector.
     * @since Nachintoch Vector 1.0, septeber 2016
     */
    public double getNorm() {
        return Math.sqrt(x *x +y *y);
    }//getNorm

    @Override
    public String toString() {
        return "(" +x +"," +y +")";
    }//toString
    
    // métodos estaticos
    
    /**
     * Suma los dos vectores dados y crea uno nuevo como resultado de la suma.
     * @param a - Uno de los vectores a sumar.
     * @param b - El otro vector a sumar.
     * @return NachintochVector - El vector que representa la suma de a y b.
     * @since Nachintoch Vector 1.0, september 2016
     */
    public static NachintochVector sum(NachintochVector a, NachintochVector b) {
        double x = a.x +b.x;
        double y = a.y +b.y;
        return new NachintochVector(x, y, NachintochVector.getAngle(x, y));
    }//sum
    
    /**
     * Realiza el priducto punto entre los dos vectores dados.
     * @param a - Uno de los vectores a multiplicar.
     * @param b - El otro vector a multplicar.
     * @return double - El resultado de a x b
     * @since Nachintoch Vector 1.0, september 2016
     */
    public static double dotProd(NachintochVector a, NachintochVector b) {
        return a.x *b.x +a.y *b.y;
    }//dotProd
    
    /**
     * Calcula la norma de un vector con magnitudes X y Y dadas.
     * @param x - La magnitud del vector en X.
     * @param y - La magnitud del vector en Y.
     * @return double - La norma del vector.
     * @since Sprite 2.0, september 2016
     */
    public static double calculateNorm(double x, double y) {
        return Math.sqrt(x *x +y *y);
    }//calculateNorm
    
    /**
     * Devuelve la magnitud X rotada a la direcci&oacute;n dada.
     * @param x - La magnitud a rotar.
     * @param a - El &aacute;ngulo de rotaci&oacute;n.
     * @return double - La magnitud en X ya rotada.
     * @since Sprite 2.0, september 2016
     */
    public static double rotateX(double x, double a) {
        return x *Math.cos(a);
    }//rotateX
    
    /**
     * Devuelve la magnitud Y rotada a la direcci&oacute;n dada.
     * @param y - La magnitud a rotar.
     * @param a - El &aacute;ngulo de rotaci&oacute;n.
     * @return double - La magnitud en Y ya rotada.
     * @since NachintochVector 1.0, september 2016
     */
    public static double rotateY(double y, double a) {
        return y *Math.sin(a);
    }//rotateY
    
    /**
     * Devuelve el &aacute;ngulo que forma el vector con magnitudes X y Y.
     * @param x - La magnitud X del vector.
     * @param y - La magnitud Y del vector.
     * @return double - La direcci&oacute;n del vector formado por X y Y.
     * @since NachintochVector 1.0, september 2016
     */
    public static double getAngle(double x, double y) {
        return Math.atan(y /x);
    }//getAngle
    
}//NachintochVector
