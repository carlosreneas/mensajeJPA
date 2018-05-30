package controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import net.bootsfaces.component.message.Message;
import net.bootsfaces.utils.FacesMessages;

import entities.Usuario;
import model.UsuarioDao;


@ManagedBean
@SessionScoped
public class LoginController implements Serializable{
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	
	UsuarioDao usuarioDao = new UsuarioDao();
	
	String mensaje = null;
	
	//private String specificInfo = "Mensaje nuevo";
	

	
	
	public void specificInfo() {
		FacesMessages.info("loginForm:ref", "Info", "This is a specific message2!");
    }
	
	

	public void mensajeInfo(){
		FacesMessages.info(mensaje);
		mensaje="";
	}



	public LoginController(){
		usuario = new Usuario();
	}
	
	public ArrayList<Usuario> getUsuarios() {
		return (ArrayList<Usuario>) usuarioDao.list();
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String login(){
		System.out.println("Iniciando validación de Login");
		UsuarioDao loginDao = new UsuarioDao(); //creating object for LoginDao. This class contains main logic of the application.
		 
		this.usuario = loginDao.validarUsuario(usuario); //Calling authenticateUser function

		if(this.usuario != null) {
			
			/*
			session.setAttribute("userName", usuarioTxt); 
			request.setAttribute("msgResultado", "Usuario " + usuarioTxt + " bienvenido a la plataforma de mensajes"); 			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			*/
			
			mensaje = "Usuario logeado";
			
			return "sucess";
		} else { 
			/*
			session.setAttribute("errMessage", userValidate);
			request.setAttribute("msgResultado", "Hay un error en las credenciales, puedes intentar nuevamente"); 
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			*/
			return "error";
		}
	}
	
	public String cerrar(){
		this.usuario = null;
		return "ok";
	}
	
}
