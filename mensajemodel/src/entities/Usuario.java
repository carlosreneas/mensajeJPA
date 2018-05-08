package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String usuario;

	private String clave;

	private String email;

	private String nombre;

	//bi-directional many-to-one association to Campana
	@OneToMany(mappedBy="usuarioBean")
	private List<Campana> campanas;

	//bi-directional many-to-one association to Contacto
	@OneToMany(mappedBy="usuarioBean")
	private List<Contacto> contactos;

	//bi-directional many-to-many association to Rol
	@ManyToMany(mappedBy="usuarios")
	private List<Rol> rols;

	public Usuario() {
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Campana> getCampanas() {
		return this.campanas;
	}

	public void setCampanas(List<Campana> campanas) {
		this.campanas = campanas;
	}

	public Campana addCampana(Campana campana) {
		getCampanas().add(campana);
		campana.setUsuarioBean(this);

		return campana;
	}

	public Campana removeCampana(Campana campana) {
		getCampanas().remove(campana);
		campana.setUsuarioBean(null);

		return campana;
	}

	public List<Contacto> getContactos() {
		return this.contactos;
	}

	public void setContactos(List<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Contacto addContacto(Contacto contacto) {
		getContactos().add(contacto);
		contacto.setUsuarioBean(this);

		return contacto;
	}

	public Contacto removeContacto(Contacto contacto) {
		getContactos().remove(contacto);
		contacto.setUsuarioBean(null);

		return contacto;
	}

	public List<Rol> getRols() {
		return this.rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

}