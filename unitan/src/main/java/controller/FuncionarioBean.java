package controller;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.FacesUtil;
import service.FuncionarioService;
import service.NegocioException;
import modelo.Funcionario;

@Named
@ViewScoped
public class FuncionarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private FuncionarioService funcionarioService;
	private Funcionario funcionario;
	
	public void salvar() {
		try {
			this.funcionarioService.salvar(funcionario);
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
		this.funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	
	


	
	
}
