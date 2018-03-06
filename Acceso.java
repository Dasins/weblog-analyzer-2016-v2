public class Acceso
{
    private int ano;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    
    public Acceso(String entrada)
    {
      int[] fecha = toInt(entrada.split(" "));
      ano = fecha[0];
      mes = fecha[1];
      dia = fecha[2];
      hora = fecha[3];
      minutos = fecha[4];
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
    
    public int getAno() 
    {
        return ano;
    }
    
    public int getMes()
    {
        return mes;
    }
    
    public int getDia()
    {
        return dia;
    }
    
    public int getHora()
    {
        return hora;
    }
    
    public int getMinutos()
    {
        return minutos;
    }
}