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
import Utilidades.*;

public class Hilo {
	static int counter=0;
	static Map<String,Integer> codeMoney = MetodosUsuario_sql.returnMapPedidos();// codigo y dinero
	
	
	static class facturacion implements Callable<Integer> {
	    Deque<String> pilaCola = new ConcurrentLinkedDeque<>();
        private int contador=0;
        public  facturacion( ) {
            
        }
		@Override
		public Integer call() throws Exception {
			for (Map.Entry<String,Integer>entry : codeMoney.entrySet()) {
                contador = contador + entry.getValue();
                Thread.sleep(2000);
		}return contador;}
    }
	
	static class numeroClientes implements Callable<Integer> {
	    Deque<String> pilaCola = new ConcurrentLinkedDeque<>();
        private int trabajadores;
        private int end = codeMoney.size();
        public numeroClientes( ) {
           

        } 
		@Override
		public Integer call() throws Exception {
			for (int i = 0; i <= end; i++) {
                trabajadores+=1;
                Thread.sleep(2000);
		}
			return trabajadores;
    }
	}
	
	
 public static Map<String,Integer> threadA( )throws UtilExceptions {
    Deque<String> pilaCola = new ConcurrentLinkedDeque<>();
    Deque<String> pilaCol = new ConcurrentLinkedDeque<>();

    Callable call1 = new facturacion();
	Callable call2 = new numeroClientes();
	
	
    
    Thread hilo1 = new Thread((Runnable)call1);//hilo uno cuenta facturacion   
    Thread hilo2 = new Thread((Runnable)call2);//hilo dos cuenta codigos distintos(Nº clientes)
    hilo1.start();
    hilo2.start();

    
	Map<String,Integer> clientesFact = new HashMap<>();
    clientesFact.put(null, 0);
    
    if (!pilaCola.isEmpty()) {
        String i = pilaCola.poll();
        counter += 1;
        
    }int numeroClientes = counter;
    if(numeroClientes==0) {throw new UtilExceptions("Parece que no has vendido nada",null,true ,true );}
	return clientesFact;
    
    
    
 }
}
