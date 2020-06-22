package cl.icap.controlCinco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.controlCinco.model.dao.NotasDAO;
import cl.icap.controlCinco.model.dto.NotasDTO;

@Service
public class NotasServiceImpl implements NotasService {

	@Autowired
	NotasDAO notasDAO;
	
	public List<NotasDTO> list() {
		return notasDAO.list();
	}

	public NotasDTO get(String RUT) {
		return notasDAO.get(RUT);
	}

	public int insert(NotasDTO notasDTO) {
		return notasDAO.insert(notasDTO);
	}

	public int update(NotasDTO notasDTO) {
		return notasDAO.update(notasDTO);
	}

	public int delete(String RUT, Integer NUMERO_MODULO, Integer NUMERO_EVALUACION) {
		return notasDAO.delete(RUT, NUMERO_MODULO, NUMERO_EVALUACION);
	}
}
