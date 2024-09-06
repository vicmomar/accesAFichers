package org.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {

        menuEjemplos();
        ejemplo1();
        ejemplo2();
        ejemplo3();
        //System.out.println("Hello world!");


    }

    private static void menuEjemplos() {
        //Scanner scn = new Scanner(System.in);
        String opcion = "";
        do {
            System.out.print("Elige una opción:\n\t1- Ejemplo 1\n\t2- Diferencia entre:\n\t\t-listRoots()\n\t\t-listFiles()\n\t\t-list()" +
                    "\n\t3- Visualizar sistema de archivos  directorio actual" +
                    "\n\t0- Salir\n==> ");
            opcion = scn.nextLine();
            switch (opcion) {
                case "1":
                    ejemplo1();
                    break;
                case "2":
                    ejemplo2();
                    break;
                case "3":
                    ejemplo3();
                    break;
                case "0":
                    System.out.println("Bye bye.\nNice to see you");
                    break;
                default:
                    System.err.println("Wrong option, try again");
            }
        } while (!opcion.equals("0"));

    }

    private static void ejemplo3() {
        System.out.println("\n>>>   EJEMPLO3: Visualizar el sistema de archivos teniendo en cuenta el directorio actual '.'");
        System.out.println("String dir = \".\";\nFile f = new File(dir);\n" +
                "String[] archivos = f.list();\n" +
                "System.out.printf(\"Ficheros en el directorio actual: %d %n\", archivos.length);\n" +
                "for (int i=0; i<archivos.length; i++) {\n" +
                "   File f2 = new File(f, archivos[i]);\n" +
                "   System.out.printf(\"Nombre: %s, es fichero?: %b, es Directorio?: %b %n\", archivos[i], f2.isFile(), f2.isDirectory());\n" +
                "}");

        String dir = ".";
        File f = new File(dir);
        String[] archivos = f.list();
        System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
        for (int i=0; i<archivos.length; i++) {
            File f2 = new File(f, archivos[i]);
            System.out.printf("Nombre: %s, es fichero?: %b, es Directorio?: %b %n", archivos[i], f2.isFile(), f2.isDirectory());
        }

    }

    private static void ejemplo2() {
        System.out.println("\n>>>   EJEMPLO 2: Mostrar el directorio raíz, todas las unidades del disco y todos los archivos del directorio raíz.\n" +
                "Diferencia que hay entre los siguiente métodos:\n" +
                "\tlistRoots(): muestra las diferentes unidades de disco del Sistema Operativo.\n" +
                "\tlistFiles(): devuelve un ArrayList con los diferentes objetos de tipo File que contiene el\n" +
                "\t\tobjeto File seleccionado, con lo cual luego se pueden aplicar propiedades y métodos a cada uno de ellos.\n" +
                "\tlist(): devuelve el nombre de las carpetas o archivos que contiene el objeto de tipo File seleccionado.\n");

        String directorioRaiz = File.listRoots()[0].toString();
        File[] paths = File.listRoots();
        File direcC = new File("C:/");

        System.out.println("=================================================");
        System.out.println("String directorioRaiz = File.listRoots()[0].toString();");
        System.out.println(">>>>> Directorio raíz: " +directorioRaiz+ " <<<<<");

        System.out.println("=================================================");
        System.out.println("File[] paths = File.listRoots();");
        System.out.println("for (File fichero : paths) {");
        System.out.println("\tSystem.out.println(\"\\t\" +fichero.toString())\n}");
        System.out.println("Unidades de disco:");
        for (File fichero : paths) {
            System.out.println("\t" +fichero.toString());
        }

        System.out.println("=================================================");
        System.out.println("File direcC = new File(\"C:/\");");
        System.out.println("for (File fichero : direcC.listFiles()) {");
        System.out.println("\tSystem.out.println(\"\\t\" +fichero+(fichero.isFile() ? \" -fichero\" : \" +directorio));\"\n}");

        System.out.println("Los archivos y/o carpetas que contiene " +direcC);
        for (File fichero : direcC.listFiles()) {
            System.out.println("\t" +fichero+(fichero.isFile() ? " -fichero" : " -directorio"));
        }

        System.out.println("=================================================");
        System.out.println("File direcC = new File(\"C:/\");");
        System.out.println("for (String fichero : direcC.list()) {");
        System.out.println("\tSystem.out.println(\"\\t\" +fichero)\n}");

        System.out.println("Los nombres de los archivos y/o carpetas que contiene " +direcC);
        for (String fichero : direcC.list()) {
            System.out.println("\t" +fichero);
        }


    }

    private static void ejemplo1() {

        System.out.println("File f = new File(\"./src/main/resources/file.txt\");\n" +
                "        if (f.exists()) {\n" +
                "            System.out.println(\"El fichero existe!!!!!!!\");\n" +
                "        } else {\n" +
                "            System.err.println(\"El fichero NO existe!!!!!!!!\");\n" +
                "        }\n" +
                "        System.out.println(\"getName(): \" +f.getName());\n" +
                "        System.out.println(\"getParent(): \" +f.getParent());\n" +
                "        System.out.println(\"length(): \" +f.length());");
        File f = new File("./src/main/resources/file.txt");
        if (f.exists()) {
            System.out.println("El fichero existe!!!!!!!");
        } else {
            System.err.println("El fichero NO existe!!!!!!!!");
        }
        System.out.println("getName(): " +f.getName());
        System.out.println("getParent(): " +f.getParent());
        System.out.println("length(): " +f.length());
    }
}