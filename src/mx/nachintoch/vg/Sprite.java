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
package mx.nachintoch.vg;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import mx.nachintoch.datatypes.NachintochVector;

/**
 * Modela un sprite.
 * 
 * @author <a href="mailto:contact@nachintoch.mx" >Manuel
 * "nachintoch" Castillo</a>
 * @version 2.0, september 2016
 * @since Nachintoch Library for Java SE &amp; Android 2012
 */
public class Sprite {
    
    // atributos de clase
    
    /**
     * Indica si el sprite deber&aacute; ser visible o no. Cuando un sprite es
     * invisible, no tienen efecto sus colisiones en otros sprites.
     * @since Character 1.0, may 2015
     */
    protected boolean isVisible;

    /**
     * Masa del sprite.
     * @since Sprite 1.0, may 2015
     */
    protected double mass;
    
    /**
     * Limita la fuerza que se le aplica al sprite en alguna magnitud. Puesto
     * que la fuerza que mueve al Sprite es un vector bidimensional, este
     * l&iacute;mite se piensa como una norma de un vector bidimensional (de
     * fuerza).
     * @since Sprite 2.0, september 2016
     */
    protected double maxForce;
    
    /**
     * Valor m&aacute;ximo de la norma de fricci&oacute;n que puede experimentar
     * el sprite.
     * @since Sprite 2.0, september 2016
     */
    protected double maxFriction;
    
    /**
     * Velocidad m&aacute;xima del sprite.
     * @since Sprite 1.0, may 2015
     */
    protected double terminalVelocity;
    
    /**
     * &Aacute;ngulo de rotaci&oacute;n del sprite con respecto al eje X.
     * @since Sprite 1.0, may 2015
     */
    protected double rotationAngle;
    
    /**
     * Indica si se est&aacute; usando una aceleraci&oacute;n constante. Esto
     * evita c&aacute;lculos inecesarios.
     * @since Sprite 1.0, may 2015
     */
    protected boolean isAccelConstant;
    
    /**
     * Indica si se est&aacute; usando una velocidad constante. Esto evita
     * c&aacute;lculos inecesarios.
     * @since Sprite 1.0, may 2015
     */
    protected boolean isSpeedConstant;
    
    /**
     * Magnitud de la fuerza que mueve al sprite.
     * @since Sprite 1.0, may 2015
     */
    protected final NachintochVector MOV_FORCE;
    
    /**
     * Magnitud de la aceleraci&oacute;n del sprite.
     * @since Sprite 1.0, may 2015
     */
    protected NachintochVector ACCEL;
    
    /**
     * Magnitud de la velocidad del sprite.
     * @since Sprite 1.0, may 2015
     */
    protected NachintochVector SPEED;
    
    /**
     * Coefieciente de fricci&oacute;n que experimenta el sprite al moverse.
     * @since Sprite 1.0, may 2015
     */
    protected NachintochVector FRICTION;
    
    /**
     * Capa de color multiprop&oacute;sito. Se puede usar para usar el mismo
     * sprite pero con muchos colores diferentes para distintos jugadores. Este
     * color debe incluir una capa alpha.
     * @since Sprite 1.0, may 2015
     */
    public final Color COLOR_LAYER;
    
    /**
     * Nombre de prop&oacute;sito general para el sprite.
     * @since Sprite 1.0, may 2015
     */
    public final String NAME;

    /**
     * El punto que representa la posici&oacute;n en pantalla del sprite.
     * @since Sprite 1.0, may 2015
     */
    public final Point POSITION;
    
    /**
     * El ancho de este sprite.
     * @since Sprite 1.0, may 2015
     */
    public final int WIDTH;
    
    /**
     * El alto de este sprite.
     * @since Sprite 1.0, may 2015
     */
    public final int HEIGHT;
   
    /**
     * Referencia a la imagen que es en s&iacute; el sprite. Se presenta en un
     * arreglo, para permitir la animacioacute;n.
     * @since Sprite 1.0, may 2015
     */
    public final Image[] SPRITE;
    
    /**
     * Identificador del sprite de prop&oacute;sito general.
     * @since Sprite 1.0, may 2015
     */
    public final int ID;
    
    // método constructor
    
    /**
     * Crea un sprite que no es representado por una imagen, si no por una forma
     * con color.
     * @param color - El color del sprite.
     * @param name - El nombre del sprite.
     * @param width - el ancho del sprite.
     * @param height - El alto del sprite.
     * @param id - El identificador del sprite
     * @since Sprite 1.0, may 2015
     */
    public Sprite(Color color, String name, int width, int height, int id) {
        this.COLOR_LAYER = color;
        this.WIDTH = width;
        this.HEIGHT = height;
        this.SPRITE = null;
        this.POSITION = new Point();
        this.ACCEL = new NachintochVector();
        this.FRICTION = new NachintochVector();
        this.MOV_FORCE = new NachintochVector();
        this.SPEED = new NachintochVector();
        NAME = name;
        ID = id;
        this.isVisible = true;
        this.isAccelConstant = this.isSpeedConstant = true;
    }//constructor sin sprite y sin movimiento alguno
    
    /**
     * Caraga e inicializa el sprite. Todas las magnitudes f&iacute;sicas del
     * sprite se inicializan en 0, por lo que se considera que la velocidad y
     * aceleraci&oacute;n son constantes.
     * @param imgs - Las im&aacute;genes a usar como hojas de animaci&oacute;n.
     * @param name - El nombre del sprite.
     * @param cLayer - La capa de color de prop&oacute;sito general.
     * @param id - El identificador del sprite
     * @exception IOException - Si ocurre un problema al tatar de leer las
     * im&aacute;genes.
     * @since Sprite 1.0, may 2015
     */
    public Sprite(Image[] imgs, String name, Color cLayer, int id)
            throws IOException {
        this.SPRITE = imgs;
        this.COLOR_LAYER = cLayer;
        ID = id;
        this.POSITION = new Point();
        this.ACCEL = new NachintochVector();
        this.FRICTION = new NachintochVector();
        this.MOV_FORCE = new NachintochVector();
        this.SPEED = new NachintochVector();
        this.WIDTH = this.SPRITE[0].getWidth(null);
        this.HEIGHT = this.SPRITE[0].getHeight(null);
        NAME = name;
        this.isAccelConstant = this.isSpeedConstant = true;
        this.isVisible = true;
    }//constructor por omisión
    
    /**
     * Construye un sprite que se mueve usando aceleraci&oacute;n constante.
     * @param imgs - Las im&aacute;genes a usar como hojas de animaci&oacute;n.
     * @param name - El nombre del sprite.
     * @param accelX - La constante de aceleraci&oacute;n a usar en X.
     * @param accelY - La constante de aceleraci&oacute;n a usar en X.
     * @param xFriction - El coeficiente de fricci&oacute;n a utilizar en X. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a X. Piense en los ni&ntilde;os.
     * @param yFriction - El coefiente de fricci&oacute;n a utilizar en Y. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a Y.
     * @param cLayer - La capa de color de prop&oacute;sito general.
     * @param terminalVelocity - Velocidad m&aacute;xima del sprite.
     * @param id - El identificador del sprite
     * @throws IOException - Si ocurre un problema al tatar de leer las
     * im&aacute;genes.
     * @since Sprite 1.0, may 2015
     */
    public Sprite(Image[] imgs, String name, Color cLayer, double accelX,
            double accelY, double xFriction, double yFriction,
            double terminalVelocity, int id) throws IOException {
        this(imgs, name, cLayer, id);
        this.ACCEL.setMagnitudes(accelX, accelY);
        this.FRICTION.setMagnitudes(Math.abs(xFriction), Math.abs(yFriction));
        this.maxFriction = NachintochVector.calculateNorm(xFriction, yFriction);
        this.isAccelConstant = true;
        this.isSpeedConstant = false;
    }//constructor con imagen de aceleración constante
    
    /**
     * Construye un sprite que es representado por una forma y un color y que
     * se mueve con aceleraci&oacute;n constante.
     * @param color - El color de la forma que representa al sprite.
     * @param name - El nombre del sprite.
     * @param width - El ancho del sprite.
     * @param height - El alto del sprite
     * @param accelX - La aceleraci&oacute;n en X.
     * @param accelY - La aceleraci&oacute;n en Y.
     * @param xFriction - El coeficiente de fricci&oacute;n a utilizar en X. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a X.
     * @param yFriction - El coefiente de fricci&oacute;n a utilizar en Y. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a Y.
     * @param terminalVelocity - La velocidad terminal del sprite.
     * @param id - El identificador del sprite
     * @since Sprite 1.0, may 2015
     */
    public Sprite(Color color, String name, int width, int height,
            double accelX, double accelY, double xFriction, double yFriction,
            double terminalVelocity, int id) {
        this(color, name, width, height, id);
        this.ACCEL.setMagnitudes(accelX, accelY);
        this.FRICTION.setMagnitudes(Math.abs(xFriction), Math.abs(yFriction));
        this.maxFriction = NachintochVector.calculateNorm(xFriction, yFriction);
        this.isAccelConstant = true;
        this.isSpeedConstant = false;
    }//constructor con forma colorida de aceleración constante
    
    /**
     * Construye un sprite que se mueve usando una velocidad constante.
     * @param imgs - Las im&aacute;genes a usar como hojas de animaci&oacute;n.
     * @param name - El nombre del sprite.
     * @param speedX - La constante de velocidad en X.
     * @param speedY - La constante de velocidad en Y.
     * @param xFriction - El coeficiente de fricci&oacute;n a utilizar en X. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a X.
     * @param yFriction - El coefiente de fricci&oacute;n a utilizar en Y. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a Y.
     * @param cLayer - La capa de color de prop&oacute;sito general.
     * @param id - El identificador del sprite.
     * @throws IOException  - Si ocurre un problema al tatar de leer las
     * im&aacute;genes.
     * @since Sprite 1.0, may 2015
     */
    public Sprite(Image[] imgs, String name, Color cLayer, double speedX,
            double speedY, double xFriction, double yFriction, int id)
            throws IOException {
        this(imgs, name, cLayer, id);
        this.SPEED.setMagnitudes(speedX, speedY);
        this.FRICTION.setMagnitudes(Math.abs(xFriction), Math.abs(yFriction));
        this.maxFriction = NachintochVector.calculateNorm(xFriction, yFriction);
        this.terminalVelocity = NachintochVector.calculateNorm(speedX, speedY);
        this.isAccelConstant = true;
        this.isSpeedConstant = true;
    }//constructor con imagen y de velocidad constante
    
    /**
     * Construye un sprite representado por un color y forma que se mueve a
     * velocidad constante.
     * @param color - El color de la forma que representa al sprite.
     * @param name - El nombre del sprite.
     * @param width - El ancho del sprite.
     * @param height - El alto del sprite.
     * @param speedX - La velocidad del sprite en X.
     * @param speedY - La velocidad del sprite en Y.
     * @param xFriction - El coeficiente de fricci&oacute;n a utilizar en X. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a X.
     * @param yFriction - El coefiente de fricci&oacute;n a utilizar en Y. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a Y.
     * @param id - El identificador del sprite
     * @since Sprite 1.0, may 2015
     */
    public Sprite(Color color, String name, int width, int height,
            double speedX, double speedY, double xFriction, double yFriction,
            int id) {
        this(color, name, width, height, id);
        this.SPEED.setMagnitudes(speedX, speedY);
        this.FRICTION.setMagnitudes(Math.abs(xFriction), Math.abs(yFriction));
        this.maxFriction = NachintochVector.calculateNorm(xFriction, yFriction);
        this.terminalVelocity = NachintochVector.calculateNorm(speedX, speedY);
        this.isAccelConstant = true;
        this.isSpeedConstant = true;
    }//constructor con color y forma y de velocidad constante
    
    /**
     * Construye un sprite que se mueve usando una fuerza.
     * @param imgs - Las im&aacute;genes a usar como hojas de animaci&oacute;n.
     * @param name - El nombre del sprite.
     * @param lukeUseTheX - La magnitud de la fuerza que pone al sprite en
     * movimiento en X.
     * @param lukeUseTheY - La magnitud de la fuerza que pone al sprite en
     * movimiento en Y.
     * @param lukeNoThatMuch - Limite de la fuerza con la que se puede mover al
     * Sprite.
     * @param mass - La masa del sprite.
     * @param xFriction - El coeficiente de fricci&oacute;n a utilizar en X. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a X.
     * @param yFriction - El coefiente de fricci&oacute;n a utilizar en Y. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a Y.
     * @param terminalVelocity - Velocidad m&aacute;xima del sprite.
     * @param cLayer - La capa de color de prop&oacute;sito general.
     * @param id - El identificador del sprite
     * @throws IOException - Si ocurre un problema al tatar de leer las
     * im&aacute;genes.
     * @since Sprite 1.0, may 2015
     */
    public Sprite(Image[] imgs, String name, Color cLayer, double lukeUseTheX,
            double lukeUseTheY, double lukeNoThatMuch, double mass,
            double xFriction, double yFriction, double terminalVelocity, int id)
            throws IOException {
        this(imgs, name, cLayer, id);
        this.MOV_FORCE.setMagnitudes(lukeUseTheX, lukeUseTheY);
        lukeNoThatMuch = Math.abs(lukeNoThatMuch);
        if(NachintochVector.calculateNorm(lukeUseTheX, lukeUseTheY) >
                lukeNoThatMuch) {
            throw new IllegalArgumentException("Given force vector norm is "
                    + "smaller than force limit.");
        }//si se pasa del límite a establecer
        this.maxForce = lukeNoThatMuch;
        this.mass = mass;
        this.FRICTION.setMagnitudes(Math.abs(xFriction), Math.abs(yFriction));
        this.maxFriction = NachintochVector.calculateNorm(xFriction, yFriction);
        this.terminalVelocity = terminalVelocity;
        this.isAccelConstant = this.isSpeedConstant = false;
    }//constructor de imagen con helado oscuro
    
    /**
     * Constuye un sprite representado por una forma de color que se mueve a
     * partir de una fuerza.
     * @param color - El color de la forma que representa al sprite.
     * @param name - El nombre del sprite.
     * @param width - El ancho del sprite.
     * @param height - El alto del sprite.
     * @param xForce - La fuerza que mueve al sprite en X.
     * @param yForce - La fuerza que mueve al sprite en Y.
     * @param forceLimit - Limite de la fuerza con la que se puede mover al
     * Sprite.
     * @param mass - La masa del sprite.
     * @param xFriction - El coeficiente de fricci&oacute;n a utilizar en X. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a X.
     * @param yFriction - El coefiente de fricci&oacute;n a utilizar en Y. Si
     * no le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s respecto a Y.
     * @param terminalVelocity - La velocidad terminal del sprite.
     * @param id - El identificador del sprite
     * @since Sprite 1.0, may 2015
     */
    public Sprite(Color color, String name, int width, int height,
            double xForce, double yForce, double forceLimit, double mass,
            double xFriction, double yFriction, double terminalVelocity,
            int id) {
        this(color, name, width, height, id);
        this.MOV_FORCE.setMagnitudes(xForce, yForce);
        forceLimit = Math.abs(forceLimit);
        if(NachintochVector.calculateNorm(xForce, yForce) > forceLimit) {
            throw new IllegalArgumentException("Given force vector norm is "
                    + "smaller than force limit.");
        }//si se pasa del límite a establecer
        this.maxForce = forceLimit;
        this.mass = mass;
        this.FRICTION.setMagnitudes(Math.abs(xFriction), Math.abs(yFriction));
        this.maxFriction = NachintochVector.calculateNorm(xFriction, yFriction);
        this.terminalVelocity = terminalVelocity;
        this.isAccelConstant = this.isSpeedConstant = false;
    }//contructor de forma colorida con fuerza
    
    // métodos de modificación
    
    /**
     * Cambia el estado del sprite, entre ser visible o no.
     * @param isVisible - <tt>true</tt> si debe ser visible, <tt>false</tt> en
     * otro caso.
     * @since Sprite 1.0, may 2015
     */
    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }//setVisible

    /**
     * Cambia la masa del sprite.
     * @param mass - La nueva masa del sprite.
     * @since Sprite 1.0, may 2015
     */
    public void setMass(double mass) {
        this.mass = mass;
    }//setMass
    
    /**
     * Cambia la fuerza m&aacute;xima que se le puede aplicar al sprite.
     * @param limit - La m&aacute;xima fuerza que se le puede aplicar al sprite.
     * @since Sprite 2.0, september 2016
     */
    public void setForceLimit(double limit) {
        this.maxForce = Math.abs(limit);
        if(MOV_FORCE.getX() > maxForce) {
            MOV_FORCE.setX(maxForce);
        } if(MOV_FORCE.getY() > maxForce) {
            MOV_FORCE.setY(maxForce);
        }//si se pasa de balls
    }//setForceLimit

    /**
     * Suma el valor de la fuerza dada al de la que mueve al sprite. Al usar una
     * fuerza, la aceleraci&oacute;n y la velocidad dejan de ser constantes.
     * May the fourth be with you.
     * @param force - La magnitud de la fuerza a agregar al sprite.
     * @since Sprite 1.0, may 2015
     */
    public void addMovForce(double force) {
        double x = MOV_FORCE.getX()
                +NachintochVector.rotateX(force, rotationAngle);
        double y = MOV_FORCE.getY()
                +NachintochVector.rotateY(force, rotationAngle);
        if(NachintochVector.calculateNorm(x, y) < this.maxForce) {
            MOV_FORCE.setMagnitudes(x, y);
        }//si no se pasa de 
        this.isAccelConstant = this.isSpeedConstant = false;
    }//setMovForceX
    
    /**
     * Asigna la fuerza que mueve al objeto en pantalla. No realiza
     * ning&uacute;n otro c&aacute;lculo m&aacute;s que sobre la fuerza.
     * @param movForceX - La fuerza que mueve al sprite en X.
     * @param movForceY - La fuerza que mueve al sprite en Y.
     * @param limit - El l&iacute;mite de la fuerza; como norma del vector.
     * @throws IllegalArgumentException - Si el l&iacute;mite de fuerza es menor
     * que la norma del vector dado.
     * @since Sprite 1.0, may 2015
     */
    public void setMovForce(double movForceX, double movForceY, double limit)
            throws IllegalArgumentException {
        double x = movForceX *Math.cos(this.rotationAngle);
        double y = movForceY *Math.sin(this.rotationAngle);
        limit = Math.abs(limit);
        if(NachintochVector.calculateNorm(x, y) > limit) {
            throw new IllegalArgumentException("Given force vector norm is "
                    + "smaller than force limit. Think of the children");
        }//si se pasa del límite a establecer
        this.MOV_FORCE.setMagnitudes(x, y);
        this.maxForce = limit;
        this.isAccelConstant = this.isSpeedConstant = false;
    }//setMoveForce
    
    /**
     * Cambia el valor de la acelerac&oacute;n del sprite. Esto anula la fuerza
     * que se estuviera usando y la cambia por una aceleraci&oacute;nb
     * constante.
     * @param accelX - La magnitud de la aceleraci&oacute;n del sprite en X.
     * @param accelY - La magnitud de la aceleraci&oacute;n del sprite en Y.
     * @since Sprite 1.0, mayo 2015
     */
    public void setAccel(double accelX, double accelY) {
        this.MOV_FORCE.setMagnitudes(accelX *Math.cos(this.rotationAngle),
                accelY *Math.sin(this.rotationAngle));
        this.isAccelConstant = true;
        this.isSpeedConstant = false;
    }//setAccelX

    /**
     * Cambia el valor del &aacute;ngulo de movimiento.
     * @param a - El nuevo &aacute;ngulo de movimiento.
     * @since Sprite 1.0, mayo 2015
     */
    public void setAngle(double a) {
        if(!this.isAccelConstant) {
            this.MOV_FORCE.setAngle(a);
        } if(!this.isSpeedConstant) {
            this.ACCEL.setAngle(a);
        }//cambia la dirección del verctor que mueve el objeto
        this.SPEED.setAngle(a);
        this.rotationAngle = a;
    }//setAngle
    
    /**
     * Suma al &aacute;ngulo de movimiento actual del sprite los radianes dados.
     * @param a - Los radianes a sumar al &aacute;ngulo de movimiento.
     * @since Sprite 2.0, september 2016
     */
    public void addAngle(double a) {
        if(!this.isAccelConstant) {
            this.MOV_FORCE.addAngle(a);
        } if(!this.isSpeedConstant) {
            this.ACCEL.addAngle(a);
        }//cambia la dirección del verctor que mueve el objeto
        this.SPEED.addAngle(a);
        this.rotationAngle = a;
    }//addAngle
    
    /**
     * Cambia el valor de la velociad del sprite. Esto anula la fuerza y
     * aceleraci&oacute;n que se estuvieran usando para mover el sprite y los
     * cambia por una velocidad constante.
     * @param speedX - La magnitud del sprite en X.
     * @param speedY - La magnitud del sprite en Y.
     * @since Sprite 1.0, mayo 2015
     */
    public void setSpeed(double speedX, double speedY) {
        this.SPEED.setMagnitudes(speedX, speedY);
        this.terminalVelocity = NachintochVector.calculateNorm(speedX, speedY);
        this.ACCEL.setMagnitudes(0, 0);
        this.MOV_FORCE.setMagnitudes(0, 0);
        this.isAccelConstant = this.isSpeedConstant = true;
    }//setSpeed
    
    /**
     * Cambia el coeficiente de fricci&oacute;n que experimenta el sprite. Si no
     * le da un valor distinto de 0, el sprite una vez en movimiento no se
     * detendr&aacute; jam&aacute;s. Alguien quiere pensar en los ni&ntilde;os!?
     * @param xFriction - El valor del coeficiente de fricci&oacute;n en X.
     * @param yFriction - El valor del coeficiente de fircci&oacute;n en Y.
     * @since Sprite 1.0, mayo 2015
     */
    public void setFriction(double xFriction, double yFriction) {
        this.FRICTION.setMagnitudes(Math.abs(xFriction), Math.abs(yFriction));
    }//setFriction
    
    /**
     * Cambia la velocidad m&aacute;xima que se le permite alcanzar al sprite.
     * @param terminalVelocity - El valor de la velocidad m&aacute;xima.
     * @since Sprite 1.0, mayo 2015
     */
    public void setTerminalVelocity(double terminalVelocity) {
        this.terminalVelocity = terminalVelocity;
    }//setTerminalVelocity
    
    // métodos de acceso
    
    /**
     * Indica los radianes que est&aacute; rotado el sprite.
     * @return float - Los radianes que est&aacute; rotado el sprite.
     * @since Sprite 1.0, may 2015
     */
    public double getAngle() {
        return this.rotationAngle;
    }//getAngle

    /**
     * Indica si el sprite es visible o no.
     * @return boolean - <tt>true</tt> si el esprite es visible, false en otro
     * caso.
     * @since Sprite 1.0, may 2015
     */
    public boolean isVisible() {
        return isVisible;
    }//isVisible

    /**
     * Indica la fuerza con la que se mueve en X.
     * @return double - La fuerza de empuje en X.
     * @since Sprite 1.0, may 2015
     */
    public double getMovForceX() {
        return this.MOV_FORCE.getX();
    }//getMovForceX

    /**
     * Indica la fuerza con la que se mueve en Y.
     * @return double - La fuerza de empuje en Y.
     * @since Sprite 1.0, may 2015
     */
    public double getMovForceY() {
        return this.MOV_FORCE.getY();
    }//getMovForceY

    /**
     * Indica la aceleraci&oacute;n con la que se mueve en X.
     * @return double - La aceleraci&oacute;n en X.
     * @since Sprite 1.0, may 2015
     */
    public double getAccelX() {
        return this.ACCEL.getX();
    }//getAccelX

    /**
     * Indica la acelerac&oacute;n con la que se mueve en Y.
     * @return double - La aceleraci&oacute;n en Y.
     * @since Sprite 1.0, may 2015
     */
    public double getAccelY() {
        return this.ACCEL.getY();
    }//getAccelY

    /**
     * Indica la velocidad con la que se mueve en X.
     * @return double - La velocidad en X.
     * @since Sprite 1.0, may 2015
     */
    public double getSpeedX() {
        return this.SPEED.getX();
    }//speedX

    /**
     * Indica la velocidad con la que se mueve en Y.
     * @return double - La velocidad en Y.
     * @since Sprite 1.0, may 2015
     */
    public double getSpeedY() {
        return this.SPEED.getY();
    }//getSpeedY
    
    // métodos de implementación
    
    /**
     * Cambia la direcci&oacute;n el vector que mueva al sprite.
     * @param x - Si debe rebotar respecto a X.
     * @param y - Si debe rebotar respecto a Y.
     * @since Sprite 1.0, may 2015
     */
    public void recoill(boolean x, boolean y) {
        if(!this.isAccelConstant) {
            if(x) {
                this.MOV_FORCE.setX(MOV_FORCE.getX() *-1);
            } if(y) {
                this.MOV_FORCE.setY(MOV_FORCE.getY() *-1);
            }//rebota según lo indica
        } else if(!this.isSpeedConstant) {
            if(x) {
                this.ACCEL.setX(ACCEL.getX() *-1);
            } if(y) {
                this.ACCEL.setY(ACCEL.getY() *-1);
            }//rebota según lo indica
        }//cambia el vector de fuerza o aceleración  según sea el caso
        if(x) {
            this.SPEED.setX(SPEED.getX() *-1);
        } if(y) {
            this.SPEED.setY(SPEED.getY() *-1);
        }//rebota según lo indica
    }//recoill
    
    /**
     * Aplica fricci&oacute;n sobre el objeto y s&oacute;lo fricci&oacute;n.
     * @since Sprite 1.0, may 2015
     */
    public void frictionReduction() {
        double x = Math.abs(mass *ACCEL.getX() *FRICTION.getX());
        double y = Math.abs(mass *ACCEL.getY() *FRICTION.getY());
        if(SPEED.getX() != 0) {
            MOV_FORCE.setX(SPEED.getX() > 0 ?
                    MOV_FORCE.getX() -x : MOV_FORCE.getX() +x);
        } if(SPEED.getY() != 0) {
            MOV_FORCE.setY(SPEED.getY() > 0 ?
                    MOV_FORCE.getY() -y : MOV_FORCE.getY() +y);
        }//asigna la nueva fuerza
    }//fricionReduction
    
    /**
     * Usa las magnitudes f&iacute;sicas del sprite para calcular su movimiento.
     * @param updateDelay - La duraci&oacute;n de los intervalos de sue&ntilde;o
     * que use el hilo que anime este esprite.
     * @return Point - Devuelve a POSITION; sobre quien por supuesto se habrán
     * actualizado sus coordenadas X y Y, resultantes de calcular el
     * desplazamiento del objeto.
     */
    public Point moveObject(long updateDelay) {
        if(!this.isAccelConstant) {
            frictionReduction();
            ACCEL.setMagnitudes(MOV_FORCE.getX() /mass, MOV_FORCE.getY() /mass);
        }//si es necesario calcular la aceleración
        if(!this.isSpeedConstant) {
            SPEED.setMagnitudes(SPEED.getX() +ACCEL.getX() *updateDelay, 
                    SPEED.getY() +ACCEL.getY() *updateDelay);
            double norm = SPEED.getNorm();
            if(norm > this.terminalVelocity) {
                SPEED.scalarProd(terminalVelocity /norm);
            }//limita la velocidad; no queremos infracciones
        }//si es necesario calcular la velocidad
        this.POSITION.x += SPEED.getX();
        this.POSITION.y += SPEED.getY();
        return this.POSITION;
    }//moveObject
    
    /**
     * Rota el sprite.
     * @param angle - El &aacute;ngulo con el que se quiere rotar el sprite.
     * @return double - El valor del &aacute;ngulo de rotaci&oacute;n del vector
     * de fuerza.
     * @since Sprite 1.0, mayo 2015
     */
    public double rotateObject(double angle) {
        this.rotationAngle += angle;
        if(!this.isAccelConstant) {
            MOV_FORCE.setAngle(rotationAngle);
        } if(!this.isSpeedConstant) {
            ACCEL.setAngle(rotationAngle);
        }//asigna el vector de fuerza, aceleración dependiendo el caso
        SPEED.setAngle(rotationAngle);
        return this.rotationAngle;
    }//rotate object
    
    /**
     * Dado otro sprite, indica si este colisiona con el otro dado.
     * @param other - El otro sprite con el que se va a detectar colisi&oacute;n
     * con este.
     * @return boolean - <tt>true</tt> si hay colosi&oacute;n entre los dos
     * sprites dados, <tt>false</tt> en otro caso.
     * @since Sprite 1.0, may 2015
     */
    public boolean detectCollision(Sprite other) {
        if(!isVisible || other == null || !other.isVisible) {
                return false;
        }//si el sprite  está fuera de servicio
        return (other.POSITION.x <= POSITION.x +WIDTH &&
                other.POSITION.x >= POSITION.x &&
                other.POSITION.y <= POSITION.y +HEIGHT && 
                other.POSITION.y >= POSITION.y) ||
                (other.POSITION.y <= POSITION.y +HEIGHT &&
                other.POSITION.y >= POSITION.y &&
                other.POSITION.x <= POSITION.x +WIDTH &&
                other.POSITION.x >= POSITION.x) ||
                (POSITION.x <= other.POSITION.x +other.WIDTH &&
                POSITION.x >= other.POSITION.x &&
                POSITION.y <= other.POSITION.y +other.HEIGHT && 
                POSITION.y >= other.POSITION.y) ||
                (POSITION.y <= other.POSITION.y +other.HEIGHT &&
                POSITION.y >= other.POSITION.y &&
                POSITION.x <= other.POSITION.x +other.WIDTH &&
                POSITION.x >= other.POSITION.x);
    }//detectCollision
    
    // métodos estáticos
    
    /**
     * Carga una imagen de dentro los recursos de la aplicaci&oacute;n.
     * @param resName - El nombre de la imagen con extensi&oacute;n que
     * desea cargarse.
     * @return BufferedImage - La imagen cargada.
     * @since Sprite 1.0, may 2015
     */
    public static BufferedImage loadImage(String resName) {
        try {
            return ImageIO.read(Sprite.class.getResourceAsStream(
                    "/res/drawable/" + resName));
        } catch(Exception e) {
            return null;
        }//trata de recuperar la imagen
    }//loadImage
    
    /**
     * Carga una serie de im&aacute;genes como hoja de animaciones.
     * @param resNames - Los nombres de las im&aacute;genes a cargar.
     * @return BufferedImage[] - La hoja de animaciones resulante.
     * @since Sprite 1.0, amy 2015
     */
    public static BufferedImage[] loadSpriteSheet(String[] resNames) {
        BufferedImage[] spriteSheet = new BufferedImage[resNames.length];
        for(int i = 0; i < resNames.length; i++) {
            spriteSheet[i] = loadImage(resNames[i]);
        }//recupera todos los recursos
        return spriteSheet;
    }//loadspriteSheet
    
}//Sprite class
