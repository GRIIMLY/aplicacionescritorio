package gov.co.escuela.bct;

import java.util.logging.Level;
import java.util.logging.Logger;

import gov.co.escuela.bct.controllers.impl.DeleteCourseFileImpl;
import gov.co.escuela.bct.log.LogBct;

public class AppView {

	private final static Logger LOGGER = Logger.getLogger("gov.co.escuela.bct.AppView");

	public static void main(String[] args) {
		
		
		
		try {
			LogBct logbct = new LogBct();
			logbct.logs();
			DeleteCourseFileImpl courseFileImpl = new DeleteCourseFileImpl();
			courseFileImpl.DeleteCoursesFiles();
			LOGGER.log(Level.INFO, "Fin de la aplicación");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
