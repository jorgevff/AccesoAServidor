import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;

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
        accesos.clear();

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
                //se añaden los objetos a nuestro ArrayList        
                accesos.add(accesoActual);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo que devuelve la hora con mas accesos al servidor, y que devuelve -1 si no hay ningun acceso. 
     */
    public int obtenerHoraMasAccesos()
    {
        int horaConMasAccesos = -1;

        HashSet<Integer> horas = new HashSet<>();

        int vecesMasAltaRepetida = 0;
        if(accesos.size() > 0){
            for(Acceso accesoActual : accesos){

                int nuevaHoraAcceso = accesoActual.obtenerHora();
                horas.add(nuevaHoraAcceso);

            }
            for(Integer horaActual: horas){
                int numeroHorasRepetidas = 0;
                for(Acceso nuevoAcceso : accesos){
                    if(nuevoAcceso.obtenerHora() == horaActual){
                        numeroHorasRepetidas++;                 
                    }

                }
                if(numeroHorasRepetidas > vecesMasAltaRepetida){
                    vecesMasAltaRepetida = numeroHorasRepetidas;
                    horaConMasAccesos = horaActual;

                }
                if(numeroHorasRepetidas == vecesMasAltaRepetida && horaConMasAccesos < horaActual){
                    horaConMasAccesos = horaActual;

                }
            }

        }
        System.out.println("La hora con mas accesos al servidor son las: " + horaConMasAccesos);
        return horaConMasAccesos; 
    }

}
