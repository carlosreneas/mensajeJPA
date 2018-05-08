package model;

import entities.Campana;
import util.Conexion;

public class CampanaDao 
	extends Conexion<Campana> 
	implements GenericDao<Campana>{

	public CampanaDao() {
		super(Campana.class);
	}
	
}
