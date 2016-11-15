package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorArchivos
{
	public static void borrarContenido(String nombreArchivo) throws IOException
	{
		BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
		escritor.write("");
		escritor.close();
	}
}