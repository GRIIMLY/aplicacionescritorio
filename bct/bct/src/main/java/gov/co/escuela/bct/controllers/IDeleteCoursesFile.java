package gov.co.escuela.bct.controllers;

public interface IDeleteCoursesFile {

	
	/**
	 * Metodo encrgado de eliminar los archivos de las escarapelas de los cursos que estan cerrados
	 */
	void DeleteCoursesFiles();
	
	/**
	 * metodo que se encarga de dar la posición del segundo guion bajo que es donde se encuentra el id del curso
	 * @param fileName
	 * @return
	 */
	int findPositionOfUnderscore(String fileName );
	
}
