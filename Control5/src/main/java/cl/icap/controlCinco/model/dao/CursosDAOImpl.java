package cl.icap.controlCinco.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cl.icap.controlCinco.model.dto.CursosDTO;

public class CursosDAOImpl implements CursosDAO {

	private String list = "SELECT * FROM Curso";
	private String get = "SELECT * FROM Curso WHERE COD_CURSO=?";
	private String insert = "INSERT INTO Curso VALUES(?,?)";
	private String update = "UPDATE Curso SET NOMBRE=? WHERE COD_CURSO=?";
	private String delete = "DELETE Curso WHERE COD_CURSO=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<CursosDTO> list() {
		List<CursosDTO> listCursos = jdbcTemplate.query(list, BeanPropertyRowMapper.newInstance(CursosDTO.class));
		return listCursos;
	}
	
	@Override
	public CursosDTO get(Integer COD_CURSO) {
		Object[] args = {COD_CURSO};
		CursosDTO cursosDTO;
		try {
			cursosDTO = jdbcTemplate.queryForObject(get, args, BeanPropertyRowMapper.newInstance(CursosDTO.class));
		} catch (EmptyResultDataAccessException e) {
			cursosDTO=null;
			e.printStackTrace();
		} catch (Exception e) {
			cursosDTO=null;
			e.printStackTrace();
		}
		return cursosDTO;
	}
	
	@Override
	public int insert(CursosDTO cursosDTO) {
		int rows = 0;
		Object[] args = {
				cursosDTO.getCOD_CURSO(),
				cursosDTO.getNOMBRE()
		};
		try {
			rows = jdbcTemplate.update(insert, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int update(CursosDTO cursosDTO) {
		int rows = 0;
		Object[] args = {
				cursosDTO.getNOMBRE(),
				cursosDTO.getCOD_CURSO()	
		};
		try {
			rows = jdbcTemplate.update(update, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
	
	@Override
	public int delete(Integer COD_CURSO) {
		int rows = 0;
		Object[] args = {COD_CURSO};
		try {
			rows = jdbcTemplate.update(delete, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}
}
