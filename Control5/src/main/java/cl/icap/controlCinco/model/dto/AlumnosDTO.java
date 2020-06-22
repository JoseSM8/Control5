package cl.icap.controlCinco.model.dto;

public class AlumnosDTO {
	
	private String RUT;
	private String NOMBRE;
	private Integer COD_CURSO;
	
	public String getRUT() {
		return RUT;
	}
	public void setRUT(String rUT) {
		RUT = rUT;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public Integer getCOD_CURSO() {
		return COD_CURSO;
	}
	public void setCOD_CURSO(Integer cOD_CURSO) {
		COD_CURSO = cOD_CURSO;
	}
}
