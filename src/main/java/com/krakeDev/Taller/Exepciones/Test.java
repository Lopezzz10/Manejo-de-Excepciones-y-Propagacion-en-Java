package com.krakeDev.Taller.Exepciones;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {

	private static final Logger log = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {

		// Escenario 1: telefono valido -> guarda y lee todos los contactos
		procesar("Maria", "Gomez", "0981234567");

		// Escenario 2: telefono invalido -> IllegalArgumentException controlada
		procesar("Juan", "Perez", "123");

		// Escenario 3: archivo inexistente -> FileNotFoundException controlada
		log.info("Leyendo un archivo que no existe");
		LeerContacto.leerContacto("no_existe.txt");
	}

	private static void procesar(String nombre, String apellido, String telefono) {
		try {
			ValidarContacto.validarTelefono(telefono);

			GuardarContacto.guardarContacto(nombre, apellido, telefono);
			LeerContacto.leerContacto();

			log.info("Proceso completado correctamente");

		} catch (IllegalArgumentException e) {
			log.error("Telefono invalido: {}", e.getMessage());
		}
	}

}