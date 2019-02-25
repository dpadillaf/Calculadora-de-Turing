/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author davi1
 */
public class Cinta {
    private Nodo primero;
    
    public Cinta (){
        this.primero = null;
    }
    
    public Cinta (Nodo n){
        this.primero = n;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }
    
    public boolean estaVacia (){
        if (primero == null)
            return true;
        else
            return false;
    }
    
     public void insertarPrincipio (char d){
        if (estaVacia ()){
            primero = new Nodo (null, d, null);
        }else{
            Nodo nuevo = new Nodo (null, d, primero);
            primero.setAnt(nuevo);
            primero = nuevo;
        }
    }
     
     public void insertarFinal (char d){
         if (estaVacia ()){
            primero = new Nodo (null, d, null);
        }else{
             Nodo aux = primero;
             while (aux.getSig() != null){
                 aux = aux.getSig();
             }
             Nodo nuevo = new Nodo (aux, d, null);
             aux.setSig(nuevo);
         }
     }
     
     public int buscar (int dt){
         Nodo aux = primero;
         int contador = 0;
         while (aux != null){
             if (aux.getDato() == dt){
                 return contador;
             }
         }
         return -1;
     }
     
     public void eliminaCualquiera (int d){
       Nodo aux = primero;
       int contador=0;
       while (aux != null){
           aux = aux.getSig();
           contador++;
       }
       if (contador < 2){
           this.setPrimero(null);
       }else{
           if (contador == 2){
               if (buscar(d) == 1){
                   primero = primero.getSig();
                   primero.setAnt(null);
               }else{
                   primero.setSig(null);
               }
           }else{
               Nodo aux2 = primero;
               Nodo aux3 = new Nodo ();
               for (int i=0; i<buscar(d); i++){
                   aux3 = aux2;
                   aux2 = aux2.getSig();
                   
               }
               aux3.setSig(aux2.getSig());
               aux2 = aux3;
               aux3 = aux3.getSig();
               aux3.setAnt(aux2);
           }
       }
   }
     
     public Cinta llenarCinta (int var1, int var2, char op){
         Cinta c = new Cinta ();
         for (int i=0; i<var1; i++){ c.insertarFinal('1'); }
         c.insertarFinal(op);
         for (int i=0; i<var2; i++){ c.insertarFinal('1'); }
         return c;
     }
     
     public Nodo devolverUltimo (){
         Nodo aux = primero;
         while (aux.getSig() != null){
             aux = aux.getSig();
         }
         return aux;
     }
}
