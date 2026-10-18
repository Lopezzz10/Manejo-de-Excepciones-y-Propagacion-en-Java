package com.krakeDev.Taller.Exepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeerContacto {

	private static final Logger log = LoggerFactory.getLogger(LeerContacto.class);

	private static final String ARCHIVO = "contactos.txt";

	public static List<String> leerContacto() {
		return leerContacto(ARCHIVO);
	}

	public static List<String> leerContacto(String ruta) {

		List<String> lineas = new ArrayList<>();
		BufferedReader lector = null;

		try {
			FileReader lectorDeArchivo = new FileReader(ruta);
			lector = new BufferedReader(lectorDeArchivo);

			String linea;
			while ((linea = lector.readLine()) != null) { // MODIFICADO: lee hasta el final del archivo
				log.info(linea);
				lineas.add(linea);
			}

			log.info("Archivo leido correctamente");

		} catch (FileNotFoundException e) {
			log.error("No se encontro el archivo: {}", e.getMessage());

		} catch (IOException e) {
			log.error("Error al leer el archivo: {}", e.getMessage());

		} finally {
			try {
				if (lector != null) {
					lector.close();
				}
			} catch (IOException e) {
				log.error("Error al cerrar el archivo: {}", e.getMessage());
			}
		}

		return lineas;
	}

}