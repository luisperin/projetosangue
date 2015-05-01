package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.PreTriagem;
import cdi.CDIServiceLocator;
import dao.PreTriagemDAO;

@FacesConverter(forClass=PreTriagem.class)
public class PretriagemConverter implements Converter {

	private PreTriagemDAO preTriagemDAO;
	
	public PretriagemConverter() {
		this.preTriagemDAO = CDIServiceLocator.getBean(PreTriagemDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		PreTriagem retorno = null;

		if (value != null) {
			retorno = this.preTriagemDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((PreTriagem) value).getCodigo();
			return codigo == null ? null : codigo.toString();
		}
		return "";
	}

}