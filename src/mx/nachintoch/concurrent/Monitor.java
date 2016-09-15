package mx.nachintoch.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

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
 * Pre-implementaci&oacute;n de un monitor en Java.
 * @author <a href="mailto:contact@nachintoch.mx" >Manuel "Nachintoch" Castillo</a>
 * @version 1.0, october 2015
 * @since Nachintoch utils 1.0, october 2015
 */
public abstract class Monitor {
	
	// atributos de clase
	
	/**
	 * Cola de ejecuci&oacute;n del monitor. Esta contiene procesos que han
	 * salido de la cola de espera y simplemente esperan por tiempo de
	 * procesador. Alg&uacute;n proceso maestro se deber&aacute; encargar de
	 * ir vaciando esta cola y pasar los procesos a ejecuci&oacute;n.
	 * @since Monitor 1.0, october 2015
	 */
	protected final ConcurrentLinkedQueue<Runnable> RUNNING_QUEUE;
	
	/**
	 * Cola de prioridades que contiene en el orden deseado a los procesos que
	 * han llamado a la funci&oacute;n wait.
	 * @since Monitor 1.0, october 2015
	 */
	protected final PriorityBlockingQueue<Runnable> WAITING_QUEUE;
	
	// métodos constructores
	
	/**
	 * Inicializa las colas del monitor.
	 * @param runing - La cola de "procesos" en ejecuci&oacute;n.
	 * @param waiting - La cola de "procesos" en estado de espera.
	 * @since Monitor 1.0, october 2015
	 */
	public Monitor(ConcurrentLinkedQueue<Runnable> runing,
			PriorityBlockingQueue<Runnable> waiting) {
		RUNNING_QUEUE = runing;
		WAITING_QUEUE = waiting;
	}//constructor con todo
	
}//Monitor abstract class

