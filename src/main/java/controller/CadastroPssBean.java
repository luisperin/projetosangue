package controller;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.FacesUtil;
import service.NegocioException;
import service.TriagemClinicQuestService;
import modelo.Cadastro;
import modelo.NovaPergunta;
import modelo.PreTriagem;
import modelo.TriagemCliQuest;
import modelo.TriagemClinicResp;
import dao.CadastroDAO;
import dao.PeruntaDAO;
import dao.PreTriagemDAO;

@Named
@ViewScoped
public class CadastroPssBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TriagemCliQuest triagemCliQuest;

	
	private List<PreTriagem> pretriagem;//mode
	
	private List<NovaPergunta> novaPergunta;//para o doador
	
	private List<Cadastro> cadastros;//Listas de doadores
	
	@Inject
	private TriagemClinicQuestService triagemClinicQuestService;
	
	@Inject
	private PeruntaDAO peruntaDAO;
	
	@Inject
	private CadastroDAO cadastroDAO;
	
	@Inject
	private PreTriagemDAO preTriagemDAO;
	
	private TriagemClinicResp triagemClinicResp;
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		
		this.novaPergunta = peruntaDAO.buscarTodos();
		this.pretriagem = this.preTriagemDAO.buscarTodos();
		this.cadastros = cadastroDAO.buscarTodos();
	}
	
	public void salvar() {
		try {
			this.triagemClinicQuestService.salvar(triagemCliQuest);
			FacesUtil.addSuccessMessage("Salvo com sucesso!!!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			FacesUtil.addErrorMessage("Erro ao salvar");
		}
		
		this.limpar();
	}
	
	public void limpar() {
		this.triagemCliQuest = new TriagemCliQuest();
		this.triagemCliQuest.setNovaPergunta(new ArrayList<NovaPergunta>());
	}
	
	public TriagemCliQuest getTriagemCliQuest() {
		return triagemCliQuest;
	}
	public void setTriagemCliQuest(TriagemCliQuest triagemCliQuest) {
		this.triagemCliQuest = triagemCliQuest;
	}

	public List<NovaPergunta> getNovaPerguntas() {
		return novaPergunta;
	}

	public List<PreTriagem> getPretriagem() {
		return pretriagem;
	}

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	
}
