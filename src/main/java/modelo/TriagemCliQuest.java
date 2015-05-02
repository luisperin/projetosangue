	package modelo;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TriagemCliQuest {

	private Long codigo;
	private String codext;
	private String Naptidao;
	private String volColeta;
private PreTriagem doad;//Achei
	private Cadastro cadastro;
	private String apto;
	private String naoApto;
	
	private List<NovaPergunta> novaPergunta;
	private List<TriagemClinicResp> triagemClinicaResposta;//alugueis
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	

	public String getCodext() {
		return codext;
	}
	public void setCodext(String codext) {
		this.codext = codext;
	}
	
	
	
	public String getNaptidao() {
		return Naptidao;
	}
	public void setNaptidao(String naptidao) {
		Naptidao = naptidao;
	}
	

	
	
	@ManyToOne
@JoinColumn(name="codigo_doad")//codigo doador
public PreTriagem getDoad() {
		return doad;
	}
	
	public void setDoad(PreTriagem doad) {
		this.doad = doad;
	}

	
	
	public String getApto() {
		return apto;
	}

	
	public void setApto(String apto) {
		this.apto = apto;
	}
	public String getNaoApto() {
		return naoApto;
	}
	public void setNaoApto(String naoApto) {
		this.naoApto = naoApto;
	}

	public String getVolColeta() {
		return volColeta;
	}
	public void setVolColeta(String volColeta) {
		this.volColeta = volColeta;
	}
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="cadastro_pergunta"
				, joinColumns=@JoinColumn(name="codigo_cadastro")
				, inverseJoinColumns=@JoinColumn(name="codigo_pergunta"))
	public List<NovaPergunta> getNovaPergunta() {
		return novaPergunta;
	}
	public void setNovaPergunta(List<NovaPergunta> novaPergunta) {
		this.novaPergunta = novaPergunta;
	}
	
	@OneToMany(mappedBy="triagemCliQuest")
	public List<TriagemClinicResp> getTriagemClinicaResposta() {
		return triagemClinicaResposta;
	}
	public void setTriagemClinicaResposta(List<TriagemClinicResp> triagemClinicaResposta) {
		this.triagemClinicaResposta = triagemClinicaResposta;
	}
	
	
	

	@ManyToOne
	@JoinColumn(name="codigo_doador")	
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
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
		TriagemCliQuest other = (TriagemCliQuest) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
