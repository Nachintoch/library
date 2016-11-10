package mx.nachintoch.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

/*
 * Nachintoch utils library for Java and Android.
 * Copyright 2012, 2015, Manuel Castillo.
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
 * <p>Pre-implementaci&oacute;n de un monitor en Java.</p>
 * <p>El monitor propuesto cuenta con un par de colas:<ul>
 * <li>RUNNING_QUEUE - Que deber&aacute; contener a los hilos que est&aacute;
 * siendo etendidos por el monitor.</li>
 * <li>WAITING_QUEUE - Que deber&iacute; contener a los hilos que han solicitado
 * ejecutar alg&uacute;n m&eeacute;todo del monitor (ser atendidos)</li></ul></p>
 * <p>Adem&aacute;s cuenta con un candado LOCK, el cual permite que un hilo
 * se apropie del monitor. Cuando un hilo se ha apropiado del monitor,
 * ning&uacute;n otro deber&iacute;a poder usarlo.</p>
 * <p>Puede definirse un monitor <b>apropiativo</b> si no hay forma en la que
 * una vez que un proceso est&aacute; siendo atendido por el monitor,
 * <b>pueda</b> ser interrumpido por otro. Si <b>no permitimos que el proceso
 * ganador sea interrumpido</b>, entonces hablamos de un monitor <b>no
 * apropiativo</b>.</p>
 * @author <a href="mailto:contact@nachintoch.mx" >Manuel "Nachintoch" Castillo</a>
 * @version 2.0, november 2016
 * @since Nachintoch utils 1.0, october 2015
 */
public abstract class Monitor<E extends Runnable> implements Condition {
	
	// atributos de clase
	
	/**
	 * Cola de ejecuci&oacute;n del monitor. Esta contiene procesos que han
	 * salido de la cola de espera y simplemente esperan por tiempo de
	 * procesador. Alg&uacute;n proceso maestro se deber&aacute; encargar de
	 * ir vaciando esta cola y pasar los procesos a ejecuci&oacute;n.
	 * @since Monitor 1.0, october 2015
	 */
	protected final ConcurrentLinkedQueue<E> RUNNING_QUEUE;
	
	/**
	 * Cola de prioridades que contiene en el orden deseado a los procesos que
	 * han llamado a la funci&oacute;n wait.
	 * @since Monitor 1.0, october 2015
	 */
	protected final PriorityBlockingQueue<E> WAITING_QUEUE;
	
	/**
	 * Candado que podemos usar para "asignar" el monitor al proceso que lo
	 * solicite primero (incluyendo situaciones implicadas por una
	 * condici&oacute;n de carrera/competencia).
	 * @since Monitor 2.0, novembber 2016
	 */
	protected final ReentrantLock LOCK;
	
	// métodos constructores
	
	/**
	 * Inicializa las colas del monitor.
	 * @param runing - La cola de "procesos" en ejecuci&oacute;n.
	 * @param waiting - La cola de "procesos" en estado de espera.
	 * @param fair - <tt>true</tt> indica que el candado del monitor debe
	 * implementar un encolamiento justo.
	 * @since Monitor 1.0, october 2015
	 */
	public Monitor(ConcurrentLinkedQueue<E> runing,
			PriorityBlockingQueue<E> waiting, boolean fair) {
		RUNNING_QUEUE = runing;
		WAITING_QUEUE = waiting;
		LOCK = new ReentrantLock(true);
	}//constructor con todo
	
}//Monitor abstract class

