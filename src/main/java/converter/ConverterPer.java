package converter;

import javax.faces.component.UIComponent
;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.NovaPergunta;
import cdi.CDIServiceLocator;
import dao.PeruntaDAO;

@FacesConverter("acessorioConverter")
public class ConverterPer implements Converter {

	private PeruntaDAO peruntaDAO;
	
	public ConverterPer() {
		this.peruntaDAO = CDIServiceLocator.getBean(PeruntaDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		NovaPergunta retorno = null;
		
		if (value != null) {
			retorno = this.peruntaDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((NovaPergunta) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}