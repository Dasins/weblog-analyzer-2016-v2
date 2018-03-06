import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * La clase AnalizadorAccesosAServidor modela objetos que represetan un analizador de conexiones a un servidor.                     <p>
 * 
 * El analizador es capaz de leer ficheros de log y obtener distintas informaciones a partir de ellos.
 * 
 * @author d4s1ns
 * @version 2018/03/06
 */
public class AnalizadorAccesosAServidor {
    private ArrayList<Acceso> accesos;
    
    /**
     * Construye objetos AnalizadorAccesosAServidor.
     */
    public AnalizadorAccesosAServidor() {
        accesos = new ArrayList<>();
    }
    
    /**
     * Trata de leer un archivo de log y convierte cada entrada en un objeto Acceso. 
     * @param archivo La ruta, absoluta o relativa, del archivo a leer incluyendo su extension.
     */
    public void analizarArchivoDeLog(String archivo) {
        accesos.clear();
        File archivoALeer = new File(archivo);
        try {
            Scanner sc = new Scanner(archivoALeer);
            while (sc.hasNextLine()) {
                accesos.add(new Acceso(sc.nextLine()));
            }
            sc.close();
        }
        catch (Exception e) {
            System.out.println("Ocurrio algun error al leer el archivo.");
        }
    }
    
    /**
     * Devuelve la hora con mayor numero de accesos del ultimo fichero de log analizado o -1 si el log esta vacio.                  <p>
     * Si existe empate en el numero de accesos se devuelve la hora de mayor valor.
     * 
     * @return Devuelve la hora con mayor numero de accesos del ultimo fichero de log analizado o -1 si el log esta vacio.
     */
    public int obtenerHoraMasAccesos() {
        int valorADevolver = -1;
        
        if (!accesos.isEmpty()) {
            int[] accesosPorHora = new int[24];
    
            for (Acceso accesoActual : accesos) {
                int horaAccesoActual = accesoActual.fecha().hora();
                accesosPorHora[horaAccesoActual] = accesosPorHora[horaAccesoActual] + 1;
            }
            
            int numeroDeAccesosMasAlto = accesosPorHora[0];
            int horaDeAccesosMasAlto = 0;
            for (int i = 0; i < accesosPorHora.length; i++) {
                if (accesosPorHora[i] >= numeroDeAccesosMasAlto) {
                    numeroDeAccesosMasAlto = accesosPorHora[i];
                    horaDeAccesosMasAlto = i;
                }
            }
            
            valorADevolver = horaDeAccesosMasAlto;                      
        }
        
        return valorADevolver;
    }   
    
    /**
     * Devuelve la pagina web mas visita del ultimo archivo de log analizado o null si el log esta vacio.
     * @return Devuelve la pagina web mas visita del ultimo archivo de log analizado o null si el log esta vacio.
     */
    public String paginaWebMasSolicitada() {
        String retorno = null;
        if (!accesos.isEmpty()) {
            HashMap<String, Integer> topWebs = new HashMap<>();
            for (Acceso acceso : accesos) {       
                String webActual = acceso.web();
                Integer numAccesos = topWebs.get(webActual);
                if (numAccesos == null) {
                    topWebs.put(webActual, 1);
                }
                else {
                    topWebs.put(webActual, numAccesos + 1);
                }
            }
            int maxVisitas = 0;
            for (Map.Entry<String, Integer> entrada : topWebs.entrySet()) {
                if(entrada.getValue() > maxVisitas) {
                    maxVisitas = entrada.getValue();
                    retorno = entrada.getKey();
                }
            }
        }
        return retorno;
    }
    
    public String clienteConMasAccesosExitosos()
    {
        return "";
    }


}
