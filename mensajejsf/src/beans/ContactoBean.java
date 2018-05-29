package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import controller.LoginController;
import entities.Contacto;
import model.ContactoDao;

@ManagedBean
@SessionScoped
public class ContactoBean {
	
	Contacto contacto = new Contacto();
	
	List<Contacto> contactos = new ArrayList<Contacto>();
	
	ContactoDao cDao = new ContactoDao();
	
	@ManagedProperty(value="#{loginController}")
	private LoginController loginController;

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public List<Contacto> getContactos() {
		return cDao.list();
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}
	
	public String nuevo(){
		this.contacto = new Contacto();
		return "sucess";
	}
	
	public void guardar(){
		this.contacto.setUsuarioBean(loginController.getUsuario());
		cDao.insert(this.contacto);
		cDao.getEm().refresh(loginController.getUsuario());
	}

	public LoginController getLoginController() {
		return loginController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	
	
	
}
