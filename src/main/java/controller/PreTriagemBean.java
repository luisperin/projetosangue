package controller;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jsf.FacesUtil;
import service.NegocioException;
import service.PreTriagemService;
import modelo.Cadastro;
import modelo.PreTriagem;
import dao.CadastroDAO;

@Named
@ViewScoped
public class PreTriagemBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private PreTriagem preTriagem;
	
	private List<Cadastro> cadastros;
	
	
	@Inject
	private PreTriagemService preTriagemService;
	
	@Inject
	private CadastroDAO cadastroDAO;
	
	public void salvar() {
		try {
			this.preTriagemService.salvar(preTriagem);
			FacesUtil.addSuccessMessage(" salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.cadastros = cadastroDAO.buscarTodos();
	}
	
	public void limpar() {
		this.preTriagem = new PreTriagem();
	}

	public PreTriagem getPreTriagem() {
		return preTriagem;
	}
	public void setPreTriagem(PreTriagem preTriagem) {
		this.preTriagem = preTriagem;
	}

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	
	
}
