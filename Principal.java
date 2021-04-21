/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen_Final_Fila_B;

import java.util.Scanner;

/**
 *
 * @author SmartUrban2025
 */
public class Principal {
    public static void main(String[] args) {
        boolean seguir = true;
        int x = 0;
        Scanner leer = new Scanner(System.in);
        Operaciones o = new Operaciones();
        do {
            System.out.println("            MENU DE OPCIONES            ");
            System.out.println("    1. Crear archivo                    ");
            System.out.println("    2. Registrar proveedor y producto/s ");
            System.out.println("    3. Listar productos de un proveedor ");
            System.out.println("    4. Realizar la compra de producto   ");
            System.out.println("    5. Listar Proveedores               ");
            System.out.println("    6. Cerrar el Programa               ");
            System.out.print("      Digite una opcion:          ");
            x = leer.nextInt();
            System.out.println("");
            switch (x) {
                case 1:
                    o.CrearArchivo();
                    break;
                case 2:
                    o.LeerDatos();
                    o.CrearProv();
                    o.AlmacenarDatos();
                    break;
                case 3:
                    o.LeerDatos();
                    o.BuscarProv();
                    break;
                case 4:
                    o.LeerDatos();
                    o.ComprarProd();
                    o.AlmacenarDatos();
                    break;
                case 5:
                   o.LeerDatos();
                   o.ListaProv();
                    break;
                
                default:
                    seguir = false;
                    break;
            }
        } while (seguir);
    }  
}