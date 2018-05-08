package model;

import entities.Mensaje;
import util.Conexion;

public class MensajeDao 
	extends Conexion<Mensaje> 
	implements GenericDao<Mensaje>{

	public MensajeDao() {
		super(Mensaje.class);
		// TODO Auto-generated constructor stub
	}
	
}
