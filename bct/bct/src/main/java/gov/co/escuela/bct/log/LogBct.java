package gov.co.escuela.bct.log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogBct {

	private final static Logger LOG_RAIZ = Logger.getLogger("gov.co");
	private final static Logger LOGGERVIEW = Logger.getLogger("gov.co.escuela.bct.AppView");
	private final static Logger LOGGERCONTROLLER = Logger
			.getLogger("gov.co.escuela.bct.controllers.impl.DeleteCourseFileImpl");
	private final static Logger LOGGER = Logger
			.getLogger("gov.co.escuela.bct.src.main.java.gov.co.escuela.bct.log.LogBct");

	public void logs() {
		try {
			// Los handler (manejadores) indican a donde mandar la salida ya sea consola o
			// archivo
			// En este caso ConsoleHandler envia los logs a la consola
			Handler consoleHandler = new ConsoleHandler();
			// Con el manejador de archivo, indicamos el archivo donde se mandaran los logs
			// El segundo argumento controla si se sobre escribe el archivo o se agregan los
			// logs al final
			// Para sobre escribir pase un true para agregar al final, false para sobre
			// escribir
			// todo el archivo
			String desktopPath = System.getProperty("user.home");
			desktopPath = desktopPath.replace("\\", "/");
			File file = new File(".","logs.log");
			System.out.println("el path del archivo es  ___________________" + file.getAbsolutePath());
			Handler fileHandler = new FileHandler(file.getAbsolutePath(), false);

			// El formateador indica como presentar los datos, en este caso usaremos el
			// formaro sencillo
			// el cual es mas facil de leer, si no usamos esto el log estara en formato xml
			// por defecto
			SimpleFormatter simpleFormatter = new SimpleFormatter();

			// Se especifica que formateador usara el manejador (handler) de archivo
			fileHandler.setFormatter(simpleFormatter);

			// Asignamos los handles previamente declarados al log *raiz* esto es muy
			// importante ya que
			// permitira que los logs de todas y cada una de las clases del programa que
			// esten en ese paquete
			// o sus subpaquetes se almacenen en el archivo y aparescan en consola
			LOG_RAIZ.addHandler(consoleHandler);
			LOG_RAIZ.addHandler(fileHandler);

			// Indicamos a partir de que nivel deseamos mostrar los logs, podemos
			// especificar un nivel en especifico
			// para ignorar informacion que no necesitemos
			consoleHandler.setLevel(Level.ALL);
			fileHandler.setLevel(Level.ALL);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, LogBct.getStackTrace(e));
		}

	}

	/**
	 * Esta funcion nos permite convertir el stackTrace en un String, necesario para
	 * poder imprimirlos al log debido a cambios en como Java los maneja
	 * internamente
	 *
	 * @param e Excepcion de la que queremos el StackTrace
	 * @return StackTrace de la excepcion en forma de String
	 */
	public static String getStackTrace(Exception e) {
		StringWriter sWriter = new StringWriter();
		PrintWriter pWriter = new PrintWriter(sWriter);
		e.printStackTrace(pWriter);
		return sWriter.toString();
	}
	

}
