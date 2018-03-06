
/**
 * La clase Fecha modela objetos que representan la fecha y la hora de un evento indeterminado.                                     <p>
 * 
 * Los metodos y constructores de esta clase asumen que los valores que reciben son validos. 
 * Se considera que un valor es valido cuando cumple las siguientes condiciones                                                     <ul>
 *                                                                                                                                  <li>
 * Los valores introducidos por parametro son positivos.                                                                            <li>
 * El ano esta compuesto cuatro digitos.                                                                                            <li>
 * El mes esta compuesto por dos digitos (min: 01, max: 12).                                                                        <li>
 * El dia esta compuesto por dos digitos y, su valor se encuentre,
 * dentro del numero de dias que tiene el mes para una fecha en concreto.  (min: 01, max: 31)                                       <li>
 * La hora este compuesta por dos digitos. (min: 00, max: 23).                                                                      <li>
 * Los minutos esten compuestos por dos digitos. (min: 00, max: 59).
 * 
 * @author d4s1ns
 * @version 2018/03/06
 */
public class Fecha {
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minuto;

    /**
     * Construye objetos Fecha indicando todos sus atributos por parametro.
     * 
     * @param ano El ano de esta fecha.
     * @param mes El mes de esta fecha.
     * @param dia El dia de esta fecha.
     * @param hora La hora de esta fecha.
     * @param minuto El minuto de esta fecha.
     */
    public Fecha(int ano, int mes, int dia, int hora, int minuto) {
        this.ano = ano;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
    }
    
    /**
     * Devuelve el ano de esta fecha.
     * @return Devuelve el ano de la fecha.
     */
    public int ano() {
        return ano;
    }
        
    /**
     * Devuelve el mes de esta fecha.
     * @return Devuelve el mes de esta fecha.
     */
    public int mes() {
        return mes;
    }
    
    /**
     * Devuelve el dia de esta fecha.
     * @return Devuelve el dia de esta fecha.
     */
    public int dia() {
        return dia;
    }
    
    /**
     * Devuelve la hora de esta fecha.
     * @return Devuelve la hora de esta fecha.
     */
    public int hora() {
        return hora;
    }
    
    /**
     * Devuelve el minuto de esta fecha.
     * @return Devuelve el minuto de esta fecha.
     */
    public int minuto() {
        return minuto;
    }
    
    /**
     * Devuelve toda la informacion sobre esta fecha como una cadena de texto.
     * @return Devuelve toda la informacion sobre esta fecha como una cadena de texto.
     */
    public String toString() {
        return "[" + ano +" " + mes + " " + dia + " " + hora + " " + minuto + "]";
    }
}
