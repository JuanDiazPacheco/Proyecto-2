package utils;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

import java.util.Set;

import models.perfiles.Cliente;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Archivador {

    public static Scanner sc = new Scanner(System.in);
    public static Set<String> numerosCuentas = new HashSet<>();
    public static HashMap<String, String> mapaPass = new HashMap<>();

    // Metodo para crear el archivo de un cliente

    public void escribirArchivoCliente(Cliente cliente) {
        try {
            FileWriter writer = new FileWriter(cliente.getNumeroCuenta() + ".txt");

            writer.write(cliente.toString());

            for (String operacion : cliente.getOperaciones()) {
                writer.write(operacion + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Un error ha ocurrido.");
            e.printStackTrace();
        }
    }

    public void updateMap(String numeroCuenta, String password) {
        mapaPass.put(numeroCuenta, password);
    }

    // Metodo para crear el archivo con los numeros de cuenta y sus contraseñas

    public void escribirArchivoClientes(String numeroCuenta, String password) {
        try {
            FileWriter writer = new FileWriter("Clientes.txt", true);
            writer.write(numeroCuenta + "," + password + "\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("Un error ha ocurrido.");
            e.printStackTrace();
        }
    }

    // Sobrecarga para cuando se desee cambiar un password, la diferencia recae en
    // que sobreescribe el archivo completo

    public void escribirArchivoClientes() {
        try {
            FileWriter writer = new FileWriter("Clientes.txt");

            for (Map.Entry<String, String> entry : mapaPass.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Un error ha ocurrido.");
            e.printStackTrace();
        }
    }

    // Metodo para crear un solo archivo Es posible que se elimine!!!, por no ser
    // necesario.

    private void crearArchivo() {
        try {
            File archivo = new File("clientes.txt");
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Un error ha ocurrido.");
        }
    }

    // METODOS CARGAR ARCHIVOS

    // Metodo para cargar el mapa de contraseñas y el set de numero de cuentas

    public boolean cargarCuentas() {
        boolean cargo = false;
        try {
            File archivo = new File("clientes.txt");
            if (archivo.exists()) {
                Scanner scanner = new Scanner(archivo);
                while (scanner.hasNextLine()) {
                    String[] arr = scanner.nextLine().split(",");
                    mapaPass.put(arr[0], arr[1]);
                    numerosCuentas.add(arr[0]);
                }
                scanner.close();
                cargo = true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. Creando el archivo...");
            crearArchivo();
        }
        return cargo;
    }

    // Metodo para cargar los datos de un cliente de un archivo
    // Intentar crear mejor objetos cuenta ahorro y asociarlo al cliente

    public Cliente cargarCliente(String numeroCuenta) {
        HashMap<String, String> mapaCliente = new HashMap<>();
        LinkedList<String> operaciones = new LinkedList<>();
        Cliente cliente;

        try {
            File archivo = new File(numeroCuenta + ".txt");
            Scanner scanner = new Scanner(archivo);

            for (int i = 0; i < 6; i++) {
                String[] arr = scanner.nextLine().split(":");
                mapaCliente.put(arr[0], arr[1]);
            }

            while (scanner.hasNextLine()) {
                operaciones.add(scanner.nextLine());
            }

            scanner.close();

            cliente = new Cliente(mapaCliente.get("Nombre"), mapaCliente.get("Direccion"),
                    mapaCliente.get("Nacimiento"), mapaCliente.get("Saldo Cuenta de Ahorros"),
                    mapaCliente.get("Numero Cuenta"));
            cliente.setOperaciones(operaciones);
            return cliente;

        } catch (FileNotFoundException e) {
            System.out.println("El archivo que se ha intentado abrir no existe.");
        }
        return null;
    }

}
