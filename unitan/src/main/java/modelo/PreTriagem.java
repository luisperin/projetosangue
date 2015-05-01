package modelo;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PreTriagem {

	private Long codigo;
	private Date datatriagem;
	private String descricao;
    private Double hematocrito;
	private Double peso;
	private Double altura;
    private String temperatura;
	private String pulso;
	private String pressaoarterial;
	private String hemoglobina;
	private Cadastro cadastro;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	
	public String getHemoglobina() {
		return hemoglobina;
	}
	public void setHemoglobina(String hemoglobina) {
		this.hemoglobina = hemoglobina;
	}
	public Double getHematocrito() {
		return hematocrito;
	}
	public void setHematocrito(Double hematocrito) {
		this.hematocrito = hematocrito;
	}
	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	
	public String getPulso() {
		return pulso;
	}
	public void setPulso(String pulso) {
		this.pulso = pulso;
	}
	
	public String getPressaoarterial() {
		return pressaoarterial;
	}
	public void setPressaoarterial(String pressaoarterial) {
		this.pressaoarterial = pressaoarterial;
	}
	
	@ManyToOne
	@JoinColumn(name="codigo_doador")
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	
	
	
	
	public Date getDatatriagem() {
		return datatriagem;
	}
	public void setDatatriagem(Date datatriagem) {
		this.datatriagem = datatriagem;
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
		PreTriagem other = (PreTriagem) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
