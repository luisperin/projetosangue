package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.FacesUtil;
import service.AvaliacaoService;
import service.NegocioException;
import modelo.Aptidao;
import modelo.TriagemCliQuest;
import modelo.TriagemClinicResp;
import dao.TriagemCliQuestDAO;

@Named
@ViewScoped
public class AvaliacaoClinicBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TriagemClinicResp triagemClinicResp;
	
	private List<TriagemCliQuest> triagemCliQuests;
	
	@Inject
	private AvaliacaoService avaliacaoService;
	
	@Inject
	private TriagemCliQuestDAO triagemCliQuestDAO;
	
	public void salvar() {
		try {
			this.avaliacaoService.salvar(triagemClinicResp);
			FacesUtil.addSuccessMessage("TriagemClinicResp salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		
		this.triagemCliQuests = this.triagemCliQuestDAO.buscarTodos();
	}
	
	public void limpar() {
		this.triagemClinicResp = new TriagemClinicResp();
		this.triagemClinicResp.setAptidao(new Aptidao());
	}

	public TriagemClinicResp getTriagemClinicResp() {
		return triagemClinicResp;
	}
	public void setTriagemClinicResp(TriagemClinicResp triagemClinicResp) {//Aguel
		this.triagemClinicResp = triagemClinicResp;
	}

	public List<TriagemCliQuest> getTriagemCliQuests() {//getCaos
		return triagemCliQuests;
	}

}
