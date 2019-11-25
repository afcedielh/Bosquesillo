
package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author acediel
 */
public class Monstruos {
    
    //atributos
    int letx;
    int lety;
    Timer timer;
    Random aleatorio;
    int direccion;
    int mx;
    int my;
    
    /**
     *
     * @param x
     * @param y
     */
    public Monstruos( int x, int y ){
        aleatorio = new Random();
        letx = x;
        lety = y;
        Registro.mat[letx][lety] = 7;
        direccion = aleatorio.nextInt(4);
        this.movimiento();
    }//contrutor
    
    /**
     *
     */
    public void movimiento(){
    
        timer = new Timer (200, new ActionListener () 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                System.out.println("esta funcionando el timer");
                //izquierda
                if( letx > 0 && direccion == 0 ){
                    System.out.println("aqui" + direccion);
                    //camina
                    if(Registro.mat[letx-1][lety] != 2 && (Registro.mat[letx-1][lety] == 0 || Registro.mat[letx-1][lety] == 1)){
                        Registro.mat[letx][lety] = Registro.matAux[letx][lety];
                        letx -=1;
                        Registro.mat[letx][lety]=7;
                        //Registro.pintarMatriz();
                    }else
                    //choca con la pared
                    if(letx > 0 && Registro.mat[letx-1][lety] == 2 ){
                        direccion = aleatorio.nextInt(4); 
                    }else
                    //choca con otro letal
                    if(Registro.mat[letx-1][lety] == 7 ){
                        direccion = aleatorio.nextInt(4); 
                    }
                }
                //derecha
                if( direccion == 1 ){
                    System.out.println("aqui" + direccion);
                    if(Registro.mat[letx+1][lety] != 2 && (Registro.mat[letx+1][lety] == 0 || Registro.mat[letx+1][lety] == 1)){
                        Registro.mat[letx][lety] = Registro.matAux[letx][lety];
                        letx +=1;
                        Registro.mat[letx][lety]=7;
                        //Registro.pintarMatriz();
                    }else
                    
                    if(letx < 14 && Registro.mat[letx+1][lety] == 2 ){
                        direccion = aleatorio.nextInt(4); 
                    }else
                    if(Registro.mat[letx+1][lety] == 7 ){
                        direccion = aleatorio.nextInt(4); 
                    }
 
                }
                //arriba
                if( lety > 0 && direccion == 2 ){
                    System.out.println("aqui" + direccion);
                    if(Registro.mat[letx][lety-1] != 2 && (Registro.mat[letx][lety-1] == 0 || Registro.mat[letx][lety-1] == 1)){
                        Registro.mat[letx][lety] = Registro.matAux[letx][lety];
                        lety -=1;
                        Registro.mat[letx][lety]=7;
                        //Registro.pintarMatriz();
                    }else
                    if(letx > 0 && Registro.mat[letx][lety-1] == 2 ){
                        direccion = aleatorio.nextInt(4); 
                    }else
                    if(Registro.mat[letx][lety-1] == 7 ){
                        direccion = aleatorio.nextInt(4); 
                    }
                }
                //abajo
                if(  direccion == 3 ){
                    System.out.println("aqui" + direccion);
                    if(Registro.mat[letx][lety+1] != 2 &&(Registro.mat[letx][lety+1] == 0 || Registro.mat[letx][lety+1] == 1)){
                        Registro.mat[letx][lety] = Registro.matAux[letx][lety];
                        lety +=1;
                        Registro.mat[letx][lety]=7;
                        //Registro.pintarMatriz();
                    }else
                    if(lety < 14 && Registro.mat[letx][lety+1] == 2 ){
                        direccion = aleatorio.nextInt(4); 
                    }else
                    if(Registro.mat[letx][lety+1] == 7 ){
                        direccion = aleatorio.nextInt(4); 
                    }
                }
                
                
                
               
        }});
      //  timer.start();
    
    }//fin metodo;
    
    
    
    
    
}
