package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Mensaje;
import model.MensajeDao;

@ManagedBean
@SessionScoped
public class MensajeBean {
	Mensaje mensaje = new Mensaje();
	
	List<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	MensajeDao mDao = new MensajeDao();

	public Mensaje getMensaje() {
		return mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public List<Mensaje> getMensajes() {
		return mDao.list();
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	
	
}
