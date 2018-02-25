
/**
 * Write a description of class Acceso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Acceso
{
    // instance variables - replace the example below with your own
    private int anio;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;

    /**
     * Constructor for objects of class Acceso
     */
    public Acceso(int anio, int mes, int dia, int hora, int minutos)
    {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minutos = minutos;
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int obtenerHora()
    {
        // put your code here
        return hora;
    }
}
