//Realizar un programa Java que muestre los ficheros de un directorio. El nombre del directorio
//se pasará al programa desde el teclado al ejecutarlo.

package EjerciciosTema1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FicherosDirectorio01 {
	public static void main(final String[] args) throws IOException {

		System.out.println("Introduzca la ruta del fichero");
		Scanner reader = new Scanner(System.in);
		String a = reader.next();
		File f = new File(a);

		String[] b = f.list();

		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);

		}
		reader.close();
	}

}
