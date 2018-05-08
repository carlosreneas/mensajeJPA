package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mensaje database table.
 * 
 */
@Entity
@NamedQuery(name="Mensaje.findAll", query="SELECT m FROM Mensaje m")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int contacto;

	private String email;

	@Temporal(TemporalType.DATE)
	private Date fechaapertura;

	@Temporal(TemporalType.DATE)
	private Date fechaenvio;

	private String ip;

	private String navegador;

	//bi-directional many-to-one association to Campana
	@ManyToOne
	@JoinColumn(name="campana")
	private Campana campanaBean;

	public Mensaje() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getContacto() {
		return this.contacto;
	}

	public void setContacto(int contacto) {
		this.contacto = contacto;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaapertura() {
		return this.fechaapertura;
	}

	public void setFechaapertura(Date fechaapertura) {
		this.fechaapertura = fechaapertura;
	}

	public Date getFechaenvio() {
		return this.fechaenvio;
	}

	public void setFechaenvio(Date fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNavegador() {
		return this.navegador;
	}

	public void setNavegador(String navegador) {
		this.navegador = navegador;
	}

	public Campana getCampanaBean() {
		return this.campanaBean;
	}

	public void setCampanaBean(Campana campanaBean) {
		this.campanaBean = campanaBean;
	}

}