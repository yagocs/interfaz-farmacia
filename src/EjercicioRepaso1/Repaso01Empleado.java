package EjercicioRepaso1;

import java.io.Serializable;

public class Repaso01Empleado implements Serializable {

	public Repaso01Empleado() {
		super();
	}

	public Repaso01Empleado(String nombre, String SS, boolean sexo, float salario) {
		super();
		this.nombre = nombre;
		this.SS = SS;
		this.sexo = sexo;
		this.salario = salario;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String SS;
	private boolean sexo;
	private float salario;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSS() {
		return SS;
	}

	public void setSS(String sS) {
		SS = sS;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Repaso01Empleado [nombre=" + nombre + ", SS=" + SS + ", sexo=" + sexo + ", salario=" + salario + "]";
	}

}
