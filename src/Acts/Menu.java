package Acts;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {

	private static ArrayList<Producto> inventario = new ArrayList<>();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;
		do {
			mostrarmenu();
			try {
				opcion = obtenerEntero("Ingrese una opcion");
				switch (opcion) {
				case 1:
					agregarProducto();
					break;
				case 2:
					buscarProdcuto();
					break;
				case 3:
					modificarProdcuto();
					break;
				case 4:
					eliminarProducto();
					break;
				case 5:
					mostrarProductos();
					break;
				case 6:
					System.out.println("Saliendo del menu...");
					break;
				default:
					System.out.println("Opcion no valida, intentelo de nuevo");

				}
			} catch (NumberFormatException e) {
				System.err.println("ERROR. Debe ingresar un numero valido");
			}
		} while (opcion != 6);
	}

	private static void mostrarmenu() {
		System.out.println("-----Elija una de las opciones-----");
		System.out.println("1. Agregar producto");
		System.out.println("2. Buscar producto");
		System.out.println("3. Modificar producto");
		System.out.println("4. Eliminar producto");
		System.out.println("5. Mostrar productos");
		System.out.println("6. Salir del programa");
	}

	private static int obtenerEntero(String mensaje) throws NumberFormatException {
		System.out.println(mensaje);
		String entrada = sc.nextLine();
		try {
			return Integer.parseInt(entrada);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Ingrese una opcion valida");
		}
	}
	
	private static boolean validarPrecio(String precio) {
		return Pattern.matches("\\d+(\\d.\\d{1,2})?", precio);
	}
    private static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        String precio;
        do {
            System.out.print("Ingrese el precio del producto (n�mero con hasta 2 decimales): ");
            precio = sc.nextLine();
        } while (!validarPrecio(precio));

        inventario.add(new Producto(nombre, Double.parseDouble(precio)));
        System.out.println("Producto agregado exitosamente.");
    }
}
