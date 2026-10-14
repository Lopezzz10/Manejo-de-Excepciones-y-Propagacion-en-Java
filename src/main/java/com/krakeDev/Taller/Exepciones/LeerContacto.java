package com.krakeDev.Taller.Exepciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeerContacto {

	private static final Logger log = LoggerFactory.getLogger(LeerContacto.class);

	public static void leerContacto() {

		BufferedReader lector = null;

		try {
			FileReader lectorDeArchivo = new FileReader("contactos.txt");
			lector = new BufferedReader(lectorDeArchivo);

			for (int i = 0; i < 3; i++) {
				log.info(lector.readLine());
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
	}

}