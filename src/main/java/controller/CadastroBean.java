package controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

//import modelo.Categoria;
import modelo.Cidade;
import modelo.Estado;
import dao.CidadeDAO;
import dao.EstadoDAO;
import jsf.FacesUtil;
//import repository.Categorias;
import service.CadastroService;
import service.NegocioException;
import modelo.Cadastro;

;

@Named
@ViewScoped
public class CadastroBean implements Serializable {


	private static final long serialVersionUID = 1L;

	private Estado estado;
	private Cidade cidade;
    private Cadastro cadastro;

	
	@Inject
	private EstadoDAO estadoDAO;
    @Inject	
	private CidadeDAO cidadeDAO;

	
	private List<Estado> estados;
	private List<Cidade> cidades;



	@Inject
	private CadastroService cadastroService;

	
	
	
	

	public void salvar() {
		try {
			this.cadastroService.salvar(cadastro);
			FacesUtil.addSuccessMessage("Cadastro salvo com sucesso!");

			this.limpar();

		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.cidades = new ArrayList<Cidade>();
	
	}


	public void limpar() {
		this.cadastro = new Cadastro();
	}

	/* Método carregar cidade assim que um estado for selecionado */
	public void carregarCidades() {
		cidades = cidadeDAO.buscarCidades(estado);
	}

	
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	/*
	public Cadastro getCadastro() {
		return cadastro;
	}
*/
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public List<Estado> getEstados() throws NegocioException {
try {
	if( (estado == null) || (estados.size()==0)) {
		estados = estadoDAO.buscarEstados();		
	}

} catch (Exception e) {// exeção
	
}
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}


}