package cl.icap.controlCinco.service;

import java.util.List;

import cl.icap.controlCinco.model.dto.NotasDTO;

public interface NotasService {
	public List<NotasDTO> list();
	public NotasDTO get(String RUT);
	public int insert(NotasDTO notasDTO);
	public int update(NotasDTO notasDTO);
	public int delete(String RUT, Integer NUMERO_MODULO, Integer NUMERO_EVALUACION);
}
