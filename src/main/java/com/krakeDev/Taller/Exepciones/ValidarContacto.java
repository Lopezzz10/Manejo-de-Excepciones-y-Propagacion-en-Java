package com.krakeDev.Taller.Exepciones;

public class ValidarContacto {

	public static void validarTelefono(String telefono) throws IllegalArgumentException {

		if (telefono == null || !telefono.matches("\\d{10}")) {
			throw new IllegalArgumentException("El telefono debe tener 10 digitos");
		}
	}

}