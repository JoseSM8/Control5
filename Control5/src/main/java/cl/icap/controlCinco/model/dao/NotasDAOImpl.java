package cl.icap.controlCinco.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.controlCinco.model.dto.NotasDTO;

@Repository
@Transactional
public class NotasDAOImpl implements NotasDAO {
	private String list = "SELECT * FROM notas";
	private String get = "SELECT * FROM notas WHERE RUT=?";
	private String insert = "INSERT INTO notas VALUES(?,?,?,?,?)";
	private String update = "UPDATE notas SET NOTA=? WHERE RUT=? AND NUMERO_MODULO=? AND NUMERO_EVALUACION=?";
	private String delete = "DELETE NOTAS WHERE RUT=? AND NUMERO_MODULO=? AND NUMERO_EVALUACION=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<NotasDTO> list() {
		List<NotasDTO> listNotas = jdbcTemplate.query(list, BeanPropertyRowMapper.newInstance(NotasDTO.class));
		return listNotas;
	}
	
	@Override
	public NotasDTO get(String RUT) {
		Object[] args = {RUT};
		NotasDTO NotasDTO;
		try {
			NotasDTO = jdbcTemplate.queryForObject(get, args, BeanPropertyRowMapper.newInstance(NotasDTO.class));
		} catch (EmptyResultDataAccessException e) {
			NotasDTO=null;
			e.printStackTrace();
		} catch (Exception e) {
			NotasDTO=null;
			e.printStackTrace();
		}
		return NotasDTO;
	}
	
	@Override
	public int insert(NotasDTO notasDTO) {
		int rows = 0;
		Object[] args = {
				notasDTO.getNumero_modulo(),
				notasDTO.getNumero_evaluacion(),
				notasDTO.getNota(),
				notasDTO.getCod_curso(),
				notasDTO.getRut()
		};
		try {
			rows = jdbcTemplate.update(insert, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int update(NotasDTO notasDTO) {
		int rows = 0;
		Object[] args = {
				notasDTO.getNota(),
				notasDTO.getRut(),
				notasDTO.getNumero_modulo(),
				notasDTO.getNumero_evaluacion()
		};
		try {
			rows = jdbcTemplate.update(update, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int delete(String RUT, Integer NUMERO_MODULO, Integer NUMERO_EVALUACION) {
		int rows = 0;
		Object[] args = {
				RUT,
				NUMERO_MODULO,
				NUMERO_EVALUACION
		};
		try {
			rows = jdbcTemplate.update(delete, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
