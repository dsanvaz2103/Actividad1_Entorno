/*
 * Para cambiar este encabezado de licencia, elija Encabezados de licencia en Propiedades del proyecto.
 * Para cambiar este archivo de plantilla, elija Herramientas | Plantillas
 * y abre la plantilla en el editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author ana
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] amortiguar = new byte[1000];
    private static final String NombreArchivo = "fichero.dat";
    private static FileInputStream FlujodeEntrada = null;
    private static BufferedInputStream BúferdeEntrada = null;

    public static void inicializateFiles() throws FileNotFoundException
    {
        FlujodeEntrada = new FileInputStream(NombreArchivo);
        BúferdeEntrada = new BufferedInputStream(FlujodeEntrada);
    }
    
    public static int showFileText() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = FlujodeEntrada.read(amortiguar)) != -1) 
        {
            System.out.println(new String(amortiguar));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializateFiles();
            
            int total = showFileText();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( BúferdeEntrada != null && FlujodeEntrada != null )
                {
                    FlujodeEntrada.close();
                    BúferdeEntrada.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
