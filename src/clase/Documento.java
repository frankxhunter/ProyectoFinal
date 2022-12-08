package clase;

public class Documento {
	private String documento;
	private Boolean obligatorio;
	
	public Documento(String documento, Boolean obligatorio) {
		this.documento = documento;
		this.obligatorio = obligatorio;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public Boolean getObligatorio() {
		return obligatorio;
	}
	public void setObligatorio(Boolean obligatorio) {
		this.obligatorio = obligatorio;
	}
	
	

}
