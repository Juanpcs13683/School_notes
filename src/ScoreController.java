import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreController {
    Scanner sc = null;
    File archivo = null;
    //creamos una instancia para poder  usar la clase y sus metodos
    Materia materia = new Materia();
    ArrayList<Materia> lista_notas = new ArrayList<>();
    String nombreMateria = "";
    ArrayList<String> lista_nombres = new ArrayList<>();

    //lista de nombres


    //metodo que crea las notas
    public void nota(String nombreMAteria){
        try {
            File creador = new File("src/Notas/" + nombreMateria + ".csv");
            PrintWriter escritor = new PrintWriter(creador);
            escritor.println("Nombre,Materia,Nota1,Nota2,Nota3,Nota4,Definitiva");
            for (String estudiante : lista_nombres) {
                JOptionPane.showMessageDialog(null, "Crear Nota\n" +
                        "Por favor ingrese los datos a continuacion");

                String nota1 = JOptionPane.showInputDialog(null, "Estudiante: " + estudiante + "\n" + "Nota 1");
                String nota2 = JOptionPane.showInputDialog(null, "Estudiante: " + estudiante + "\n" + "Nota 2");
                String nota3 = JOptionPane.showInputDialog(null, "Estudiante: " + estudiante + "\n" + "Nota 3");
                String nota4 = JOptionPane.showInputDialog(null, "Estudiante: " + estudiante + "\n" + "Nota 4");
                String definitiva = String.valueOf(materia.calculaDef(Integer.parseInt(nota1), Integer.parseInt(nota2),
                        Integer.parseInt(nota3), Integer.parseInt(nota4)));
                escritor.println(estudiante+ "," +nombreMateria + ","+nota1+","+nota2+","+nota3+","+nota4+","+definitiva);
            }
            escritor.close();
        }catch (FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error al crear notas de "+nombreMAteria);
        }
    }

    //2.1 crearNotas
    public void crearNotas(){
        //creando lista de nombres creados
        File archivo = new File("src/estudiantes.txt");
        try {
            sc = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado");
            System.exit(0);
        }
        while(sc.hasNext()){
            lista_nombres.add(sc.nextLine());
        }


        while(nombreMateria=="") {
            switch (JOptionPane.showInputDialog(null, "Seleccione una materia\n" +
                    "1. Matematicas\n" + "2. Fisca\n" + "3. Español\n" + "4. Sociales")) {
                case "1":
                    nombreMateria = "Matematicas";
                    nota(nombreMateria);
                    break;
                case "2":
                    nombreMateria = "Fisica";
                    nota(nombreMateria);
                    break;
                case "3":
                    nombreMateria = "Español";
                    nota(nombreMateria);
                    break;
                case "4":
                    nombreMateria = "Soiales";
                    nota(nombreMateria);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Opcion no valida");
            }
        }
    }

//3.2 listarNotas
    //submetodo para buscar la lista
    private void buscaLista(String nombreMateria){
        ArrayList<String> lista_lineas = new ArrayList<>();
        try {
            File archivo = new File("src/Notas/" +nombreMateria+".csv");
            sc = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNext()){
            lista_lineas.add(sc.nextLine());
        }
        lista_lineas.remove(0);

        for (String linea: lista_lineas) {
            String[] separado = linea.split(",");
           JOptionPane.showMessageDialog(null, "Lista de Notas de "+separado[1]+"\n"+
                   "Estudiante: "+separado[0]+"\n"+"Nota 1: "+separado[2]+"\n"+"Nota 2: "+separado[3]+"\n"+
                   "Nota 3: " +separado[4]+"\n"+"Nota 4: "+separado[5]+"\n"+"Definitiva: "+separado[6]);
        }

    }

    public void listarNotas(){
        String nombreMateria= "";
        while (nombreMateria==""){
            switch (JOptionPane.showInputDialog(null, "Listar Notas\n"+
                    "Por favor selecione una de las siguientes materias:" +"\n"+
                    "1. Matematicas\n"+"2. Fisica"+"\n"+"3. Español\n"+"4. Sociales")){
                case "1":
                    nombreMateria = "Matematicas";
                    buscaLista(nombreMateria);
                    break;
                case "2":
                    nombreMateria = "Fisica";
                    buscaLista(nombreMateria);
                    break;
                case "3":
                    nombreMateria = "Español";
                    buscaLista(nombreMateria);
                    break;
                case "4":
                    nombreMateria = "Sociales";
                    buscaLista(nombreMateria);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opvion invalida");
            }
        }


    }

//3.3 buscaNotaEstudiante
private String buscaNota(String nombreMateria, String nombreEstudiante){
        ArrayList<String> lista_lineas = new ArrayList<>();
    try {
        File archivo = new File("src/Notas/"+nombreMateria+".csv");
        sc = new Scanner(archivo);
    } catch (FileNotFoundException e) {
       JOptionPane.showMessageDialog(null, "Error al cargar archivo");
    }
    //agregamos la cada linea en una posicion de el arreglo
    while(sc.hasNext()){
        lista_lineas.add(sc.nextLine());
    }
    lista_lineas.remove(0);
    String nombrefinal = null;
    for (String nombre: lista_lineas) {
        String[] separados = nombre.split(",");
        String[] name = separados[0].split(" ");
        if(nombreEstudiante.equalsIgnoreCase(name[0])){
            nombrefinal =  "Materia: "+separados[1]+"\n"+
                    "Estudiante: "+separados[0]+"\n"+"Nota 1: "+separados[2]+"\n"+
                    "Nota 2: "+separados[3]+"\n"+"Nota 3: "+separados[4]+"\n"+
                    "Nota 4: "+separados[5]+"\n"+"Definitiva: "+separados[6];
        }
    }
    return nombrefinal;
}


public void buscaNotaEstudiante(){
        String nombreMateria="";
        String nombreBusqueda;
        String nombreEncontrado;
        switch (JOptionPane.showInputDialog(null, "Listar Notas\n"+
                "Por favor selecione una de las siguientes materias:" +"\n"+
                "1. Matematicas\n"+"2. Fisica"+"\n"+"3. Español\n"+"4. Sociales")){
            case "1":
                nombreMateria = "Matematicas";
                nombreBusqueda = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar");
                nombreEncontrado = buscaNota(nombreMateria, nombreBusqueda);
                if(nombreEncontrado == null){
                    JOptionPane.showMessageDialog(null, "El nombre ingresado no se encuentra");
                }else {
                    JOptionPane.showMessageDialog(null, nombreEncontrado);
                }
                break;
            case "2":
                nombreMateria = "Fisica";
                nombreBusqueda = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar");
                nombreEncontrado = buscaNota(nombreMateria, nombreBusqueda);
                if(nombreEncontrado == null){
                    JOptionPane.showMessageDialog(null, "El nombre ingresado no se encuentra");
                }else {
                    JOptionPane.showMessageDialog(null, nombreEncontrado);
                }
                break;
            case "3":
                nombreMateria = "Español";
                nombreBusqueda = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar");
                nombreEncontrado = buscaNota(nombreMateria, nombreBusqueda);
                if(nombreEncontrado == null){
                    JOptionPane.showMessageDialog(null, "El nombre ingresado no se encuentra");
                }else {
                    JOptionPane.showMessageDialog(null, nombreEncontrado);
                }
                break;
            case "4":
                nombreMateria = "Sociales";
                nombreBusqueda = JOptionPane.showInputDialog(null, "Ingrese el nombre a buscar");
                nombreEncontrado = buscaNota(nombreMateria, nombreBusqueda);
                if(nombreEncontrado == null){
                    JOptionPane.showMessageDialog(null, "El nombre ingresado no se encuentra");
                }else {
                    JOptionPane.showMessageDialog(null, nombreEncontrado);
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opvion invalida");
        }

}

//3.4 Modificar notas Estudiante
    //submetodo para modificar
    private void modificaNota(String nombreEstudiante, String nombreMateria){
        ArrayList<String> lista_de_estudiantes = new ArrayList<>();

        try {
            archivo = new File("src/Notas/"+nombreMateria+".csv");
            sc = new Scanner(archivo);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo.");
        }
        while(sc.hasNext()){
            lista_de_estudiantes.add(sc.nextLine());
        }
        for (String estudiante:lista_de_estudiantes) {
            if(estudiante.toLowerCase().startsWith(nombreEstudiante.toLowerCase())){
                String[] datos_estudiante = estudiante.split(",");
                lista_de_estudiantes.remove(estudiante);
                PrintWriter escritor = null;
                try {
                    escritor = new PrintWriter(archivo);
                    for (String linea:lista_de_estudiantes) {
                        escritor.println(linea);
                    }
                    //agregamos el nuevo estudiante
                    //solicitamos las nuevas notas
                    String nota1 = JOptionPane.showInputDialog(null, "Ingrese las nuevas notas\n"+"Nota1: ");
                    String nota2 = JOptionPane.showInputDialog(null, "Nota 2:");
                    String nota3 = JOptionPane.showInputDialog(null, "Nota 3:");
                    String nota4 = JOptionPane.showInputDialog(null, "Nota 4:");
                    String definitiva = String.valueOf(materia.calculaDef(Integer.parseInt(nota1),
                            Integer.parseInt(nota2), Integer.parseInt(nota3), Integer.parseInt(nota4)));
                    escritor.println(datos_estudiante[0]+","+nombreMateria+","+nota1+","+nota2+","+nota3+","+nota4+","+definitiva);
                    escritor.close();
                    JOptionPane.showMessageDialog(null, "Estudiante modificado con exito\n"+
                            "Estudiante: "+datos_estudiante[0]+"\n"+
                            "Materia: " + datos_estudiante[1]+"\n"+
                            "Nota 1: "+nota1+"\n"+"Nota 2: "+nota2+"\n"+"Nota 3: "+nota3+"\n"+"Nota 4: "+nota4+"\n"+
                            "Definitiva: "+definitiva);
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Error al abrir archivo.");
                }


            }
        }

    }

    //Metodo
    public void modificarNotaEstudiante(){
        nombreMateria = "";
        String nombre;
        while(nombreMateria == ""){
            switch (JOptionPane.showInputDialog(null, "Listar Notas\n"+
                    "Por favor selecione una de las siguientes materias:" +"\n"+
                    "1. Matematicas\n"+"2. Fisica"+"\n"+"3. Español\n"+"4. Sociales")){
                case "1":
                    nombreMateria="Matematicas";
                    nombre = JOptionPane.showInputDialog(null, "Modificar Estudiante\n"+"Ingrese el Nombre del estudiante a modificar");
                    modificaNota(nombre, nombreMateria);
                    break;
                case "2":
                    nombreMateria="Fisica";
                    nombre = JOptionPane.showInputDialog(null, "Modificar Estudiante\n"+"Ingrese el Nombre del estudiante a modificar");
                    modificaNota(nombre, nombreMateria);
                    break;
                case "3":
                    nombreMateria="Español";
                    nombre = JOptionPane.showInputDialog(null, "Modificar Estudiante\n"+"Ingrese el Nombre del estudiante a modificar");
                    modificaNota(nombre, nombreMateria);
                    break;
                case "4":
                    nombreMateria="Sociales";
                    nombre = JOptionPane.showInputDialog(null, "Modificar Estudiante\n"+"Ingrese el Nombre del estudiante a modificar");
                    modificaNota(nombre, nombreMateria);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Entrada invalida");
            }
        }
    }


//3.5 borrarEstudiante
    //submetodo de borrarNotas
    private void borra(String nombre, String nombreMateria){
        ArrayList<String> lista_estudiantes = new ArrayList<>();

        try {
            archivo = new File("src/Notas/"+nombreMateria+".csv");
            sc = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado.");
        }
        while(sc.hasNext()) {
            lista_estudiantes.add(sc.nextLine());
        }

        for (String estudiante:lista_estudiantes) {
            String[] linea_separada = estudiante.split(",");
            String[] name = linea_separada[0].split(" ");
            System.out.println(name[0]);
            if(name[0].equalsIgnoreCase(nombre)){
                lista_estudiantes.remove(estudiante);
                try {
                    PrintWriter escritor = new PrintWriter(archivo);
                    for (String linea :lista_estudiantes) {
                        escritor.println(linea);
                    }
                    escritor.close();
                    break;
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Error al crear el archivo.");
                }

            }
        }
    }

public void borraNotasEstudiante(){
        nombreMateria="";
        String nombre;
        while(nombreMateria == ""){
            switch (JOptionPane.showInputDialog(null, "Listar Notas\n"+
                    "Por favor selecione una de las siguientes materias:" +"\n"+
                    "1. Matematicas\n"+"2. Fisica"+"\n"+"3. Español\n"+"4. Sociales")){
                case "1":
                    nombreMateria="Matematicas";
                    nombre = JOptionPane.showInputDialog(null, "Modificar Estudiante\n"+"Ingrese el Nombre del estudiante a borrar.");
                    borra(nombre, nombreMateria);
                    break;
                case "2":
                    nombreMateria="Fisica";
                    nombre = JOptionPane.showInputDialog(null, "Modificar Estudiante\n"+"Ingrese el Nombre del estudiante a borrar.");
                    borra(nombre, nombreMateria);
                    break;
                case "3":
                    nombreMateria="Español";
                    nombre = JOptionPane.showInputDialog(null, "Modificar Estudiante\n"+"Ingrese el Nombre del estudiante a borrar.");
                    borra(nombre, nombreMateria);
                    break;
                case "4":
                    nombreMateria="Sociales";
                    nombre = JOptionPane.showInputDialog(null, "Modificar Estudiante\n"+"Ingrese el Nombre del estudiante a borrar.");
                    borra(nombre, nombreMateria);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Entrada invalida");
            }
        }
}
}
