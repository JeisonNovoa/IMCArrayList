 	import java.util.Arrays;

import javax.swing.JOptionPane;

public class Proceso {
	public void iniciar() {
		int valid;
		do {
			valid = Integer.parseInt(JOptionPane.showInputDialog(null, "Programa para calcular IMC\n"
					+ "\n1) Ingresar usuario"
					+ "\n2) Imprimir datos"
					+ "\n3) Consulta individual"
					+ "\n4) Salir"
					+ "\nIngrese una opcion:"));
			switch(valid) {
				case 1:
					getData();
					break;
				case 2:
					if(nombres.length == 0) {
						JOptionPane.showMessageDialog(null, "No hay datos registrados aun", "ALERTA", JOptionPane.WARNING_MESSAGE);
						break;
					}
					IMC();
					printData();
					break;
				case 3:
					if(nombres.length == 0) {
						JOptionPane.showMessageDialog(null, "No hay datos registrados aun", "ALERTA", JOptionPane.WARNING_MESSAGE);
						break;
					}
					IMC();
					searchName();
					break;
				case 4:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Ingrese una opcion correcta", "ALERTA", JOptionPane.WARNING_MESSAGE);
			}
		}while(valid != 4);
	}
	int cant = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de pacientes" ));
	String[] nombres = new String[cant];
	double[] pesos = new double[cant];
	double[] alturas = new double[cant];
	double[] imcs = new double[cant];
	String[] telefonos = new String[cant];	
	
	public void getData(){
		String nombre, telefono;
		double peso, altura;
		for (int i = 0; i < cant; i++) {
			nombre = JOptionPane.showInputDialog(null, "ingresar nombre del usuario numero " + (i +1));
			nombres[i] = nombre;
			telefono = JOptionPane.showInputDialog(null, nombre + " ingrese numero de telefono el usuario numero " + (i+1));
			telefonos[i] = telefono;
			peso = Double.parseDouble(JOptionPane.showInputDialog(null, nombre + " ingrese peso en kg del usuario numero "+(i+1)));
			pesos[i] = peso;
			altura = Double.parseDouble(JOptionPane.showInputDialog(null, nombre + " ingrese altura en metros del usuario numero "+(i+1)));
			alturas[i] = altura;
		}
	}
	
	public void IMC() {
		for (int i = 0; i < cant; i++) {
			imcs[i] = pesos[i] / (alturas[i] * alturas[i]);
		}
	}
	
	public void printData() {
		for (int i = 0; i < cant; i++) {
			System.out.println(status(i)); 
		}
	}
		
	public void searchName() {
		String name = JOptionPane.showInputDialog("Ingrese nombre que desea buscar");
		if(!(Arrays.asList(nombres).contains(name))) {
			JOptionPane.showMessageDialog(null, "No se encontro un usario con dicho nombre", "ALERTA", JOptionPane.WARNING_MESSAGE);
		}else {
			for (int i = 0; i < cant; i++) {
				if (nombres[i].equals(name)) {
					System.out.println(status(i));
				}
			}
			
		}
		
	}	
	
	public String status(int i) {
		if(imcs[i] < 18.0) return mensaje(i) + "\nEstado: Anorexia\n\n";
		
		else if(imcs[i] < 20.0) return mensaje(i) + "\nEstado: Delgadez\n\n";
		
		else if(imcs[i] < 27.0) return mensaje(i) + "\nEstado: Normalidad\n\n";
		
		else if(imcs[i] < 30.0) return mensaje(i) + "\nEstado: Obesidad(grado1)\n\n";
		
		else if(imcs[i] < 35.0) return mensaje(i) + "\nEstado: Obesidad(grado2)\n\n";
		
		else if(imcs[i] < 40.0) return mensaje(i) + "\nEstado: Obesidad(grado3)\n\n";
		
		else return mensaje(i) + "\nEstado: Obesidad Morbida\n\n";
	}
	
	public String mensaje(int i) {
		return "usuario: "
			+ (i+1) 
			+") Nombre:" + nombres[i] 
			+ "\nTelefono: " + telefonos[i];
	}
}

