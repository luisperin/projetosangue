package modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionario {

	private Long codigo;	
	private String nome_funcionario;
	private Date data_nascimento;
	private String idade;
	private String	pais_nascimento;
	private String estado_nascimento;
	private String municipio_nascimento;
	private String nacionalidade;
	private String sexo;
	private String	etnia;
	private String estado_civil;
	private String escolaridade;
	private String profissao;
	private String abo;
	private String rh;
	
	
	private String cpf;
	private String rg;
	private Date data_emissao_rg;
	private String orgão_expeditor;
	private String estado_emissor;
	private String cartao_cns;

	private String nome_mae; 
	private String nome_pai;


	private String logradouro;
	private Double numero;
	private String complemento;
/*	private String bairro;
	private estado;
	municipio*/
	private String cep;
	private String zona;
	private String fone_fixo;
	private String fone_celular;
	private String fone_recado;
	private String e_mail;


	// CAMPOS APENAS PARA O FUNCIONARIO ( OS DE CIMA + ESSES DEBAIXO)


	private Date data_entrada;
	private String data_desligamento;
	private Date data_atribuicao;
	private String cbo_funcionario;
	private String cbo_descricao;
	private Double ch_outros;
	private Double ch_ambulatorio;
	private Double 	ch_hospital;
	private Double  ch_total;
	private  String tipo_vinculo;
	private String  vinculo_funcionario;
	private String situacao_funcionario;
	private String cargo_funcionario;
	private String funcao_funcionario;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
    public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	

	
	public String getNome_funcionario() {
		return nome_funcionario;
	}
	public void setNome_funcionario(String nome_funcionario) {
		this.nome_funcionario = nome_funcionario;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getPais_nascimento() {
		return pais_nascimento;
	}
	public void setPais_nascimento(String pais_nascimento) {
		this.pais_nascimento = pais_nascimento;
	}
	public String getEstado_nascimento() {
		return estado_nascimento;
	}
	public void setEstado_nascimento(String estado_nascimento) {
		this.estado_nascimento = estado_nascimento;
	}
	public String getMunicipio_nascimento() {
		return municipio_nascimento;
	}
	public void setMunicipio_nascimento(String municipio_nascimento) {
		this.municipio_nascimento = municipio_nascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEtnia() {
		return etnia;
	}
	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getAbo() {
		return abo;
	}
	public void setAbo(String abo) {
		this.abo = abo;
	}
	public String getRh() {
		return rh;
	}
	public void setRh(String rh) {
		this.rh = rh;
	}
	
	
	
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Date getData_emissao_rg() {
		return data_emissao_rg;
	}
	public void setData_emissao_rg(Date data_emissao_rg) {
		this.data_emissao_rg = data_emissao_rg;
	}
	public String getOrgão_expeditor() {
		return orgão_expeditor;
	}
	public void setOrgão_expeditor(String orgão_expeditor) {
		this.orgão_expeditor = orgão_expeditor;
	}
	public String getEstado_emissor() {
		return estado_emissor;
	}
	public void setEstado_emissor(String estado_emissor) {
		this.estado_emissor = estado_emissor;
	}
	public String getCartao_cns() {
		return cartao_cns;
	}
	public void setCartao_cns(String cartao_cns) {
		this.cartao_cns = cartao_cns;
	}
	public String getNome_mae() {
		return nome_mae;
	}
	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}
	public String getNome_pai() {
		return nome_pai;
	}
	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Double getNumero() {
		return numero;
	}
	public void setNumero(Double numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	public String getFone_fixo() {
		return fone_fixo;
	}
	public void setFone_fixo(String fone_fixo) {
		this.fone_fixo = fone_fixo;
	}
	public String getFone_celular() {
		return fone_celular;
	}
	public void setFone_celular(String fone_celular) {
		this.fone_celular = fone_celular;
	}
	public String getFone_recado() {
		return fone_recado;
	}
	public void setFone_recado(String fone_recado) {
		this.fone_recado = fone_recado;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public Date getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}
	public String getData_desligamento() {
		return data_desligamento;
	}
	public void setData_desligamento(String data_desligamento) {
		this.data_desligamento = data_desligamento;
	}
	public Date getData_atribuicao() {
		return data_atribuicao;
	}
	public void setData_atribuicao(Date data_atribuicao) {
		this.data_atribuicao = data_atribuicao;
	}
	public String getCbo_funcionario() {
		return cbo_funcionario;
	}
	public void setCbo_funcionario(String cbo_funcionario) {
		this.cbo_funcionario = cbo_funcionario;
	}
	public String getCbo_descricao() {
		return cbo_descricao;
	}
	public void setCbo_descricao(String cbo_descricao) {
		this.cbo_descricao = cbo_descricao;
	}
	public Double getCh_outros() {
		return ch_outros;
	}
	public void setCh_outros(Double ch_outros) {
		this.ch_outros = ch_outros;
	}
	public Double getCh_ambulatorio() {
		return ch_ambulatorio;
	}
	public void setCh_ambulatorio(Double ch_ambulatorio) {
		this.ch_ambulatorio = ch_ambulatorio;
	}
	public Double getCh_hospital() {
		return ch_hospital;
	}
	public void setCh_hospital(Double ch_hospital) {
		this.ch_hospital = ch_hospital;
	}
	public Double getCh_total() {
		return ch_total;
	}
	public void setCh_total(Double ch_total) {
		this.ch_total = ch_total;
	}
	public String getTipo_vinculo() {
		return tipo_vinculo;
	}
	public void setTipo_vinculo(String tipo_vinculo) {
		this.tipo_vinculo = tipo_vinculo;
	}
	public String getVinculo_funcionario() {
		return vinculo_funcionario;
	}
	public void setVinculo_funcionario(String vinculo_funcionario) {
		this.vinculo_funcionario = vinculo_funcionario;
	}
	public String getSituacao_funcionario() {
		return situacao_funcionario;
	}
	public void setSituacao_funcionario(String situacao_funcionario) {
		this.situacao_funcionario = situacao_funcionario;
	}
	public String getCargo_funcionario() {
		return cargo_funcionario;
	}
	public void setCargo_funcionario(String cargo_funcionario) {
		this.cargo_funcionario = cargo_funcionario;
	}
	public String getFuncao_funcionario() {
		return funcao_funcionario;
	}
	public void setFuncao_funcionario(String funcao_funcionario) {
		this.funcao_funcionario = funcao_funcionario;
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
		Funcionario other = (Funcionario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
