package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Contacto;
import entities.Usuario;
import model.ContactoDao;
import model.UsuarioDao;

/**
 * Servlet implementation class ContactoController
 */
@WebServlet("/ContactoController")
public class ContactoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idTxt = request.getParameter("id");
		if(request.getParameter("ed").contentEquals("1")){
			ContactoDao cDao = new ContactoDao();
			Contacto c = cDao.find(Integer.parseInt(idTxt));
			request.setAttribute("contacto", c); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
			
			request.getRequestDispatcher("/contactoedit.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
			
		}else if(request.getParameter("ed").contentEquals("2")){
			ContactoDao cDao = new ContactoDao();
			Contacto c = cDao.find(Integer.parseInt(idTxt));
			if(c!=null){
				cDao.delete(c);
				request.setAttribute("msgResultado", "El contacto se ha eliminado correctamente"); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
				request.getRequestDispatcher("/contacto.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
			}
		}
		
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Contacto contactoreq = (Contacto) request.getAttribute("contacto");
		
		String op = request.getParameter("ed");
		Integer id = 0;
		if (op!=null) {
			id = Integer.parseInt(op);
		}

		
		HttpSession session = request.getSession(true);
		
		String nombreTxt = request.getParameter("nombre");
		String apellidoTxt = request.getParameter("apellido");
		String emailTxt = request.getParameter("email");
		
		String usuarioSession = (String) session.getAttribute("userName");
		UsuarioDao uDao = new UsuarioDao();
		Usuario usuarioBean = uDao.find(usuarioSession);
		
		ContactoDao cDao = new ContactoDao();
		 
		if(id>0){
			Contacto contacto = cDao.find(id);
		
			contacto.setEmail(emailTxt);
			contacto.setNombre(nombreTxt);
			contacto.setApellido(apellidoTxt);
	
			cDao.update(contacto);
			
			request.setAttribute("msgResultado", "El contacto se ha actualizado correctamente"); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
		}else{
		
			Contacto contacto = new Contacto();
			
			contacto.setEmail(emailTxt);
			contacto.setNombre(nombreTxt);
			contacto.setApellido(apellidoTxt);
			contacto.setUsuarioBean(usuarioBean);
	
			cDao.insert(contacto);
			
			request.setAttribute("msgResultado", "El contacto se ha registrado correctamente"); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
		
		}
		request.getRequestDispatcher("/contacto.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
		
		
		
	}

}
