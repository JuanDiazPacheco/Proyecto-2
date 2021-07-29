package utils.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import models.productos.Producto;
import models.productos.ProductoFactory;

public class ProductosFiles {

    private static ProductosFiles pFiles;

    private ProductosFiles() {

    }

    public static ProductosFiles getInstance() {
        if (pFiles == null) {
            pFiles = new ProductosFiles();
        }
        return pFiles;
    }

    public List<Producto> cargar(String departamento) {
        List<Producto> list = new LinkedList<>();

        String atributos[] = {};

        File file = new File("./Departamentos/" + departamento + ".txt");
        Scanner scanner;

        if (file.exists()) {
            try {
                scanner = new Scanner(file);
                // scanner.useDelimiter(",");

                if (scanner.hasNext())
                    scanner.nextLine().split(",");

                while (scanner.hasNext()) {
                    atributos = scanner.nextLine().split(",");
                    Producto nuevo = ProductoFactory.nuevoProducto(departamento, atributos);
                    if (nuevo != null)
                        list.add(nuevo);
                }

                scanner.close();
            } catch (IOException e) {
                System.out.println("Error " + e.getMessage());
            }
        }

        return list;
    }

    public void escribir(Producto producto) {
        File file;
        FileWriter fWriter;
        String departamento = producto.getDepartamento();

        file = new File("./Departamentos/" + departamento + ".txt");

        if (!file.exists())
            nuevoDepartamento(file, departamento);

        try {
            fWriter = new FileWriter(file, true);
            fWriter.write(producto.toString() + "\n");
            fWriter.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }

    }

    private void nuevoDepartamento(File file, String departamento) {
        try {
            file.createNewFile();
            FileWriter fWriter = new FileWriter(file);

            fWriter.write("Departamento:" + departamento + "\n");
            fWriter.write(String.join(",", "nombre", "precio", "marca", "imagen", "sDepartamento") + "\n");
            fWriter.close();
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

}
