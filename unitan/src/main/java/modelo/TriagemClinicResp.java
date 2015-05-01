package modelo;




import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TriagemClinicResp {

	private Long codigo;//vl totl
	private TriagemCliQuest triagemCliQuest;
	
	private Aptidao aptidao;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="codigo_apt_clinica")
	public Aptidao getAptidao() {
		return aptidao;
	}
	public void setAptidao(Aptidao aptidao) {
		this.aptidao = aptidao;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_ques")
	public TriagemCliQuest getTriagemCliQuest() {
		return triagemCliQuest;
	}
	public void setTriagemCliQuest(TriagemCliQuest triagemCliQuest) {
		this.triagemCliQuest = triagemCliQuest;
	}

	
	//Aqui
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
		TriagemClinicResp other = (TriagemClinicResp) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
