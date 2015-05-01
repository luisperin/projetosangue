package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.FacesUtil;
import service.CadastroService;
import service.NegocioException;
import modelo.Cadastro;

@Named
@ViewScoped
public class CadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CadastroService cadastroService;
	private Cadastro cadastro;
	
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
	}
	
	public void limpar() {
		this.cadastro = new Cadastro();
	}

	
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	
	
}
