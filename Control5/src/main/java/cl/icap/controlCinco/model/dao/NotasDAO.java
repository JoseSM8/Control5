package cl.icap.controlCinco.model.dao;

import java.util.List;

import cl.icap.controlCinco.model.dto.NotasDTO;

public interface NotasDAO {
	public List<NotasDTO> list();
	public NotasDTO get(String rut);
	public int insert(NotasDTO notasDTO);
	public int update(NotasDTO notasDTO);
	public int delete(String rut, Integer numero_modulo, Integer numero_evaluacion);
}
