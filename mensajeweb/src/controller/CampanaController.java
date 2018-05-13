package controller;

import java.io.IOException;
import java.util.Date;

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
import process.Email;

/**
 * Servlet implementation class CampanaController
 */
@WebServlet("/CampanaController")
public class CampanaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CampanaController() {
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
			CampanaDao cDao = new CampanaDao();
			Campana c = cDao.find(Integer.parseInt(idTxt));
			request.setAttribute("campana", c); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
			
			request.getRequestDispatcher("/campanaedit.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
		
		}else if(request.getParameter("ed").contentEquals("2")){
			CampanaDao cDao = new CampanaDao();
			Campana c = cDao.find(Integer.parseInt(idTxt));
			if(c!=null){
				cDao.delete(c);
				request.setAttribute("msgResultado", "La campaña se ha eliminado correctamente"); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
				request.getRequestDispatcher("/campana.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
			}
		}else if(request.getParameter("ed").contentEquals("3")){
			CampanaDao cDao = new CampanaDao();
			
			Campana c = cDao.find(Integer.parseInt(idTxt));
			Integer msgCant = 0;
			
			Email.EnviarCampana(c);
			
			request.setAttribute("msgResultado", "La campaña de envío masivo ha comenzado "); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
			request.getRequestDispatcher("/campana.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.
			  
			//
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		String nombreTxt = request.getParameter("nombre");
		String descripcionTxt = request.getParameter("descripcion");
		String plantillaTxt = request.getParameter("plantilla");
		 
		Campana campana = new Campana();
		
		campana.setDescripcion(descripcionTxt);
		campana.setNombre(nombreTxt);
		campana.setPlantilla(plantillaTxt);
		
		String usuarioSession = (String) session.getAttribute("userName");
		UsuarioDao uDao = new UsuarioDao();
		Usuario usuarioBean = uDao.find(usuarioSession);
		
		campana.setUsuarioBean(usuarioBean);
		
		CampanaDao cDao = new CampanaDao();
		cDao.insert(campana);
		
		request.setAttribute("msgResultado", "La campaña ha sido creada correctamente"); //with setAttribute() you can define a "key" and value pair so that you can get it in future using getAttribute("key")
		request.getRequestDispatcher("/campana.jsp").forward(request, response);//RequestDispatcher is used to send the control to the invoked page.

	}

}
