package experimento;

import java.util.ArrayList;
import java.util.List;

public class MaquinaEstructura {

	// Interfaz de las operaciones
	public interface Operaciones{
		
		public Nodo buscar(int idNodo);
		
		public boolean agregar(Nodo nuevoNodo);
		
		public void imprimirRecorrido();
		
	}
	
	// Clase generica nodo
	public class Nodo{
		private int id;
		
		public Nodo(int id){
			this.id = id;
		}
		
		public int getId(){
			return id;
		}
	}
	
	
	
	// Clase que representa al nodo de un arbol binario
	public class NodoArbolBinario extends Nodo{

		private NodoArbolBinario derecha;
		
		private NodoArbolBinario izquierda;
		
		public NodoArbolBinario(int id) {
			super(id);
		}

		public NodoArbolBinario getDerecha() {
			return derecha;
		}

		public void setDerecha(NodoArbolBinario derecha) {
			this.derecha = derecha;
		}

		public NodoArbolBinario getIzquierda() {
			return izquierda;
		}

		public void setIzquierda(NodoArbolBinario izquierda) {
			this.izquierda = izquierda;
		}
		
	}
	
	// Clase que representa a un arbol binario
	public class ArbolBinario implements Operaciones{

		private NodoArbolBinario raiz;
		
		public ArbolBinario(NodoArbolBinario nodoRaiz) {
			raiz = nodoRaiz;
		}
		
		@Override
		public Nodo buscar(int idNodo) {
			Nodo este = null;
			if(raiz.getId()==idNodo){
				este = raiz;
			} else if(idNodo>raiz.getId()){
				este = raiz.getDerecha();
			} else {
				este = raiz.getIzquierda();
			}
			return este;
		}

		@Override
		public boolean agregar(Nodo nuevoNodo) {
			if(raiz.getId()>=nuevoNodo.getId()){
				if(raiz.getDerecha()==null){
					raiz.setDerecha((NodoArbolBinario)nuevoNodo);
				} else {
					raiz.getDerecha().agregar((NodoArbolBinario)nuevoNodo);
				}
			} else {
				if(raiz.getIzquierda()==null){
					raiz.setIzquierda((NodoArbolBinario)nuevoNodo);
				} else {
					raiz.getIzquierda().agregar();
				}
			}
			return false;
		}

		@Override
		public void imprimirRecorrido() {
			String msg = "";
			if(raiz !=null){
				msg += raiz.getId();
				raiz.getIzquierda().imprimirRecorrido();
				raiz.getDerecha().imprimirRecorrido();
			}
			System.out.println(msg);
			
		}
		
	}
	
	// Clase que representa a un nodo de un grafo
	public class NodoGrafo extends Nodo{
		
		private NodoGrafo fuente;
		private List<NodoGrafo> listaAdyacencia;
		
		public NodoGrafo(int id, NodoGrafo nodoFuente) {
			super(id);
			fuente = nodoFuente;
			listaAdyacencia = new ArrayList<>();
		}
		
		public List<NodoGrafo> getListaAdyacencia(){
			return listaAdyacencia;
		}
		
	}
	
	// Clase que representa a un grafo dirigido
	public class GrafoDirigido implements Operaciones{

		private NodoGrafo fuente;
		private boolean[] visitados = boolean[10];
		
		public GrafoDirigido(NodoGrafo nodoFuente) {
			fuente = nodoFuente;
		}
		
		@Override
		public Nodo buscar(int idNodo) {
			
			
			return null;
		}

		@Override
		public boolean agregar(Nodo nuevoNodo) {
			List<NodoGrafo> recorridos = new ArrayList<MaquinaEstructura.NodoGrafo>();
			visitados.get(fuente.getId());
			
			
			return false;
		}

		@Override
		public void imprimirRecorrido() {
			ArrayList<Integer> recorridos = new ArrayList<Integer>();
			visitados.get(fuente.getId())
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class NodoLista extends Nodo{
		
		private NodoLista siguiente;

		public NodoLista(int id) {
			super(id);
		}
		
		public NodoLista getDerecha(){
			return siguiente;
		}
		
	}
	
	public class ListaEnlazada implements Operaciones{
		
		
		private NodoLista primero;
		
		@Override
		public Nodo buscar(int idNodo) {
		
			boolean encontrado = false;
			Nodo resultado = primero;
			while(resultado!=null&&!encontrado){
				if(resultado.getId()==idNodo){
					encontrado = true;
				}
			}
			return resultado;
		}

		@Override
		public boolean agregar(Nodo nuevoNodo) {
			if(primero==null){
				primero = (NodoLista)nuevoNodo;
			}
			return false;
		}

		@Override
		public void imprimirRecorrido() {
			String msg = "";
			if(primero!=null){
				msg += primero.getId();
				while(primero.getDerecha()!=null){
					primero = primero.getDerecha();
					msg+= primero.getId();
				}
			}
			System.out.println(msg);
			// TODO Auto-generated method stub
			
		}
	}
	
	// Puede probar el funcionamiento de las operaciones en el main
	public static void main(String args[]){
		
	}
	
}
