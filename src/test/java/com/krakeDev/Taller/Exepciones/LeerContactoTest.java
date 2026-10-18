package com.krakeDev.Taller.Exepciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class LeerContactoTest {

	@TempDir
	Path carpeta;

	@Test
	void leeTodasLasLineasDeVariosContactos() {
		String ruta = carpeta.resolve("contactos.txt").toString();
		for (int i = 1; i <= 4; i++) {
			GuardarContacto.guardarContacto(ruta, "Nombre" + i, "Apellido" + i, "098123456" + i);
		}

		List<String> lineas = LeerContacto.leerContacto(ruta);

		assertEquals(12, lineas.size());
		assertEquals("Nombre: Nombre1", lineas.get(0));
		assertEquals("Telefono: 0981234564", lineas.get(11));
	}

	@Test
	void leeArchivoConMasDeTresLineas() throws IOException {
		Path archivo = carpeta.resolve("largo.txt");
		Files.write(archivo, List.of("1", "2", "3", "4", "5", "6", "7"));

		assertEquals(7, LeerContacto.leerContacto(archivo.toString()).size());
	}

	@Test
	void archivoVacioDevuelveListaVacia() throws IOException {
		Path archivo = Files.createFile(carpeta.resolve("vacio.txt"));

		assertTrue(LeerContacto.leerContacto(archivo.toString()).isEmpty());
	}

	@Test
	void archivoInexistenteNoLanzaExcepcionYDevuelveListaVacia() {
		String ruta = carpeta.resolve("no_existe.txt").toString();

		List<String> lineas = LeerContacto.leerContacto(ruta);

		assertTrue(lineas.isEmpty());
	}

	@Test
	void guardarEnRutaInvalidaDevuelveFalse() {
		String ruta = carpeta.resolve("carpeta_que_no_existe").resolve("contactos.txt").toString();

		assertFalse(GuardarContacto.guardarContacto(ruta, "Maria", "Gomez", "0981234567"));
	}

}