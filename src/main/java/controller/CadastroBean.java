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

	private Estado estado;// set e set

	//@Inject
	//private Categorias categorias;
	@Inject
	private CadastroService cadastroService;
	private Cadastro cadastro;
	private EstadoDAO estadoDAO;// gets e sets
	private CidadeDAO cidadeDAO;

	private List<Estado> estados;
	private List<Cidade> cidades;

	
	//ivate Categoria categoriaPai;
	
	//private List<Categoria> categoriasRaizes;
	//private List<Categoria> subcategorias;

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
		
		//		categoriasRaizes = categorias.raizes();
		
	}


	public void carregarSubcategorias() {
		//subcategorias = categorias.subcategoriasDe(categoriaPai);
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

	public List<Estado> getEstados() {
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

	
	//Cateforias aaaa
	
/*
	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}
	

	public List<Categoria> getCategoriasRaizes() {
		return categoriasRaizes;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}
*/
}