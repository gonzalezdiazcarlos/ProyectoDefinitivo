package Utilidades;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedDeque;
import clases.*;
import basesdedatos.*;

public class Hilo {
	static int counter=0;
	static Map<String,Integer> codeMoney = MetodosUsuario_sql.returnMapPedidos();// codigo y dinero
	
	
	static class facturacion implements Callable<Integer> {
	    Deque<String> pilaCola = new ConcurrentLinkedDeque<>();
        private int contador=0;
        public  facturacion( Deque<String> pilaCola) {
            this.pilaCola = pilaCola;
        }
		@Override
		public Integer call() throws Exception {
			for (Map.Entry<String,Integer>entry : codeMoney.entrySet()) {
                contador = contador + entry.getValue();
		}return contador;}
    }
	
	static class numeroClientes implements Callable<Integer> {
	    Deque<String> pilaCola = new ConcurrentLinkedDeque<>();
        private int trabajadores;
        private int end = codeMoney.size();
        public numeroClientes( Deque<String> pilaCola) {
            this.pilaCola = pilaCola;
            this.trabajadores=trabajadores;
        } 
		@Override
		public Integer call() throws Exception {
			for (int i = 0; i <= end; i++) {
                trabajadores+=1;
		}
			return trabajadores;
    }
	}
	
	
 public static Map<String,Integer> threadA(String A) {
	 
    Deque<String> pilaCola = new ConcurrentLinkedDeque<>();
    Deque<String> pilaCol = new ConcurrentLinkedDeque<>();

    
    Thread hilo1 = new Thread(new facturacion(pilaCola));//hilo uno cuenta facturacion
    
    
    Thread hilo2 = new Thread(new numeroClientes(pilaCol));//hilo dos cuenta codigos distintos(Nº clientes)


	Map<String,Integer> clientesFact = new HashMap<>();
    clientesFact.put(A, null);
    
    if (!pilaCola.isEmpty()) {
        String i = pilaCola.poll();
        counter += 1;
        
    }int numeroClientes = counter;
	return clientesFact;
    
    
    
 }
}
