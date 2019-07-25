/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolog;
import org.jpl7.*;
/**
 *
 * @author xw_17
 */
public class Prolog {

    public Prolog(){
    
    }
    String altura1,peso1,imc,fimc;
    Double dimc;
    public void extraccion(){
        altura1 = ventana.altura.getText();
        peso1 = ventana.peso.getText();
        
        
        consultas();
        impresion();
    }
    public void impresion(){
        imc = String.valueOf(dimc);
        
        ventana.resultado.setText("Tu IMC es:   "+imc);
    }
    
    public void consultas(){
        try{
        String conexion = "consult('ia.pl')";
        Query con = new Query(conexion);
          System.out.println(conexion + "   " + (con.hasMoreSolutions() ? "ACEPTADO" : "FALLADO"));
            System.out.println("Iniciando calculo de IMC");
            String consul = "imc("+peso1+","+altura1+",C).";
            Query ejecutar = new Query(consul);
            if (ejecutar.hasSolution()) {
                dimc = Double.parseDouble(ejecutar.oneSolution().get("C").toString());
                //imc = String.valueOf(dimc);
                System.out.println(dimc);
                //System.out.println("El IMC es : "+ejecutar.oneSolution().get("C").toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ventana v = new ventana();
        v.setTitle("Proyecto Final");
        v.setVisible(true);
        
    }
    
}
