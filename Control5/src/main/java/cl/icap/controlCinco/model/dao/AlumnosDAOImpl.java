package cl.icap.controlCinco.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cl.icap.controlCinco.model.dto.AlumnosDTO;

@Repository
@Transactional
public class AlumnosDAOImpl implements AlumnosDAO {

	private String list = "SELECT * FROM alumnos";
	private String get = "SELECT * FROM alumnos WHERE RUT=?";
	private String insert = "INSERT INTO alumnos VALUES(?,?,?)";
	private String update = "UPDATE alumnos SET NOMBRE=?, COD_CURSO=? WHERE RUT=?";
	private String delete = "DELETE alumnos WHERE RUT=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<AlumnosDTO> list() {
		List<AlumnosDTO> listAlumnos = jdbcTemplate.query(list, BeanPropertyRowMapper.newInstance(AlumnosDTO.class));
		return listAlumnos;
	}
	
	@Override
	public AlumnosDTO get(String RUT) {
		Object[] args = {RUT};
		AlumnosDTO alumnosDTO;
		try {
			alumnosDTO = jdbcTemplate.queryForObject(get, args, BeanPropertyRowMapper.newInstance(AlumnosDTO.class));
		} catch (EmptyResultDataAccessException e) {
			alumnosDTO=null;
			e.printStackTrace();
		} catch (Exception e) {
			alumnosDTO=null;
			e.printStackTrace();
		}
		return alumnosDTO;
	}
	
	@Override
	public int insert(AlumnosDTO alumnosDTO) {
		int rows = 0;
		Object[] args = {
				alumnosDTO.getRUT(),
				alumnosDTO.getNOMBRE(),
				alumnosDTO.getCOD_CURSO()
		};
		try {
			rows = jdbcTemplate.update(insert, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int update(AlumnosDTO alumnosDTO) {
		int rows = 0;
		Object[] args = {
				alumnosDTO.getNOMBRE(),
				alumnosDTO.getCOD_CURSO(),
				alumnosDTO.getRUT()
		};
		try {
			rows = jdbcTemplate.update(update, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int delete(String RUT) {
		int rows = 0;
		Object[] args = {RUT};
		try {
			rows = jdbcTemplate.update(delete, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
