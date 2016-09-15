package mx.nachintoch.datatypes;

import java.nio.charset.Charset;
import java.io.Serializable;
import java.util.Locale;
import java.io.UnsupportedEncodingException;

/*
 * This file is part of Nachintoch utils library for Java and Android.
 *
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
 * Cadena de valor comparable. Reimplementa todos los m&eacute;todos de la
 * clase String (java.lang.String); con la habilidad de adem&aacute;s retornar
 * su valor como objeto comprable.
 * @author <a href="mailto:contact@nachintoch.mx" >Manuel Castillo,
 * "Nachintoch"</a>
 * @version 1.0, diciembre 2013
 * @see java.lang.String
 */
public class NachintochString implements ComparableValue, Serializable,
	CharSequence {
	
	// atributos de clase
	
	/**
	 * Cadena original envuelta en &eacute;sta cadena de valor comparable.
	 */
	public String string;
	
	// métodos constructores
	
	/**
	 * Constuye la cadena vac&iacute;a.
	 * @see java.lang.String#String()
	 */
	public NachintochString() {
		string = new String();
	}//constructor por omisión
	
	/**
	 * Toma un arreglo de bytes y  lo decodifica como una cadena de
	 * caracteres.
	 * @param bytes - El arreglo de bytes a decodificar.
	 * @see java.lang.String#String(byte[])
	 */
	public NachintochString(byte[] bytes) {
		string = new String(bytes);
	}//constructor con arreglo de bytes.
	
	/**
	 * Toma un subarreglo de bytes del dado y lo decodifica en una cadena de
	 * caracteres.
	 * @param bytes - El arreglo original del que se va a decodificar un
	 * subarreglo.
	 * @param offset - El &iacute;ndice inicial de donde se va a tomar un
	 * subarreglo.
	 * @param length - El tama&ntilde;o del subarreglo
	 * @see java.lang.String#String(byte[], int, int)
	 */
	public NachintochString(byte[] bytes, int offset, int length) {
		string = new String(bytes, offset, length);
	}//constructor de subarreglo de bytes
	
	/**
	 * Toma un subarreglo de bytes del dado y lo decodifica en una cadena de
	 * caracteres. La decodificaci&oacute;n se basa en el set de caracteres
	 * dado.
	 * @param bytes - El arreglo original del que se va a decodificar un
	 * subarreglo.
	 * @param offset - El &iacute;ndice inicial de donde se va a tomar un
	 * subarreglo.
	 * @param length - El tama&ntilde;o del subarreglo
	 * @param charset - El set de decodificaci&oacute;n de caracteres.
	 * @see java.lang.String#String(byte[], int, int, Charset)
	 */
	public NachintochString(byte[] bytes, int offset, int length,
		Charset charset) {
		string = new String(bytes, offset, length, charset);
	}//constructor de subarreglo de bytes y set de decodificación
	
	/**
	 * Toma un subarreglo de bytes del dado y lo decodifica en una cadena de
	 * caracteres. La decodificaci&oacute;n se basa en el set de caracteres
	 * de nombre dado.
	 * @param bytes - El arreglo original del que se va a decodificar un
	 * subarreglo.
	 * @param offset - El &iacute;ndice inicial de donde se va a tomar un
	 * subarreglo.
	 * @param length - El tama&ntilde;o del subarreglo
	 * @param charsetName - El nombre del set de decodificaci&oacute;n de
	 * caracteres a usar para decodificar.
	 * @throws UnsupportedEncodingException - Si no se reconoce el conjunto de
	 * decodificaci&oacute;n de caracteres.
	 * @see java.lang.String#String(byte[], int, int, java.lang.String)
	 */
	public NachintochString(byte[] bytes, int offset, int length,
		String charsetName) throws UnsupportedEncodingException {
		string = new String(bytes, offset, length, charsetName);
	}//constructor de subarreglo de bytes y nombre de set de decodificación
	
	/**
	 * Toma un arreglo de bytes y  lo decodifica como una cadena de
	 * caracteres, usando el nombre del set de decodificaci&oacute;n dado.
	 * @param bytes - El arreglo de bytes a decodificar.
	 * @param charsetName - El nombre del set de decodificaci&oacute;n de
	 * caracteres a usar para decodificar.
	 * @throws UnsupportedEncodingException - Si no se reconoce el conjunto de
	 * decodificaci&oacute;n de caracteres.
	 * @see java.lang.String#String(byte[], String)
	 */
	public NachintochString(byte[] bytes, String charsetName)
			throws UnsupportedEncodingException {
		string = new String(bytes, charsetName);
	}//constructor con arreglo de bytes con nombre de set de decodificación
	
	/**
	 * Crea una cadena de valor comparable con el arreglo de caracteres dado.
	 * @param value - El arreglo que representa la cadena.
	 * @see java.lang.String#String(char[])
	 */
	public NachintochString(char[] value) {
		string = new String(value);
	}//constructor con origen
	
	/**
	 * Construye una cadena de valor comparable con un subarreglo de
	 * caracteres del dado.
	 * @param value - El arreglo que contiene el que va a representar a la
	 * cadena.
	 * @param offset - El primer &iacute;ndice del arreglo del que se va tomar
	 * el subarreglo para construir la cadena.
	 * @param count - El n&uacute;mero de caracteres que se van a tomar del
	 * arreglo dado a partir de <tt>offset</tt>
	 * @see java.lang.String#String(char[], int, int)
	 */
	public NachintochString(char[] value, int offset, int count) {
		string = new String(value, offset, count);
	}//constructor con origen de subarreglo
	
	/**
	 * Construye una cadena de valor comparable con un subarreglo de
	 * c&oacute;digo UNICODE dado.
	 * @param codePoints - El arreglo que contiene el c&oacute;digo UNICODE
	 * con el que va a representar a la cadena.
	 * @param offset - El primer &iacute;ndice del arreglo del que se va tomar
	 * el subarreglo para construir la cadena.
	 * @param count - El n&uacute;mero de caracteres que se van a tomar del
	 * arreglo dado a partir de <tt>offset</tt>
	 * @see java.lang.String#String(int[], int, int)
	 */
	public NachintochString(int[] codePoints, int offset, int count) {
		string = new String(codePoints, offset, count);
	}//constructor con origen de código UNICODE
	
	/**
	 * Construye una cadena de valor comparable a partir de la dada.
	 * @param original - La cadena a copiar
	 * @see java.lang.String#String(java.lang.String)
	 */
	public NachintochString(String original) {
		string = new String(original);
	}//constructor de copia
	
	/**
	 * Construye una cadena de valor comparable a partir de la dada.
	 * @param original - La cadena a copiar
	 * @see java.lang.String#String(java.lang.String)
	 */
	public NachintochString(NachintochString original) {
		string = new String(original.getString());
	}//constructor de copia
	
	/**
	 * Construye una cadena de valor comparable a partir del buffer dado.
	 * @param buffer - El buffer de la cadena a construir.
	 * @see java.lang.String#String(java.lang.StringBuffer)
	 */
	public NachintochString(StringBuffer buffer) {
		string = new String(buffer);
	}//constructor desde buffer
	
	/**
	 * Construye una cadena de valor comparable a partir del constructor de
	 * cadenas dado.
	 * @param builder - El constructor de cadenas a partir del cual se va a
	 * crear esta.
	 * @see java.lang.String#String(java.lang.StringBuilder)
	 */
	public NachintochString(StringBuilder builder) {
		string = new String(builder);
	}//constructor desde constructor de cadenas
	
	// métodos de acceso
	
	/**
	 * Devuelve la cadena envuelta.
	 * @return String - La cadena representada.
	 */
	public String getString() {
		return string;
	}//getStirng
	
	// métodos de implementación
	
	/**
	 * <p>Devuelve el valor del objeto comparable.</p>
	 * Dado que se trata de una cadena; su valor, es un n&uacute;mero que se
	 * trate de interpretar su valor (como entero). Si no es posible parsear
	 * la cadena en un entero; entonces se devuelve el hash de la cadena
	 * envuelta.
	 * @return int - El valor.
	 */
	@Override
	public int getValue() {
		try {
			return Double.valueOf(string).intValue();
		} catch(Exception e) {
			return string.hashCode();
		}//trata de interpretar la cadena como entero
	}//getValue
	
	@Override
	public char charAt(int index) {
		return string.charAt(index);
	}//charAt
	
	/**
	 * Indica el UNICODE del caracter en la posici&oacute;n dada.
	 * @param index - El &iacute;ndice del que se quiere conocer el UNICODE.
	 * @return int - El c&oacute;digo UNICODE del caracter en la
	 * posici&oacute;n dada.
	 */
	public int codePointAt(int index) {
		return string.codePointAt(index);
	}//codePointAt
	
	/**
	 * Indica el UNICODE del caracter en la posici&oacute;n anterior a la
	 * dada.
	 * @param index - El &iacute;ndice posterior al del caracter del que se
	 * quiere conocer el UNICODE.
	 * @return int - El c%oacue;digo UNICODE del caracter en la
	 * posici&oacute;n dada.
	 */
	public int codePointBefore(int index) {
		return string.codePointBefore(index);
	}//codePontBefore
	
	/**
	 * Indica el n&uacute;mero de puntos de UNICODE entre el intervalo dado
	 * para &eacute;sta cadena.
	 * @param beginIndex - La primer posici&oacute;n del intervalo.
	 * @param endIndex - La &uacute;ltima posici&oacute;n del intervalo.
	 * @return int - El n&uacute;mero de puntos de UNICODE del intervalo.
	 */
	public int codePointCount(int beginIndex, int endIndex) {
		return string.codePointCount(beginIndex, endIndex);
	}//codePointCount
	
	@Override
	public int compareTo(Object anotherObject) {
		if(anotherObject instanceof NachintochString) {
			return string.compareTo(((NachintochString) anotherObject)
				.getString());
		} else if(anotherObject instanceof String) {
			return string.compareTo((String) anotherObject);
		} else {
			throw new IllegalArgumentException("A NachintochString object is "
				+ "only comparable with another NachintochString or a "
				+ "java.lang.String (the normal one)");
		}//si el objeto dado es una cadena
	}//compareTo
	
	/**
	 * Compara &eacute;sta cadena con la dada lexicogr&aacute;ficamente;
	 * ignorando las diferencias que puedan existir entre ambas en cuanto a
	 * may&uacute;sculas y min&uacute;sculas.
	 * @param nchStr - La otra cadena a comparar.
	 * @return int - Negativo si la cadena dada es mayor, 0 si son
	 * equivalentes y positivo si la dada es menor que &eacute;sta
	 * lexicogr&aacute;ficamente.
	 * @see java.lang.String#compareToIgnoreCase(java.lang.String)
	 */
	public int compareToIgnoreCase(NachintochString nchStr) {
		return string.compareToIgnoreCase(nchStr.getString());
	}//compareToIgnoreCase
	
	/**
	 * Compara &eacute;sta cadena con la dada lexicogr&aacute;ficamente;
	 * ignorando las diferencias que puedan existir entre ambas en cuanto a
	 * may&uacute;sculas y min&uacute;sculas.
	 * @param str - La otra cadena a comparar.
	 * @return int - Negativo si la cadena dada es mayor, 0 si son
	 * equivalentes y positivo si la dada es menor que &eacute;sta
	 * lexicogr&aacute;ficamente.
	 * @see java.lang.String#compareToIgnoreCase(java.lang.String)
	 */
	public int compareToIgnoreCase(String str) {
		return string.compareToIgnoreCase(str);
	}//compareToIgnoreCase
	
	/**
	 * Concatena la cadena dada al final de &eacute;sta cadena.
	 * @param nchStr - La cadena a concatenar.
	 * @return NachintochString - La cadena resultante.
	 * @see java.lang.String#concat(java.lang.String)
	 */
	public NachintochString concat(NachintochString nchStr) {
		return new NachintochString(string.concat(nchStr.getString()));
	}//concat
	
	/**
	 * Concatena la cadena dada al final de &eacute;sta cadena.
	 * @param str - La cadena a concatenar.
	 * @return NachintochString - La cadena resultante.
	 * @see java.lang.String#concat(java.lang.String)
	 */
	public NachintochString concat(String str) {
		return new NachintochString(string.concat(str));
	}//concat
	
	/**
	 * Indica si la secuencia de caracteres dada est&aacute; contenida en
	 * &eacute;sta.
	 * @param s - La secuencia a verificar est&aacute; dentro de
	 * &eacute;sta.
	 * @return boolean - <tt>true</tt> si la cadena dada forma parte de
	 * &eacute;sta; <tt>false</tt> en otro caso.
	 * @see java.lang.String#contains(java.lang.CharSequence)
	 */
	public boolean contains(CharSequence s) {
		if(s instanceof NachintochString) {
			return string.contains(((NachintochString) s).getString());
		} else {
			return string.contains(s);
		}//dependiendo si se trata de una NachintochString
	}//contains
	
	/**
	 * Indica si la secuencia de caracteres es equivalente a &eacute;sta.
	 * @param cs - La secuencia de caracteres a comparar.
	 * @return boolean - <tt>true</tt> si son equivalentes; <tt>false</tt>
	 * en otro caso.
	 * @see java.lang.String#contentEquals(java.lang.CharSequence)
	 */
	public boolean contentEquals(CharSequence cs) {
		if(cs instanceof NachintochString) {
			return string.contentEquals(((NachintochString) cs).getString());
		} else {
			return string.contentEquals(cs);
		}//dependeindo si se trata de una NachintochString
	}//contentEquals
	
	/**
	 * Indica si el buffer de cadena es equivalente a &eacute;sta cadena.
	 * @param sb - La secuencia de caracteres a comparar.
	 * @return boolean - <tt>true</tt> si son equivalentes; <tt>false</tt>
	 * en otro caso.
	 * @see java.lang.String#contentEquals(java.lang.StringBuffer)
	 */
	public boolean contentEquals(StringBuffer sb) {
		return string.contentEquals(sb);
	}//contentEquals
	
	/**
	 * Indica si la cadena termina con el sufijo dado.
	 * @param suffix - El sufijo que se desea saber si tiene &eacute;sta
	 * cadena.
	 * @return boolean - <tt>true</tt> si &eacute;sta cadena termina con
	 * el sufijo dado, <tt>false</tt> en otro caso.
	 * @see java.lang.String#endsWith(java.lang.String)
	 */
	public boolean endsWith(NachintochString suffix) {
		return string.endsWith(suffix.getString());
	}//endsWith
	
	/**
	 * Indica si la cadena termina con el sufijo dado.
	 * @param suffix - El sufijo que se desea saber si tiene &eacute;sta
	 * cadena.
	 * @return boolean - <tt>true</tt> si &eacute;sta cadena termina con
	 * el sufijo dado, <tt>false</tt> en otro caso.
	 * @see java.lang.String#endsWith(java.lang.String)
	 */
	public boolean endsWith(String suffix) {
		return string.endsWith(suffix);
	}//endsWith
	
	@Override
	public boolean equals(Object anObject) {
		if(anObject instanceof NachintochString) {
			return string.equals(((NachintochString) anObject).getString());
		} else {
			return string.equals(anObject);
		}//compara dependiendo se trate de una cadena de Nachintoch u otro
	}//equals
	
	/**
	 * Compara &eacute;sta cadena con otra ignorando las diferencias que
	 * pudieran existir entre may&uacute;sculas y min&uacute;sculas.
	 * @param anotherString - La cadena con la que debe compararse
	 * &eacute;sta.
	 * @return boolean - <tt>true</tt> si las cadenas son
	 * lexicogr&aacute;ficamente equivalentes; salvo may&uacute;sculas/
	 * min&uacute;sculas. <tt>false</tt> en otro caso.
	 * @see java.lang.String#equalsIgnoreCase(java.lang.String)
	 */
	public boolean equalsIgnoreCase(NachintochString anotherString) {
		return string.equalsIgnoreCase(anotherString.getString());
	}//equalsIgnoreCase
	
	/**
	 * Compara &eacute;sta cadena con otra ignorando las diferencias que
	 * pudieran existir entre may&uacute;sculas y min&uacute;sculas.
	 * @param anotherString - La cadena con la que debe compararse
	 * &eacute;sta.
	 * @return boolean - <tt>true</tt> si las cadenas son
	 * lexicogr&aacute;ficamente equivalentes; salvo may&uacute;sculas/
	 * min&uacute;sculas. <tt>false</tt> en otro caso.
	 * @see java.lang.String#equalsIgnoreCase(java.lang.String)
	 */
	public boolean equalsIgnoreCase(String anotherString) {
		return string.equalsIgnoreCase(anotherString);
	}//equalsIgnoreCase
	
	/**
	 * Codifica &eacute;sta cadena en un arreglo de bytes.
	 * @return byte[] - El arreglo de bytes que codifica &eacute;sta cadena.
	 * @see java.lang.String#getBytes()
	 */
	public byte[] getBytes() {
		return string.getBytes();
	}//getBytes
	
	/**
	 * Codifica &eacute;sta cadena en un arreglo de bytes con el conjunto de
	 * caracteres dado.
	 * @param charset - El conjunto de caracteres para usar en la
	 * codificaci&oacute;n.
	 * @return byte[] - El arreglo de bytes que codifica &eacute;sta cadena
	 * con el conjunto de caracteres dado.
	 * @see java.lang.String#getBytes(java.lang.String)
	 */
	public byte[] getBytes(Charset charset) {
		return string.getBytes(charset);
	}//getBytes
	
	/**
	 * Copia los caracteres de la subcadena indicada en el subarreglo del dado
	 * a partir de la posici&oacute;n dada.
	 * @param srcBegin - El inicio de la subcadena.
	 * @param srcEnd - El final de la subcadena.
	 * @param dst - El arreglo en el que se va a ocupar una parte para
	 * escribir los caracteres que conforman la subcadena indicada.
	 * @param dstBegin - El &iacute;ndice del arreglo que se va a ocupar para
	 * poblar el subarreglo.
	 * @see java.lang.String#getChars(int, int, char[], int)
	 */
	public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
		string.getChars(srcBegin, srcEnd, dst, dstBegin);
	}//getChars
	
	@Override
	public int hashCode() {
		return string.hashCode();
	}//hashCode
	
	/**
	 * Indica el &iacute;ndice de la primer ocurrencia del caracter dado en
	 * toda la cadena.
	 * @param ch - El caracter cuyo &iacute;ndice de primer aparici&oacute;n
	 * se desea obtener.
	 * @return int - En &iacute;ndice en la cadena donde aparece por primera
	 * vez el caracter dado. Si no se encuentra; devuelve -1.
	 * @see java.lang.String#indexOf(int)
	 */
	public int indexOf(int ch) {
		return string.indexOf(ch);
	}//indexOf
	
	/**
	 * Indica el&iacute;ndice de la primer ocurrencia del caracter dado en la
	 * cadena a partir del &iacute;ndice especificado.
	 * @param ch - El caracter cuyo &iacute;ndice de primera aparici&oacute;n
	 * se desea a partir del &iacute;ndice dado.
	 * @param fromIndex - El &iacute;ndice a partir del cual se desea buscar
	 * el caracter dado en la cadena.
	 * @return int - El &iacute;ndice en la cadena; a partir del &iacute;ndice
	 * dado donde, aparece por primera vez el caracter buscado. Si no se
	 * encuentra; devuelve -1.
	 * @see java.lang.String#indexOf(int, int)
	 */
	public int indexOf(int ch, int fromIndex) {
		return string.indexOf(ch, fromIndex);
	}//indexOf
	
	/**
	 * Indica el &iacute;ndice de la &uacute;ltima ocurrencia del caracter
	 * dado en toda la cadena.
	 * @param ch - El caracter cuyo &iacute;ndice de &uacute;ltima
	 * aparici&oacute;n se desea obtener.
	 * @return int - En &iacute;ndice en la cadena donde aparece por
	 * &uacute;ltima vez el caracter dado. Si no se encuentra; devuelve -1.
	 * @see java.lang.String#lastIndexOf(int)
	 */
	public int lastIndexOf(int ch) {
		return string.lastIndexOf(ch);
	}//indexOf
	
	/**
	 * Indica el &iacute;ndice de la &uacute;ltima ocurrencia del caracter
	 * dado en la cadena a partir del &iacute;ndice especificado.
	 * @param ch - El caracter cuyo &iacute;ndice de &uacute;ltima
	 * aparici&oacute;n se desea a partir del &iacute;ndice dado.
	 * @param fromIndex - El &iacute;ndice a partir del cual se desea buscar
	 * el caracter dado en la cadena.
	 * @return int - El &iacute;ndice en la cadena; a partir del &iacute;ndice
	 * dado donde, aparece por &uacute;ltima vez el caracter buscado. Si no se
	 * encuentra; devuelve -1.
	 * @see java.lang.String#lastIndexOf(int, int)
	 */
	public int lastIndexOf(int ch, int fromIndex) {
		return string.lastIndexOf(ch, fromIndex);
	}//indexOf
	
	/**
	 * Indica el &iacute;ndice donde aparece por primera vez la subcadena
	 * dada.
	 * @param str - La cadena buscada.
	 * @return int - El &iacute;ndice en la cadena d&oacute;nde aparece por
	 * primera vez la subcadena. Si no aparece; devuelve -1.
	 * @see java.lang.String#indexOf(String)
	 */
	public int indexOf(String str) {
		return string.indexOf(str);
	}//indexOf
	
	/**
	 * Indica el &iacute;ndice donde aparece por primera vez la subcadena
	 * dada; a partir del &iacute;ndice dado.
	 * @param str - La subcadena buscada.
	 * @param fromIndex - El &iacute;ndice a partir de donde se va a buscar
	 * la subcadena.
	 * @return int - El &iacute;ndice donde aparece la subcadena en
	 * &eacute;sta a partir del dado. Si no la encuentra; devuelve -1.
	 */
	public int indexOf(String str, int fromIndex) {
		return string.indexOf(str, fromIndex);
	}//indexOf
	
	/**
	 * Indica el &iacute;ndice donde aparece por primera vez la subcadena
	 * dada.
	 * @param nchStr - La cadena buscada.
	 * @return int - El &iacute;ndice en la cadena d&oacute;nde aparece por
	 * primera vez la subcadena. Si no aparece; devuelve -1.
	 * @see java.lang.String#indexOf(String)
	 */
	public int indexOf(NachintochString nchStr) {
		return string.indexOf(nchStr.getString());
	}//indexOf
	
	/**
	 * Indica el &iacute;ndice donde aparece por primera vez la subcadena
	 * dada; a partir del &iacute;ndice dado.
	 * @param nchStr - La subcadena buscada.
	 * @param fromIndex - El &iacute;ndice a partir de donde se va a buscar
	 * la subcadena.
	 * @return int - El &iacute;ndice donde aparece la subcadena en
	 * &eacute;sta a partir del dado. Si no la encuentra; devuelve -1.
	 */
	public int indexOf(NachintochString nchStr, int fromIndex) {
		return string.indexOf(nchStr.getString(), fromIndex);
	}//indexOf
	
	/**
	 * Indica el &iacute;ndice donde aparece por &uacute;ltima vez la
	 * subcadena dada.
	 * @param str - La cadena buscada.
	 * @return int - El &iacute;ndice en la cadena d&oacute;nde aparece por
	 * &uacute;ltima vez la subcadena. Si no aparece; devuelve -1.
	 * @see java.lang.String#lastIndexOf(String)
	 */
	public int lastIndexOf(String str) {
		return string.lastIndexOf(str);
	}//indexOf
	
	/**
	 * Indica el &iacute;ndice donde aparece por &uacute;ltima vez la
	 * subcadena dada.
	 * @param nchStr - La cadena buscada.
	 * @return int - El &iacute;ndice en la cadena d&oacute;nde aparece por
	 * &uacute;ltima vez la subcadena. Si no aparece; devuelve -1.
	 * @see java.lang.String#lastIndexOf(String)
	 */
	public int lastIndexOf(NachintochString nchStr) {
		return string.lastIndexOf(nchStr.getString());
	}//indexOf
	
	/**
	 * Devuelve una representaci&oacute;n can&oacute;nica de la cadena.
	 * @return NachintochString - La representaci&oacute;n can&oacute;nica.
	 * @see java.lang.String#intern()
	 */
	public NachintochString intern() {
		return new NachintochString(string.intern());
	}//intern
	
	/**
	 * Indica si la cadena es vac&iacute;a.
	 * @return boolean - <tt>true</tt> si la cadena es vac&iacute;a, <tt>false
	 * </tt> en otro caso.
	 * @see java.lang.String#isEmpty()
	 */
	public boolean isEmpty() {
		return string.isEmpty();
	}//isEmpty
	
	@Override
	public int length() {
		return string.length();
	}//length
	
	/**
	 * Indica si &eacute;sta cadena equivale o no a la expresi&oacute;n
	 * regular dada.
	 * @param regex - La expresi&oacute;n regular a comprobar equivale a
	 * &eacute;sta cadena.
	 * @return boolean - <tt>true</tt> si &eacute;sta cadena equivale a la
	 * expresi&oacute;n regular dada, <tt>false</tt> en otro caso.
	 * @see java.lang.String#matches(java.lang.String)
	 */
	public boolean matches(String regex) {
		return string.matches(regex);
	}//matches
	
	/**
	 * Indica si &eacute;sta cadena equivale o no a la expresi&oacute;n
	 * regular dada.
	 * @param regex - La expresi&oacute;n regular a comprobar equivale a
	 * &eacute;sta cadena.
	 * @return boolean - <tt>true</tt> si &eacute;sta cadena equivale a la
	 * expresi&oacute;n regular dada, <tt>false</tt> en otro caso.
	 * @see java.lang.String#matches(java.lang.String)
	 */
	public boolean matches(NachintochString regex) {
		return string.matches(regex.getString());
	}//matches
	
	/**
	 * Obtiene el &iacute;ndice que se encentra desplazado desde el
	 * &iacute;ndice dado por le conjunto de puntos.
	 * @param index - El &iacute;ndice desde el que se quiere el
	 * desplazamiento.
	 * @param codePointOffset - El conjunto de puntos.
	 * @return int - El &iacute;ndice con desplazamiento.
	 * @see java.lang.String#offsetByCodePoints(int, int)
	 */
	public int offsetByCodePoints(int index, int codePointOffset) {
		return string.offsetByCodePoints(index, codePointOffset);
	}//offsetByCodePoints
	
	/**
	 * Indica si una regi&oacute;n de &eacute;sta cadena equivale a la de
	 * otra.
	 * @param ignoreCase - <tt>true</tt> si se desea ignorar las posibles
	 * diferencias entre may&uacute;sculas y min&uacute;sculas.
	 * @param toffset - El desplazamiento inicial; para tomar una subcadena
	 * de &eacute;sta cadena.
	 * @param other - La cadena con la regi&oacute;n que se quiere comparar de
	 * &eacute;sta.
	 * @param offset - El desplazamiento a tomar para la subcadena de la otra
	 * cadena con la que se va a comparar.
	 * @param len - La longitud de las subcadenas a comparar.
	 * @return boolean - <tt>true</tt> si las subcadenas son equivalentes;
	 * dependiendo de si se solicit&oacute; considerar las posibles
	 * diferencias entre may&uacute;sculas y min&uacute;sculas. Devuelve
	 * <tt>false</tt> en otro caso.
	 * @see java.lang.String#regionMatches(boolean, int, String, int, int)
	 */
	public boolean regionMatches(boolean ignoreCase, int toffset,
		String other, int offset, int len) {
		return string.regionMatches(ignoreCase, toffset, other, offset, len);
	}//regionMatches
	
	/**
	 * Indica si una regi&oacute;n de &eacute;sta cadena equivale a la de
	 * otra.
	 * @param toffset - El desplazamiento inicial; para tomar una subcadena
	 * de &eacute;sta cadena.
	 * @param other - La cadena con la regi&oacute;n que se quiere comparar de
	 * &eacute;sta.
	 * @param offset - El desplazamiento a tomar para la subcadena de la otra
	 * cadena con la que se va a comparar.
	 * @param len - La longitud de las subcadenas a comparar.
	 * @return boolean - <tt>true</tt> si las subcadenas son equivalentes;
	 * <tt>false</tt> en otro caso.
	 * @see java.lang.String#regionMatches(int, String, int, int)
	 */
	public boolean regionMatches(int toffset, String other, int offset,
		int len) {
		return string.regionMatches(toffset, other, offset, len);
	}//regionMatches
	
	/**
	 * Indica si una regi&oacute;n de &eacute;sta cadena equivale a la de
	 * otra.
	 * @param ignoreCase - <tt>true</tt> si se desea ignorar las posibles
	 * diferencias entre may&uacute;sculas y min&uacute;sculas.
	 * @param toffset - El desplazamiento inicial; para tomar una subcadena
	 * de &eacute;sta cadena.
	 * @param other - La cadena con la regi&oacute;n que se quiere comparar de
	 * &eacute;sta.
	 * @param offset - El desplazamiento a tomar para la subcadena de la otra
	 * cadena con la que se va a comparar.
	 * @param len - La longitud de las subcadenas a comparar.
	 * @return boolean - <tt>true</tt> si las subcadenas son equivalentes;
	 * dependiendo de si se solicit&oacute; considerar las posibles
	 * diferencias entre may&uacute;sculas y min&uacute;sculas. Devuelve
	 * <tt>false</tt> en otro caso.
	 * @see java.lang.String#regionMatches(boolean, int, String, int, int)
	 */
	public boolean regionMatches(boolean ignoreCase, int toffset,
		NachintochString other, int offset, int len) {
		return string.regionMatches(ignoreCase, toffset, other.getString(),
			offset, len);
	}//regionMatches
	
	/**
	 * Indica si una regi&oacute;n de &eacute;sta cadena equivale a la de
	 * otra.
	 * @param toffset - El desplazamiento inicial; para tomar una subcadena
	 * de &eacute;sta cadena.
	 * @param other - La cadena con la regi&oacute;n que se quiere comparar de
	 * &eacute;sta.
	 * @param offset - El desplazamiento a tomar para la subcadena de la otra
	 * cadena con la que se va a comparar.
	 * @param len - La longitud de las subcadenas a comparar.
	 * @return boolean - <tt>true</tt> si las subcadenas son equivalentes;
	 * <tt>false</tt> en otro caso.
	 * @see java.lang.String#regionMatches(int, String, int, int)
	 */
	public boolean regionMatches(int toffset, NachintochString other,
		int offset, int len) {
		return string.regionMatches(toffset, other.getString(), offset, len);
	}//regionMatches
	
	/**
	 * Devuelve una cadena nueva; reemplazando todas las ocurrencias del
	 * caracter el indicado.
	 * @param oldChar - El caracter a ser reemplazado en todas sus
	 * ocurrencias.
	 * @param newChar - El caracter con el que ser&aacute; reemplazado <tt>
	 * oldChar</tt>.
	 * @return NachintochString - La nueva cadena con <tt>newChar</tt> por
	 * <tt>oldChar</tt>.
	 * @see java.lang.String#replace(char, char)
	 */
	public NachintochString replace(char oldChar, char newChar) {
		return new NachintochString(string.replace(oldChar, newChar));
	}//replace
	
	/**
	 * Devuelve una cadena nueva; que parte de &eacute;sta, reemplazando la
	 * secuencia de caracteres indicada por la dada.
	 * @param target - La secuencia de caracteres que se desea reemplazar.
	 * @param replacement - La nueva secuencia de caracteres.
	 * @return NachintochString - La nueva cadena con la secuencia de
	 * caracteres <tt>replacement</tt> reemplazando a la secuencia <tt>taget
	 * </tt>
	 * @see java.lang.String#replace(CharSequence, CharSequence)
	 */
	public NachintochString replace(CharSequence target,
		CharSequence replacement) {
		if(target instanceof NachintochString) {
			if(replacement instanceof NachintochString) {
				return new NachintochString(string.replace(
					((NachintochString) target).getString(),
					((NachintochString) replacement).getString()));
			} else {
				return new NachintochString(string.replace(
					((NachintochString) target).getString(), replacement));
			}//si remplacement es una NachintochString
		} else {
			if(replacement instanceof NachintochString) {
				return new NachintochString(string.replace(target,
					((NachintochString) replacement).getString()));
			} else {
				return new NachintochString(string.replace(target,
					replacement));
			}//si remplacement es una NachintochString
		}//si target es una NachintochString
	}//replace
	
	/**
	 * Devuelve una cadena que parte de &eacute;sta; reemplazando todas las
	 * apariciones de la subcadena indicada; como expresi&oacute;n regular por
	 * la dada.
	 * @param regex - La expresi&oacute;n regular que se espera aparezca en
	 * &eacute;sta cadena.
	 * @param replacement - La cadena con la que se va a reemplazar la
	 * expresi&oacute;n regular dada.
	 * @return NachintochString - La cadena con las apariciones de <tt>regex
	 * </tt> reemplazadas por <tt>replacement</tt>.
	 * @see java.lang.String#replaceAll(String, String)
	 */
	public NachintochString replaceAll(String regex, String replacement) {
		return new NachintochString(string.replaceAll(regex, replacement));
	}//replaceAll
	
	/**
	 * Devuelve una cadena; que parte de &eacute;sta, reemplazando la primer
	 * aparici&oacute;n de la subcadena indicada; como expresi&oacute;n
	 * regular por la dada.
	 * @param regex - La expresi&oacute;n regular que se espera aparezca en
	 * &eacute;sta cadena.
	 * @param replacement - La cadena con la que se va a reemplazar la primer
	 * aparcici&oacute;n de la expresi&oacute;n regular dada.
	 * @return NachintochString - La cadena con la primer aparici&oacute;n de
	 * <tt>regex</tt> reemplazada por <tt>replacement</tt>.
	 * @see java.lang.String#replaceFirst(String, String)
	 */
	public NachintochString replaceFirst(String regex, String replacement) {
		return new NachintochString(string.replaceFirst(regex, replacement));
	}//replaceFirst
	
	/**
	 * Devuelve una cadena que parte de &eacute;sta; reemplazando todas las
	 * apariciones de la subcadena indicada; como expresi&oacute;n regular por
	 * la dada.
	 * @param regex - La expresi&oacute;n regular que se espera aparezca en
	 * &eacute;sta cadena.
	 * @param replacement - La cadena con la que se va a reemplazar la
	 * expresi&oacute;n regular dada.
	 * @return NachintochString - La cadena con las apariciones de <tt>regex
	 * </tt> reemplazadas por <tt>replacement</tt>.
	 * @see java.lang.String#replaceAll(String, String)
	 */
	public NachintochString replaceAll(NachintochString regex,
		NachintochString replacement) {
		return new NachintochString(string.replaceAll(regex.getString(),
			replacement.getString()));
	}//replaceAll
	
	/**
	 * Devuelve una cadena; que parte de &eacute;sta, reemplazando la primer
	 * aparici&oacute;n de la subcadena indicada; como expresi&oacute;n
	 * regular por la dada.
	 * @param regex - La expresi&oacute;n regular que se espera aparezca en
	 * &eacute;sta cadena.
	 * @param replacement - La cadena con la que se va a reemplazar la primer
	 * aparcici&oacute;n de la expresi&oacute;n regular dada.
	 * @return NachintochString - La cadena con la primer aparici&oacute;n de
	 * <tt>regex</tt> reemplazada por <tt>replacement</tt>.
	 * @see java.lang.String#replaceFirst(String, String)
	 */
	public NachintochString replaceFirst(NachintochString regex,
		NachintochString replacement) {
		return new NachintochString(string.replaceFirst(regex.getString(),
			replacement.getString()));
	}//replaceFirst
	
	/**
	 * Divide la cadena en varias resultantes que agrupa en un arreglo. Los
	 * puntos de ruptura, son las apariciones de <tt>regex</tt>; una
	 * expresi&oacute;n regular.
	 * @param regex - La expresi&oacute;n regular que sirve como punto de
	 * ruptura.
	 * @return NachintochString[] - El arreglo de las cadenas resultantes.
	 * @see java.lang.String#split(java.lang.String)
	 */
	public NachintochString[] split(String regex) {
		String[] preresult = string.split(regex);
		NachintochString[] result = new NachintochString[preresult.length];
		for(int i = 0; i < preresult.length; i++) {
			result[i] = new NachintochString(preresult[i]);
		}//puebla el reultado
		return result;
	}//split
	
	/**
	 * Divide la cadena en varias resultantes que agrupa en un arreglo; limita
	 * las diviciones por el segundo par&aacute;metro. Los puntos de ruptura
	 * son la expresi&oacute;n regular dada.
	 * @param regex - La expresi&oacute;n regular que sirve como punto de
	 * ruptura.
	 * @param limit - El n&uacute;mero m&aacute;ximo de subcadenas a crear.
	 * @return NachintochString[] - El arreglo de cadenas resultantes.
	 * @see java.lang.String#split(java.lang.String, int)
	 */
	public NachintochString[] split(String regex, int limit) {
		String[] preresult = string.split(regex, limit);
		NachintochString[] result = new NachintochString[preresult.length];
		for(int i = 0; i < preresult.length; i++) {
			result[i] = new NachintochString(preresult[i]);
		}//puebla el reultado
		return result;
	}//split
	
	/**
	 * Divide la cadena en varias resultantes que agrupa en un arreglo. Los
	 * puntos de ruptura, son las apariciones de <tt>regex</tt>; una
	 * expresi&oacute;n regular.
	 * @param regex - La expresi&oacute;n regular que sirve como punto de
	 * ruptura.
	 * @return NachintochString[] - El arreglo de las cadenas resultantes.
	 * @see java.lang.String#split(java.lang.String)
	 */
	public NachintochString[] split(NachintochString regex) {
		String[] preresult = string.split(regex.getString());
		NachintochString[] result = new NachintochString[preresult.length];
		for(int i = 0; i < preresult.length; i++) {
			result[i] = new NachintochString(preresult[i]);
		}//puebla el reultado
		return result;
	}//split
	
	/**
	 * Divide la cadena en varias resultantes que agrupa en un arreglo; limita
	 * las diviciones por el segundo par&aacute;metro. Los puntos de ruptura
	 * son la expresi&oacute;n regular dada.
	 * @param regex - La expresi&oacute;n regular que sirve como punto de
	 * ruptura.
	 * @param limit - El n&uacute;mero m&aacute;ximo de subcadenas a crear.
	 * @return NachintochString[] - El arreglo de cadenas resultantes.
	 * @see java.lang.String#split(java.lang.String, int)
	 */
	public NachintochString[] split(NachintochString regex, int limit) {
		String[] preresult = string.split(regex.getString(), limit);
		NachintochString[] result = new NachintochString[preresult.length];
		for(int i = 0; i < preresult.length; i++) {
			result[i] = new NachintochString(preresult[i]);
		}//puebla el reultado
		return result;
	}//split
	
	/**
	 * Indica si la cadena tiene el prefijo dado.
	 * @param prefix - El prefijo que se desea saber tiene &eacute;sta cadena.
	 * @return boolean - <tt>true</tt> si &eacute;sta cadena inicia con el
	 * prefijo <tt>prefix</tt>; <tt>false</tt> en otro caso.
	 * @see java.lang.String#startsWith(java.lang.String)
	 */
	public boolean startsWith(String prefix) {
		return string.startsWith(prefix);
	}//startsWith
	
	/**
	 * Indica si la cadena tiene el prefijo dado a partir del &iacute;ndice
	 * dado.
	 * @param prefix - El prefijo que se desea saber tiene &eacute;sta cadena.
	 * @param toffset - El &iacute;dice a partir de cual se quiere saber tiene
	 * el prefijo.
	 * @return boolean - <tt>true</tt> si &eacute;sta cadena inicia con el
	 * prefijo <tt>prefix</tt> a partir de <tt>toffset</tt>; <tt>false</tt> en
	 * otro caso.
	 * @see java.lang.String#startsWith(java.lang.String, int)
	 */
	public boolean startsWith(String prefix, int toffset) {
		return string.startsWith(prefix, toffset);
	}//startsWith
	
	/**
	 * Indica si la cadena tiene el prefijo dado.
	 * @param prefix - El prefijo que se desea saber tiene &eacute;sta cadena.
	 * @return boolean - <tt>true</tt> si &eacute;sta cadena inicia con el
	 * prefijo <tt>prefix</tt>; <tt>false</tt> en otro caso.
	 * @see java.lang.String#startsWith(java.lang.String)
	 */
	public boolean startsWith(NachintochString prefix) {
		return string.startsWith(prefix.getString());
	}//startsWith
	
	/**
	 * Indica si la cadena tiene el prefijo dado a partir del &iacute;ndice
	 * dado.
	 * @param prefix - El prefijo que se desea saber tiene &eacute;sta cadena.
	 * @param toffset - El &iacute;dice a partir de cual se quiere saber tiene
	 * el prefijo.
	 * @return boolean - <tt>true</tt> si &eacute;sta cadena inicia con el
	 * prefijo <tt>prefix</tt> a partir de <tt>toffset</tt>; <tt>false</tt> en
	 * otro caso.
	 * @see java.lang.String#startsWith(java.lang.String, int)
	 */
	public boolean startsWith(NachintochString prefix, int toffset) {
		return string.startsWith(prefix.getString(), toffset);
	}//startsWith
	
	@Override
	public CharSequence subSequence(int beginIndex, int endIndex) {
		return string.subSequence(beginIndex, endIndex);
	}//subSequece
	
	/**
	 * Devuelve la subcadena formada entre el &iacute;ndice dado (inclusivo)
	 * y el final de la cadena.
	 * @param beginIndex - El primer &iacute;ndice a tomar la subcadena.
	 * @return NachintochString - La subcadena resultante.
	 * @see java.lang.String#substring(int)
	 */
	public NachintochString substring(int beginIndex) {
		return new NachintochString(string.substring(beginIndex));
	}//substring
	
	/**
	 * Devuelve la subcadena formada por &eacute;sta, tomando los caracteres
	 * entre los &iacute;ndices dados.
	 * @param beginIndex - El primer&iacute;ndice a tomar de &eacute;sta
	 * cadena (inclusivo)
	 * @param endIndex - El &uacute;ltimo &iacute;ndice a tomar de &eacute;sta
	 * cadena (exclusivo)
	 * @return NachintochString - La subcadena resultante.
	 * @see java.lang.String#substring(int, int)
	 */
	public NachintochString substring(int beginIndex, int endIndex) {
		return new NachintochString(string.substring(beginIndex, endIndex));
	}//substring
	
	/**
	 * Devuelve el arreglo de caracteres que representa &eacute;sta cadena.
	 * @return char[] - El arreglo que modela &eacute;sta cadena.
	 * @see java.lang.String#toCharArray()
	 */
	public char[] toCharArray() {
		return string.toCharArray();
	}//toCharArray
	
	/**
	 * Devuelve una cadena equivalente a &eacute;sta, pero con todos los
	 * caracteres en min&uacute;scula.
	 * @return NachintochString - La cadena equivalente con todos los
	 * caracteres en min&uacute;scula.
	 * @see java.lang.String#toLowerCase()
	 */
	public NachintochString toLowerCase() {
		return new NachintochString(string.toLowerCase());
	}//toLowerCase
	
	/**
	 * Devuelve una cadena equvalente a &eacute;sta, pero con todos los
	 * caracteres en min&uacute;scula; considerando las reglas de la
	 * regi&oacute;n indicada.
	 * @param locale - La regi&oacute;n.
	 * @return NachintochString - La cadena equivalente con todos los
	 * caracteres en min&uacute;scula; de acuerdo a la regi&oacute;n.
	 * @see java.lang.String#toLowerCase(java.util.Locale)
	 */
	public NachintochString toLowerCase(Locale locale) {
		return new NachintochString(string.toLowerCase(locale));
	}//toLowerCase
	
	@Override
	public String toString() {
		return string;
	}//toString
	
	/**
	 * Devuelve una cadena equivalente a &eacute;sta, pero con todos los
	 * caracteres en may&uacute;scula.
	 * @return NachintochString - La cadena equivalente con todos los
	 * caracteres en may&uacute;scula.
	 * @see java.lang.String#toUpperCase()
	 */
	public NachintochString toUpperCase() {
		return new NachintochString(string.toUpperCase());
	}//toUpperCase
	
	/**
	 * Devuelve una cadena equivalente a &eacute;sta, pero con todos los
	 * caracteres en may&uacute;scula; considerando las reglas de la
	 * regi&oacute;n indicada.
	 * @param locale - La regi&oacute;n.
	 * @return NachintochString - La cadena equivalente con todos los
	 * caracteres en may&uacute;scula, de acuerdo a la regi&oacute;n.
	 * @see java.lang.String#toUpperCase(java.util.Locale)
	 */
	public NachintochString toUpperCase(Locale locale) {
		return new NachintochString(string.toUpperCase(locale));
	}//toUpperCase
	
	/**
	 * Devuelve una copia de &eacute;sta cadena,a removiendo los espacios en
	 * blanco al inicio y final de la misma.
	 * @return NachinotchString - La copia de la cadena sin espacios a los
	 * extremos.
	 * @see java.lang.String#trim()
	 */
	public NachintochString trim() {
		return new NachintochString(string.trim());
	}//trim
	
}//NachintochString

