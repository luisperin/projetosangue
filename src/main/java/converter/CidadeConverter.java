package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import modelo.Cidade;
import dao.CidadeDAO;


public class CidadeConverter  implements Converter{

	@Inject
	private CidadeDAO cidadeDAO;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
	
		Cidade retorno = null;
		
		if (value !=null) {
			Integer id= new Integer(value);
			retorno = this.cidadeDAO.buscarPeloCodigo(new Integer(id));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		// TODO Auto-generated method stub
		if (value != null) {
			Integer codigo = ((Cidade) value).getCodigo();
			String retorno =(codigo==null ? null :codigo.toString());
			
			return retorno;
		}
		return "";
	}

}
