package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.Cadastro;
import cdi.CDIServiceLocator;
import dao.CadastroDAO;

@FacesConverter(forClass=Cadastro.class)
public class CadastrsConverter implements Converter {

	private CadastroDAO cadastroDAO;
	
	public CadastrsConverter() {
		this.cadastroDAO = CDIServiceLocator.getBean(CadastroDAO.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Cadastro retorno = null;

		if (value != null) {
			retorno = this.cadastroDAO.buscarPeloCodigo(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Cadastro) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}