package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Campana;
import entities.Contacto;
import entities.Mensaje;
import entities.Usuario;
import model.CampanaDao;
import model.ContactoDao;
import model.MensajeDao;
import model.UsuarioDao;

/**
 * Servlet implementation class MensajeController
 */
@WebServlet("/MensajeController")
public class MensajeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MensajeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);
		
		String campanaTxt = request.getParameter("campana");
		String contactoTxt = request.getParameter("contacto");
		 
		Mensaje mensaje = new Mensaje();
		
		String usuarioSession = (String) session.getAttribute("userName");
		UsuarioDao uDao = new UsuarioDao();
		Usuario usuarioBean = uDao.find(usuarioSession);
		
		
		
		CampanaDao cDao = new CampanaDao();
		Campana campanaBean = cDao.find(Integer.parseInt(campanaTxt));
		
		mensaje.setCampanaBean(campanaBean);
		
		ContactoDao oDao = new ContactoDao();
		Contacto contactoBean = oDao.find(Integer.parseInt(contactoTxt));
		
		mensaje.setContactoBean(contactoBean);
		
		mensaje.setEmail(contactoBean.getEmail());
		
		MensajeDao mDao = new MensajeDao();
		mDao.insert(mensaje);
		
		   
		request.setAttribute("msgResultado", "El mensaje ha sido creado correctamente"); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
		request.getRequestDispatcher("/mensaje.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.

	}

}
