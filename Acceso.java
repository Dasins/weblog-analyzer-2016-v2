/**
 * Clase que modela objetos Acceso que representan una conexion a un servidor web.                                              <p>
 * 
 * @author d4s1ns
 * @version 2018/03/06
 */
public class Acceso
{
    // Fecha y hora en la que se produjo el acceso.
    private Fecha fecha;
    // IP desde la que se solicito acceso.
    private String ip;
    // Web a la que se solicito acceso.
    private String web;
    // Codigo de la respuesta HTTP.
    private int codRespuesta;
    /**
     * Construye objetos Acceso a partir de una cadena de texto.                                                                    <p>
     * El formato para las cadenas de texto empleadas para construir objetos Acceso es:                                             <br>
     * {@code DireccionIP [AAAA MM DD hh mm] Web CodigoRespuestaHTTP}                                                            <br>
     * {@code 192.168.1.15 [2016 01 01 20 31] estudios/bachillerato.html 403} 
     * 
     * @exception ArrayIndexOutOfBoundsException El numero de valores es inferior a los requeridos por el formato.
     * @exception NumberFormatException Una letra u otro caracter diferente a un numero se coloca en la posicion de un numero.
     * 
     * @param entrada Cadena de texto con el siguiente formato: {@code DireccionIP [AAAA MM DD hh mm] Web CodigoRespuestaHTTP}
     */
    public Acceso(String entrada)
    {
      String[] datos = entrada.split(" \\[|\\] ");
      ip = datos[0];
      
      int[] fecha = toInt(datos[1].split(" "));
      this.fecha = new Fecha(fecha[0], fecha[1], fecha[2], fecha[3], fecha[4]);
      
      datos = datos[2].split(" ");
      web = datos[0];
      codRespuesta = Integer.parseInt(datos[1]);
    }
    
    /**
     * Convierte colecciones de String en colecciones de enteros.   <p>
     * Si la coleccion contiene elementos que no sean numeros, se produce una excepcion.
     */
    private int[] toInt(String[] coleccion) {
        int[] retorno = new int[coleccion.length];
        for (int i = 0; i < coleccion.length; i++) {
            retorno[i] = Integer.parseInt(coleccion[i]);
        }
        return retorno;
    }
    
    /**
     * Devuelve la fecha en la que se produjo este acceso.
     * @return Devuelve la fecha en la que se produjo este acceso.
     */
    public Fecha fecha() {
        return fecha;
    }

}