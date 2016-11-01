package modelo;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import logica_negocio.Oferta;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DAOfertas 
{
	//variables de instancia
	private Gson _gson;
	private String nombreArchivo;
	private ArrayList<Oferta> listaCoordenadas;
	
	// cosntructor
	public DAOfertas(String nombreArchivo)throws IOException{
		this._gson=new Gson();
		this.nombreArchivo=nombreArchivo;
		this.listaCoordenadas=this.desserializaJson(this.nombreArchivo);
	}

	// Retorna lista de ofertas
	public ArrayList<Oferta> obtenerOfertas(){
		return listaCoordenadas;
	}
	
	//Agrega una oferta a la lista y persiste dicha lista
	public void agregarOferta(Oferta oferta) throws IOException{
		listaCoordenadas.add(oferta);
		persistirOfertas();
	}
	
	// Desserializa y retorna una lista de ofertas
	private ArrayList<Oferta> desserializaJson(String nombreArchivo)throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		Type collectionType=new TypeToken<ArrayList<Oferta>>(){}.getType();
		ArrayList<Oferta> listaCoordenadas=_gson.fromJson(br,collectionType);
		if(listaCoordenadas==null)//si el archivo esta vacio
		{
			listaCoordenadas=new ArrayList<Oferta>();//hace una lista vacia
		}
		
		return listaCoordenadas;
	}
	
	//Persiste la lista de ofertas en el archivo elegido
	private void persistirOfertas() throws IOException{
		BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
		escritor.write(_gson.toJson(listaCoordenadas));
		escritor.close();
	}
}