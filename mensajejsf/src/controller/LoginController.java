package controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import net.bootsfaces.utils.FacesMessages;

import entities.Usuario;
import model.UsuarioDao;


@ManagedBean
@SessionScoped
public class LoginController implements Serializable{
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	
	UsuarioDao usuarioDao = new UsuarioDao();
	
	//private String specificInfo = "Mensaje nuevo";
	
	
	
	public void specificInfo() {
		FacesMessages.info("loginForm:ref", "Info", "This is a specific message2!");
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
		 
		String userValidate = loginDao.validarUsuario(usuario); //Calling authenticateUser function

		if(userValidate.contentEquals("SUCCESS")) {
			/*
			session.setAttribute("userName", usuarioTxt); 
			request.setAttribute("msgResultado", "Usuario " + usuarioTxt + " bienvenido a la plataforma de mensajes"); 			
			request.getRequestDispatcher("/home.jsp").forward(request, response);
			*/
			FacesMessages.info("ref", "Info", "This is a specific message!");

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
	
}
