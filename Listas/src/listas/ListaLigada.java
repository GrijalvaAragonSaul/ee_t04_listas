/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author Saul Grijalva Aragon
 */
public class ListaLigada<T extends Comparable<T>>{
	
    private Nodo<T> inicio;
       
    public ListaLigada(){
    	inicio = null;
    }
    public Nodo<T> getInicio(){
        return inicio;
    }
    
 
    public void insertarInicio(T dato){
             Nodo<T> nuevo = new Nodo<T>(dato);
  nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }
    
    public void insertarFinal(T dato){
                  Nodo<T> temporal = inicio;
        if(inicio == null)
           insertarInicio(dato);
        else
        {
      while(temporal.getSiguiente() != null)
                   temporal = temporal.getSiguiente();
             temporal.setSiguiente(new Nodo<T>(dato));
        }        
    }
   public void insertarAntesDe(T dato, T referencia) {
        boolean band=true;
        Nodo<T> temporal, buscado;
        temporal=inicio;
        buscado=temporal;
                     
           while( (temporal.getDato()!= referencia)&&band) {
               if(temporal.getSiguiente()!=null){
                   buscado=temporal;
                   temporal=temporal.getSiguiente();
                }else{
                    band=false;
                }
              
           }
           
          
           if(band){
               if(temporal==inicio){
                   insertarInicio(dato);
                }else{
                    Nodo<T> nuevo=new Nodo (dato);
                    nuevo.setSiguiente(temporal);
                    buscado.setSiguiente(nuevo);
                    System.out.println ("se agrego antes de : "+referencia);
                }
            }
          
    }
   
   public void insertarDespuesDe(T dato, T referencia){
    Nodo<T> temporal, nuevo;
    boolean band=true;
    temporal=inicio;
    while( temporal.getDato()!=referencia && band){
    if(temporal.getSiguiente()!=null){
    temporal=temporal.getSiguiente();
    }
    
    else{
    band=false;    
    }
    }
    if(band){
    if(temporal==inicio){
    
    }
    
    else{
        
     nuevo= new Nodo(dato);
     nuevo.setSiguiente(temporal.getSiguiente());
     temporal.setSiguiente(nuevo);
    }
    }
    } 
    
    public void eliminaElemento(T dato){
   Nodo temporal, ini, nuevo=null;
   boolean band;
   ini=inicio;
   temporal=inicio;
   band=true;
   while(temporal.getDato()!=dato && band==true){
    if(temporal.getSiguiente()!=null){
    nuevo=temporal;
    temporal=temporal.getSiguiente();
    }
    else{
    band=false;
    }
    }
    if(band==false){
    System.out.println("El elemento no se encuentra en tu lista");
    }
   else{
    if(ini==temporal){
    inicio=temporal.getSiguiente();
    }
    else{
    nuevo.setSiguiente(temporal.getSiguiente());
    }
    nuevo.setSiguiente(temporal.getSiguiente());
    }
    
    } 
    public void eliminarAntesDe(T referencia){
    Nodo temporal, anterior, nuevo;
    boolean band=true;
    temporal=inicio;
    nuevo=temporal;
    anterior=null;
    while(temporal.getDato()!=referencia && band){
    if(temporal.getSiguiente()!=null){
    anterior=temporal;
    temporal=temporal.getSiguiente();
    }
    else{
    band=false;
    }
    
    }
    if(band){
    if(temporal==inicio){
    
    }
    else{
    nuevo.setSiguiente(temporal);
    temporal=null;
    anterior.setSiguiente(nuevo);
    
       }
    }
   }
    
    
     public void eliminaPrimero(){
    Nodo temporal=inicio;
    if(temporal.getSiguiente()!=null){
    inicio=temporal.getSiguiente();
    }
    else{
    inicio=null;
    }
   } 
     
     public void eliminaUltimo(){
    Nodo temporal, ante=null ;
    temporal=inicio;
    
    if(inicio.getSiguiente()==null){
    inicio=null;
    }
    else{
    while(temporal.getSiguiente()!=null){
    ante=temporal;
    temporal=temporal.getSiguiente();
    }
    ante.setSiguiente(null);    
    }
    } 
  public void busquedaDesordenada (T dato){
    Nodo temporal;
    temporal=inicio;
    while(temporal!=null && temporal.getDato()!=dato){
    temporal=temporal.getSiguiente();
    }
    if(temporal==null){
    System.out.println("El elemento no se encuentra en la lista");;
    
    }
    else{
    System.out.println("El elemento ha sido encontrado");
    }
    }
  
  public void busquedaRecursiva(T dato){
    Nodo temporal;
    temporal=inicio;
    if(temporal!=null){
   if(temporal.getDato()==dato){ 
    System.out.println("El elemento si se encuentra en la lista");
    }
   else{
    busquedaRecursiva(dato);
    temporal=temporal.getSiguiente();
    } 
   }
   else{
    System.out.println("El elemento no se encuentra en la lista");
    }
   }
  
  public void recorreRecursivo(Nodo<T> aux){
		
if (aux != null){
		 
 System.out.println(aux.getDato());
		
  recorreRecursivo(aux.getSiguiente());
		
}
}
  
  public void recorreIterativo(){
        Nodo<T> temporal=inicio;
        if(inicio==null)
           System.out.println ("No esta vacio");
           else {
               System.out.println ("Los elementos de la lista son:");
               while (temporal!=null){
                   System.out.print("["+temporal.getDato ()+"]-> ");
                   temporal=temporal.getSiguiente();
                }
                System.out.println ("\n");
            }
           
    }

  public void insertaOrdenado(T d){
        Nodo<T>temporal,nodoencontrado=null,nuevo; 
        boolean band=true;
        temporal=inicio;

        if(inicio==null){
            insertarInicio(d);
        }
        
        else
        {
            while(d.compareTo(temporal.getDato())==1&& band){
                if(temporal.getSiguiente()!=null){
                    nodoencontrado=temporal;
                    temporal=temporal.getSiguiente();
                }
                else
                {
                    band=false;
                }
            }
            if(band){
                if(temporal==inicio){
                    insertarInicio(d);
                }else{
                    nuevo=new Nodo(d);
                    nuevo.setSiguiente(temporal);
                    nodoencontrado.setSiguiente(nuevo);
                }

            }else{
                insertarFinal(d);
            }
        }
    }	
    
}


    
  
    




