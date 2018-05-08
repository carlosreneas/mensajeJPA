package model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.Conexion;
import entities.Campana;
import entities.Contacto;

public class ContactoDao 
	extends Conexion<Contacto> 
	implements GenericDao<Contacto>{
	
	public ContactoDao() {
		super(Contacto.class);
	}


}
