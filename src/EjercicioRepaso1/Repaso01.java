/*Codificar un programa que cree el fichero de objetos Empleados.DAT,
Los datos a almacenar serán Nombre que tendrá una longitud máxima de 30
caracteres, Número de la Seguridad Social, longitud máxima de 10, Sexo
estará codificado H- Hombres, M – Mujeres y Salario.
El programa deberá:
1. Dar altas, modificaciones y consultas por el número de la seguridad
Social.
2. Se imprimirá toda la lista de empleados.
3. Listado según el Sexo.*/

package EjercicioRepaso1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Repaso01 {

	public static void main(final String[] args) {
		File f = new File("empleados.dat");

		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		switch (opcion) {

		case 1:

			alta(f);

			break;

		case 2:
			modificar();

			break;

		case 3:
			consultarSS();
			break;

		case 4:
			listarcompleto();

			break;
		case 5:
			listarcompleto();

			break;

		default:
			break;
		}

	}

	private static void listarcompleto() {
		// TODO Auto-generated method stub

	}

	private static void consultarSS() {
		// TODO Auto-generated method stub

	}

	private static void modificar() {
		// TODO Auto-generated method stub

	}

	private static void alta(File f) {

		FileOutputStream fo = null;
		ObjectOutputStream oo = null;
		Scanner scn = new Scanner(System.in);
		try {
			fo = new FileOutputStream(f);
			oo = new ObjectOutputStream(fo);

			// creo los objetos a escribir
			System.out.println("Introduzca el numero de SS");
			String SS = scn.next();
			System.out.println("Introduzca el nombre");
			String nombre = scn.next();
			System.out.println("Introduzca el Salario");
			int telefono = scn.nextInt();
			if (compruebaSS(f, SS))
				System.out.println("DNI DUPLICADO");
			else {
				Repaso01Empleado p = new Repaso01Empleado(SS, nombre, false, telefono);

				System.out.println("Escribiendo registros. Espere");
				// escribimos en el fichero
				oo.writeObject(p);
			}

		} catch (FileNotFoundException fn) {
			System.out.println("Error. Fichero no existe");
		} catch (IOException io) {
			System.out.println("Error de escritura");
		} finally {
			try {
				if (fo != null) {
					fo.close();
					oo.close();
				}
			} catch (IOException io) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		scn.close();
	}// fin metodo escrituraObjetosNuevo

	static void escrituraObjetosExiste(File f) {
		FileOutputStream fo = null;
		MiObjectOutputStream mo = null;

		Scanner scn = new Scanner(System.in);
		try {
			fo = new FileOutputStream(f, true);
			mo = new MiObjectOutputStream(fo);
			String nombre = "";
			boolean sexo;
			String SS = null;
			float salario = 0;
			System.out.println("Introduzca el numero de SS");
			String DNI = scn.next();
			if (compruebaSS(f, SS) == true) {
				System.out.println("Numero DUPLICADO");
			} else {
				System.out.println("Introduzca el nombre");
				nombre = scn.next();
				System.out.println("Introduzca el salario");
				salario = scn.nextInt();
				Repaso01Empleado p = new Repaso01Empleado(SS, nombre, false, salario);

				System.out.println("Escribiendo registros. Espere");
				// escribimos en el fichero
				mo.writeObject(p);
			}

		} catch (FileNotFoundException fn) {
			System.out.println("Error. Fichero no existe");
		} catch (IOException io) {
			System.out.println("Error de escritura");
		} finally {
			try {
				if (fo != null) {
					fo.close();
					mo.close();
				}
			} catch (IOException io) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		scn.close();
	}// fin metodo escrituraObjetosExiste

	static void lecturaObjetos(File f) {
		FileInputStream fi = null;
		ObjectInputStream oi = null;

		try {
			fi = new FileInputStream(f);
			oi = new ObjectInputStream(fi);

			while (true) {
				// creo el objeto donde voy a guardar los datos leidos del disco
				Repaso01Empleado p1 = (Repaso01Empleado) oi.readObject();
				System.out.println(p1);
			}

		} catch (ClassNotFoundException cn) {
			System.out.println("Error en la clase alumnos");
		} catch (FileNotFoundException fn) {
			System.out.println("Error. Fichero no existe");
		} catch (EOFException eof) {
			System.out.println("Fin del la lectura");
		} catch (IOException io) {
			System.out.println("Error de lectura");
		} finally {
			try {
				if (fi != null) {
					fi.close();
					oi.close();
				}
			} catch (IOException io) {
				System.out.println("Error al cerrar el fichero");
			}
		}
	}// fin metod0 lecturaObjetos

	@SuppressWarnings("resource")
	static boolean compruebaSS(File f, String SS) {
		FileInputStream fi = null;
		ObjectInputStream oi = null;
		String d2 = SS;
		try {
			fi = new FileInputStream(f);
			oi = new ObjectInputStream(fi);

			while (true) {
				// creo el objeto donde voy a guardar los datos leidos del disco
				Repaso01Empleado p1 = (Repaso01Empleado) oi.readObject();
				String d1 = p1.getSS();
				if (d1.equals(d2)) {
					System.out.println(p1);
					return true;
				}

			}

		} catch (ClassNotFoundException cn) {
			System.out.println("Error en la clase personas");
		} catch (FileNotFoundException fn) {
			System.out.println("Error. Fichero no existe");
		} catch (EOFException eof) {
			System.out.println("Fin del la lectura");
		} catch (IOException io) {
			System.out.println("Error de lectura");
		} finally {
			try {
				if (fi != null) {
					fi.close();
					oi.close();
				}
			} catch (IOException io) {
				System.out.println("Error al cerrar el fichero");
			}
		}
		return false;
	}

	}

	


