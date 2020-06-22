package cl.icap.controlCinco.model.dao;

import java.util.List;

import cl.icap.controlCinco.model.dto.CursosDTO;

public interface CursosDAO {
	public List<CursosDTO> list();
	public CursosDTO get(Integer COD_CURSO);
	public int insert(CursosDTO cursosDTO);
	public int update(CursosDTO cursosDTO);
	public int delete(Integer COD_CURSO);
}
