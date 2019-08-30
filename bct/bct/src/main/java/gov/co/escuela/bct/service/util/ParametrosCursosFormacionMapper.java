package gov.co.escuela.bct.service.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gov.co.escuela.bct.dto.ParametrosCursoFormacionDTO;

public class ParametrosCursosFormacionMapper {
	
	
	
	
	
	public ParametrosCursosFormacionMapper() {

	}

	/**
	 * Metodo encargado de mapear los datos necesarios de la consulta al DTO
	 * @param resultado
	 * @return
	 */
	public List<ParametrosCursoFormacionDTO> parametrosCursoFormacionDTOMapper(ResultSet resultado) {
		List<ParametrosCursoFormacionDTO> parametrosCursoFormacionDTOs = new ArrayList<>();
		try {
			while (resultado.next()) {
				ParametrosCursoFormacionDTO pcf = new ParametrosCursoFormacionDTO(
						resultado.getInt("id_curso_formacion_fk"));
				parametrosCursoFormacionDTOs.add(pcf);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return parametrosCursoFormacionDTOs;

	}

}
