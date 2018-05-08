package model;

import entities.Rol;
import util.Conexion;

public class RolDao 
	extends Conexion<Rol> 
	implements GenericDao<Rol> {

	public RolDao() {
		super(Rol.class);
		// TODO Auto-generated constructor stub
	}

}
