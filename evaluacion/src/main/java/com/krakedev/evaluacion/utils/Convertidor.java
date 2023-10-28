package com.krakedev.evaluacion.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.evaluacion.excepciones.KrakedevException;

public class Convertidor {
	private static final String FORMATO_fecha = "yyyy/MM/dd";
	private static final String FORMATO_hora = "hh:mm";
	private static final Logger LOGGER = LogManager.getFormatterLogger(Convertidor.class);


	public static Date convertirFecha(String fechaStr) throws KrakedevException {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_fecha);
		Date fechaDate = null;
		try {
			LOGGER.debug("Convirtiendo fecha "+fechaStr);
			fechaDate = sdf.parse(fechaStr);
			LOGGER.debug("Fecha convertida "+fechaDate);
			// captura la excepcion
		} catch (ParseException e) {
			LOGGER.error("La fecha no tiene el formato correcto "+fechaStr, e);
			// propagamos // lanzo una exepcion con un mensaje de usuario
			throw new KrakedevException("La fecha no tiene el formato correcto "+fechaStr);
		}
		return fechaDate;
	}
	
	public static Date convertirHora(String horaStr) throws KrakedevException {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_hora);
		Date horaDate = null;
		try {
			horaDate = sdf.parse(horaStr);
			// captura la excepcion
		} catch (ParseException e) {
			LOGGER.error("La hora no tiene el formato correcto "+horaDate, e);
			// propagamos // lanzo una exepcion con un mensaje de usuario
			throw new KrakedevException("La hora no tiene el formato correcto "+horaDate);
		}
		return horaDate;
	}
}
