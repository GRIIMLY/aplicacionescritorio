package gov.co.escuela.bct.controllers.impl;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import gov.co.escuela.bct.controllers.IDeleteCoursesFile;
import gov.co.escuela.bct.dao.ParametrosCursoFormacionDAO;
import gov.co.escuela.bct.dto.ParametrosCursoFormacionDTO;
import gov.co.escuela.bct.log.LogBct;

public class DeleteCourseFileImpl implements IDeleteCoursesFile {
	
	private final static Logger LOGGER = Logger.getLogger("gov.co.escuela.bct.controllers.impl.DeleteCourseFileImpl");
	private LogBct logbct = new LogBct();
	
	@Override
	public void DeleteCoursesFiles() {
		
		String desktopPath = "";
		
		try {
			
			ParametrosCursoFormacionDAO cursoFormacionDAO = new ParametrosCursoFormacionDAO();
			List<ParametrosCursoFormacionDTO> cursoFormacionDTOs = cursoFormacionDAO
					.getCursosFormacionByState();
			
			Integer codigoCurso = 0;
			desktopPath = System.getProperty("user.home");
			desktopPath = desktopPath.concat("\\Downloads\\escarapelas");
			desktopPath = desktopPath.replace("\\", "/");
			int position;
			System.out.println(desktopPath);
			File folder = new File(desktopPath);
			LOGGER.log(Level.INFO, "Se empieza el proceso de borrado de las escarapelas");
			for (String s : folder.list()) {
				position = findPositionOfUnderscore(s);
				codigoCurso = Integer.parseInt(s.substring(position + 1, s.length() - 4));
				for (ParametrosCursoFormacionDTO p : cursoFormacionDTOs) {
					if (p.getIdCursoFormacion().intValue() == codigoCurso.intValue()) {
						File file = new File(desktopPath
								.concat("/" + s));
						file.delete();
					}
				}
			}
			LOGGER.log(Level.INFO, "Finaliza el proceso de eliminación de escarapelas");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Se genero un error al eliminar las escarapelas en la ruta : " + desktopPath);
			LOGGER.log(Level.SEVERE, logbct.getStackTrace(e));
			
			e.printStackTrace();
		}

	}

	@Override
	public int findPositionOfUnderscore(String fileName) {
		char caracter = '_';
		int posicion = 0;
		int contador = 0;
		for (int i = 0; i < fileName.length(); i++) {
			if (fileName.charAt(i) == caracter) {
				contador++;
				posicion = i;
				if (contador == 2) {
					break;
				}
			}
		}
		return posicion;
	}
	
	

}
