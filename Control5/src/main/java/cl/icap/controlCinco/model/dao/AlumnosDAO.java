package cl.icap.controlCinco.model.dao;

import java.util.List;

import cl.icap.controlCinco.model.dto.AlumnosDTO;

public interface AlumnosDAO {

	public List<AlumnosDTO> list();
	public AlumnosDTO get(String RUT);
	public int insert(AlumnosDTO alumnosDTO);
	public int update(AlumnosDTO alumnosDTO);
	public int delete(String RUT);
}
