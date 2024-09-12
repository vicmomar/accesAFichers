package org.example;

import java.io.*;
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
                    "\n\t3- Visualizar sistema de archivos  directorio actual\n\t4- Abrir un fichero de texto para escribir una frase" +
                    "\n\t4- Leer ficheros de texto plano" +
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
                case "4":
                    ejemplo4();
                    break;
                case "5":
                    ejemplo5();
                    break;
                case "0":
                    System.out.println("Bye bye.\nNice to see you");
                    break;
                default:
                    System.err.println("Wrong option, try again");
            }
        } while (!opcion.equals("0"));

    }

    private static void ejemplo5() {
        System.out.println("Ejemplo 5: La clase FileReader permite procesar ficheros de texto. Algunos de sus métodos:\n" +
                "       - int read() → lee un caracter y lo devuelve. Si llega al final del fichero devuelve -1.\n" +
                "       - String readLine() → lee una línea y la devuelve. Si llega al final del fichero devuelve null.\n");

        System.out.println("File fichero = null;\n        \n" +
                "        try {\n            fichero =  new File(\"./src/main/resources/archivoEjemplo5.txt\");\n" +
                "            br = new BufferedReader(new FileReader(fichero));\n" +
                "            String linea = null;\n            while ((linea = br.readLine()) != null) {\n" +
                "                System.out.println(linea);\n            }\n        } catch (FileNotFoundException e) {\n" +
                "            e.printStackTrace();\n        } finally {\n            if (br != null) {\n" +
                "                try {\n                    br.close();\n                } catch (IOException e) {\n" +
                "                    e.printStackTrace();\n                }\n            }\n        }");


        //File fichero = null;
        BufferedReader br = null;

        try {
            File fichero =  new File("./src/main/resources/archivoEjemplo4.txt");
            br = new BufferedReader(new FileReader(fichero));
            String linea = null;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void ejemplo4() {
        System.out.println("\n>>>   EJEMPLO 4: Abrir un fichero de texto para escribir una frase.");
        System.out.println("FileWriter fw = null;\n" +
                "        PrintWriter pw = null;\n" +
                "        try {\n" +
                "            fw = new FileWriter(\"./src/main/resources/archivoEjemplo4.txt\");\n" +
                "            pw = new PrintWriter(fw);\n" +
                "            pw.println(\"This is a line of the file\");\n" +
                "        } catch (IOException e) {\n" +
                "            e.printStackTrace();\n" +
                "        } finally {\n" +
                "            if (fw != null){\n" +
                "                try {\n" +
                "                    fw.close();\n" +
                "                } catch (IOException e) {\n" +
                "                    e.printStackTrace();\n" +
                "                }\n" +
                "            }\n" +
                "        }");
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("./src/main/resources/archivoEjemplo4.txt",true);
            pw = new PrintWriter(fw);
            pw.println("This is a line of the file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void ejemplo3() {
        System.out.println("\n>>>   EJEMPLO 3: Visualizar el sistema de archivos teniendo en cuenta el directorio actual '.'");
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