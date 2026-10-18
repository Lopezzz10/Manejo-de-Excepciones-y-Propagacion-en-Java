package com.krakeDev.Taller.Exepciones;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ValidarContactoTest {

	@Test
	void telefonoValidoNoLanzaExcepcion() {
		assertDoesNotThrow(() -> ValidarContacto.validarTelefono("0981234567"));
	}

	@Test
	void telefono123LanzaExcepcion() {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
				() -> ValidarContacto.validarTelefono("123"));
		assertEquals("El telefono debe tener 10 digitos", e.getMessage());
	}

	@Test
	void telefonoNuloLanzaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> ValidarContacto.validarTelefono(null));
	}

	@Test
	void telefonoConLetrasLanzaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> ValidarContacto.validarTelefono("09812345ab"));
	}

	@Test
	void telefonoDeNueveOOnceDigitosLanzaExcepcion() {
		assertThrows(IllegalArgumentException.class, () -> ValidarContacto.validarTelefono("098123456"));
		assertThrows(IllegalArgumentException.class, () -> ValidarContacto.validarTelefono("09812345678"));
	}

}