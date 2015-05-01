package modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="apt_clinica")
public class Aptidao {

	private Long codigo;
	private String ob1;
	private Boolean sim;
	private Boolean nao;
	private Boolean remarcar;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getOb1() {
		return ob1;
	}
	public void setOb1(String ob1) {
		this.ob1 = ob1;
	}
	
	public Boolean getSim() {
		return sim;
	}
	public void setSim(Boolean sim) {
		this.sim = sim;
	}
	
	public Boolean getNao() {
		return nao;
	}
	public void setNao(Boolean nao) {
		this.nao = nao;
	}
	
	public Boolean getRemarcar() {
		return remarcar;
	}
	public void setRemarcar(Boolean remarcar) {
		this.remarcar = remarcar;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aptidao other = (Aptidao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
