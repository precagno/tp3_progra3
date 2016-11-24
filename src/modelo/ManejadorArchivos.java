package modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ManejadorArchivos{
	//clase sin constructor
	
	
	//borra el archivo creado (pone en blanco) 
	public static void borrarContenido(String nombreArchivo) throws IOException{
		BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
		escritor.write("");
		escritor.close();
	}
}