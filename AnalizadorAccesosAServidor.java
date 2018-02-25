import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Write a description of class AnalizadorAccesoAServidor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnalizadorAccesosAServidor
{
    // instance variables - replace the example below with your own
    private ArrayList<Acceso> accesos;

    /**
     * Constructor for objects of class AnalizadorAccesoAServidor
     */
    public AnalizadorAccesosAServidor()
    {
        // initialise instance variables
        accesos = new ArrayList<>();
    }
    /**
     * Metodo que lee un archivo log pasado por parametro
     */

    public void analizarArchivoDeLog(String archivoLog)
    {

        try {
            File archivoALeer = new File(archivoLog);
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                String accesoLeido = sc.nextLine();               
                String[] accesosPorLinea = accesoLeido.split(" ");
                //Se crean objetos la clase Acceso para guardarlos en el ArrayList de objetos Acceso
                Acceso accesoActual = new Acceso(Integer.parseInt(accesosPorLinea[0]), 
                        Integer.parseInt(accesosPorLinea[1]), 
                        Integer.parseInt(accesosPorLinea[2]),
                        Integer.parseInt(accesosPorLinea[3]), 
                        Integer.parseInt(accesosPorLinea[4]));                                           
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
    

}
