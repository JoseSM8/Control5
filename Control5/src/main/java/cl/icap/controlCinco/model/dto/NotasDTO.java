package cl.icap.controlCinco.model.dto;

public class NotasDTO {

	private Integer numero_modulo;
	private Integer numero_evaluacion;
	private Integer nota;
	private Integer cod_curso;
	private String rut;
	
	public Integer getNumero_modulo() {
		return numero_modulo;
	}
	public void setNumero_modulo(Integer numero_modulo) {
		this.numero_modulo = numero_modulo;
	}
	public Integer getNumero_evaluacion() {
		return numero_evaluacion;
	}
	public void setNumero_evaluacion(Integer numero_evaluacion) {
		this.numero_evaluacion = numero_evaluacion;
	}
	public Integer getNota() {
		return nota;
	}
	public void setNota(Integer nota) {
		this.nota = nota;
	}
	public Integer getCod_curso() {
		return cod_curso;
	}
	public void setCod_curso(Integer cod_curso) {
		this.cod_curso = cod_curso;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	
}
