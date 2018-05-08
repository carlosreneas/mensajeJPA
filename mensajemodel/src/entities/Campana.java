package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the campana database table.
 * 
 */
@Entity
@NamedQuery(name="Campana.findAll", query="SELECT c FROM Campana c")
public class Campana implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	private String nombre;

	private int plantilla;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuarioBean;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="campanaBean")
	private List<Mensaje> mensajes;

	public Campana() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPlantilla() {
		return this.plantilla;
	}

	public void setPlantilla(int plantilla) {
		this.plantilla = plantilla;
	}

	public Usuario getUsuarioBean() {
		return this.usuarioBean;
	}

	public void setUsuarioBean(Usuario usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

	public List<Mensaje> getMensajes() {
		return this.mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Mensaje addMensaje(Mensaje mensaje) {
		getMensajes().add(mensaje);
		mensaje.setCampanaBean(this);

		return mensaje;
	}

	public Mensaje removeMensaje(Mensaje mensaje) {
		getMensajes().remove(mensaje);
		mensaje.setCampanaBean(null);

		return mensaje;
	}

}