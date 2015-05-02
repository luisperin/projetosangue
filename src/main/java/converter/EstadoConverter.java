package converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import modelo.Estado;
import dao.EstadoDAO;


@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter {

	@Inject
	private EstadoDAO estadoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,String value) {
Estado  retorno = null;

if (value !=null) {
	Integer id = new Integer(value);
	retorno = this.estadoDAO.buscarPeloCodigo(new Integer(id));
	
}
		
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,Object value) {
	if ( value != null) {
		Integer codigo = ((Estado) value).getCodigo();
		String retorno =(codigo== null ? null :codigo.toString());
		
		return retorno;
	}
		
		return "";
	}

}
