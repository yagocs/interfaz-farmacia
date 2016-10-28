import java.io.Serializable;
import java.util.Date;

public class Medicamentos implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public Medicamentos(String nombre, String lote, String laboratorio, Date caducidad, float precio, float iVA) {
		super();
		this.nombre = nombre;
		this.lote = lote;
		this.laboratorio = laboratorio;
		this.caducidad = caducidad;
		this.precio = precio;
		IVA = iVA;
	}

	String nombre;
	String lote;
	String laboratorio;
	Date caducidad;
	float precio;
	float IVA;



	public Medicamentos() {
		super();
	}


	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Date getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getIVA() {
		return IVA;
	}

	public void setIVA(float iVA) {
		IVA = iVA;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String toString() {
		return "Medicamentos [nombre=" + nombre + ", lote=" + lote + ", laboratorio=" + laboratorio + ", caducidad: "
				+ caducidad.getDay()+"/"+caducidad.getMonth()+"/"+caducidad.getYear() + ", precio=" + precio + ", IVA=" + IVA + "]";
	}

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

}
