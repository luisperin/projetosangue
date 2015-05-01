package controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.FacesUtil;
import service.NegocioException;
import service.PerguntaService;
import modelo.NovaPergunta;

@Named
@ViewScoped
public class CadastrarperguntasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private NovaPergunta novaPergunta;//ac
	
	@Inject
	private PerguntaService perguntaService;
	
	public CadastrarperguntasBean() {
		this.limpar();
	}
	
	public void salvar() {
		try {
			this.perguntaService.salvar(novaPergunta);
			FacesUtil.addSuccessMessage("Pergunta salva com sucesso ");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.novaPergunta = new NovaPergunta();
	}

	public NovaPergunta getNovaPergunta() {
		return novaPergunta;
	}
	public void setNovaPergunta(NovaPergunta novaPergunta) {
		this.novaPergunta = novaPergunta;
	}
	
}
