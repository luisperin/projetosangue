package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.TriagemCliQuest;
import cdi.CDIServiceLocator;
import dao.TriagemCliQuestDAO;

@FacesConverter(forClass=TriagemCliQuest.class)
public class TriagemCliQueConverter implements Converter {

	private TriagemCliQuestDAO triagemCliQuestDAO;
	
	public TriagemCliQueConverter() {
		this.triagemCliQuestDAO = CDIServiceLocator.getBean(TriagemCliQuestDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TriagemCliQuest retorno = null;

		if (value != null) {
			retorno = this.triagemCliQuestDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((TriagemCliQuest) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}