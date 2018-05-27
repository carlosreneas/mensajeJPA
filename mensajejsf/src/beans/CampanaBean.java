package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Campana;
import model.CampanaDao;

@ManagedBean
@SessionScoped
public class CampanaBean {
	Campana campana = new Campana();
	
	List<Campana> campanas = new ArrayList<Campana>();
	
	CampanaDao cDao = new CampanaDao();

	public Campana getCampana() {
		return campana;
	}

	public void setCampana(Campana campana) {
		this.campana = campana;
	}

	public List<Campana> getCampanas() {
		return cDao.list();
	}

	public void setCampanas(List<Campana> campanas) {
		this.campanas = campanas;
	}
	
	
}
