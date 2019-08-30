package gov.co.escuela.bct.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import gov.co.escuela.bct.connection.MysqlConnection;
import gov.co.escuela.bct.dto.ParametrosCursoFormacionDTO;
import gov.co.escuela.bct.service.util.ParametrosCursosFormacionMapper;

public class ParametrosCursoFormacionDAO {
		
	private final static Logger LOGGER = Logger.getLogger("gov.co.escuela.bct.controllers.impl.ParametrosCursoFormacionDAO");
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	public List<ParametrosCursoFormacionDTO> getCursosFormacionByState(){
		
		List<ParametrosCursoFormacionDTO> cursoFormacionDTOs;
		ParametrosCursosFormacionMapper pcfm = new ParametrosCursosFormacionMapper();
		try {
			connection = MysqlConnection.conectar();
			statement = connection.createStatement();
			String query = "SELECT * "
					+ "FROM "
					+ "registroacademico.rd_parametros_curso_formacion "
					+ "WHERE rd_parametros_curso_formacion.estado_curso IN('CERRADO', 'TERMINADO') ";
			
			resultSet = statement.executeQuery(query);
			cursoFormacionDTOs = pcfm.parametrosCursoFormacionDTOMapper(resultSet);
			if (!cursoFormacionDTOs.isEmpty() || cursoFormacionDTOs != null) {
				return cursoFormacionDTOs;
			}
		} catch (SQLException e) {
			 Logger.getLogger(ParametrosCursoFormacionDAO.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		return null;		
	}
}
