/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Final_Fila_B;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SmartUrban2025
 */
public class Operaciones {
    
    private List<Proveedor> ListaProv;
    Scanner leer = new Scanner(System.in);

    public Operaciones() {
        ListaProv = new ArrayList<>();
    }

    public void CrearProv() {
        Proveedor prov = new Proveedor();
        System.out.print("Ingrese la razon social     :");
        prov.setRsocial(leer.nextLine());
        System.out.print("Ingrese la Direccion        :");
        prov.setDireccion(leer.nextLine());
        System.out.print("Ingrese el nro de Telefono  :");
        prov.setNrotelefono(leer.nextInt());
        System.out.println("");
        boolean seguir = true;
        do {
            System.out.println("            REGISTRAR PRODUCTOS         ");
            System.out.println("    1 Registrar Producto                ");
            System.out.println("    2 Salir del menu                    ");
            System.out.print("      Elija una opcion:   ");
            int x = leer.nextInt();
            leer.nextLine();
            System.out.println("");
            switch (x) {
                case 1:
                    Producto prod = new Producto();
                    System.out.print("Ingrese el nombre del producto      :");
                    prod.setNomprod(leer.nextLine());
                    System.out.print("Ingres costo unitario               :");
                    prod.setCostounit(leer.nextFloat());
                    System.out.print("Ingrese el stock                    :");
                    prod.setStock(leer.nextInt());
                    prov.getListaProd().add(prod);
                    System.out.println("");
                    break;
                    
                default:
                    seguir = false;
                    break;
            }
        } while (seguir);
        ListaProv.add(prov);
    }
    
    public void BuscarProv() {
        System.out.println("Ingrese el proveedor        :");
        String nombre = leer.nextLine();
        System.out.println("");
        if (ListaProv.isEmpty()) {
            System.out.println("            NO HAY PROVEEDORES REGISTRADOS!!!           ");
            System.out.println("");
        } else {
            Proveedor encontrado = searchByName(nombre);
            if (encontrado == null) {
                System.out.println("            EL PROVEEDOR NO SE ENCUENTRA REGISTRADO!!!          ");
                System.out.println("");
            } else {
                System.out.println("            LISTA PRODUCTOS         ");
                ListaProd(encontrado);
                System.out.println("");
            }
        }
    }

    public void ComprarProd() {
        System.out.println("Ingrese el producto que desea comprar       :");
        String cp = leer.nextLine();
        System.out.println("Ingrese las unidades que desea comprar      :");
        int n = leer.nextInt();
        if (BuscarProd(cp, n)) {
            System.out.println("            COMPRA REALIZADA CON EXITO...           ");
             System.out.println("");
        } else {
            System.out.println("            NO SE REALIZO LA COMPRA!!!          ");
            System.out.println("");
        }
    }

    public boolean BuscarProd(String nomprod, int x) {
        boolean seguir = false;
        find:
        for (Proveedor obj : ListaProv) {
            for (Producto pr : obj.getListaProd()) {
                if (pr.getNomprod().equalsIgnoreCase(nomprod)) {
                    if (x<=pr.getStock()) {
                        pr.setStock(pr.getStock() + x);
                         seguir = true;
                    }else{
                        System.out.println("            STOCK INSUFICIENTE!!!           ");
                        System.out.println("");
                    }
                    break find;
                }
            }
        }
        return seguir;
    }

    public Proveedor searchByName(String na) {
        Proveedor prove = null;
        for (Proveedor ob : ListaProv) {
            if (ob.getRsocial().equalsIgnoreCase(na)) {
                prove = ob;
                break;
            }
        }
        return prove;
    }

    public void ListaProd(Proveedor pro) {
        for (Producto produ : pro.getListaProd()) {
            System.out.println("Nombre del Producto     : " + produ.getNomprod());
            System.out.println("Costo Unitario          : " + produ.getCostounit());
            System.out.println("Stock                   : " + produ.getStock());
            System.out.println("");
        }

    }
    public void ListaProv(){
        System.out.println("            LISTA DE PROVEEDORES            ");
        ListaProv.forEach((n)->System.out.println("*"+n.getRsocial()));
        System.out.println("");
    }
    
    public void CrearArchivo() {
        Path path = Paths.get("C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoProveedor.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println("        ARCHIVO CREADO CON EXITO...     ");
                System.out.println("");
            } else {
                System.out.println("        EL ARCHIVO YA EXISTE...     ");
                System.out.println("");
            }
        } catch (Exception e) {
        }
    }

    public void AlmacenarDatos() {
        String location = "C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoProveedor.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(location);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(ListaProv);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);

        }
    }


    public void LeerDatos() {
        String location = "C:\\Users\\SmartUrban2025\\Desktop\\Trabajos INCOS\\2021\\Programacion III\\1er BIM\\ArchivoProveedor.txt";
        try {
            FileInputStream archivo = new FileInputStream(location);
            ObjectInputStream ois = new ObjectInputStream(archivo);
            if (ois != null) {
                ListaProv = (List<Proveedor>) ois.readObject();
            } else {
                System.out.println("            EL OBJETO ES NULO           ");
                System.out.println("");
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}