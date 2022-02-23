import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase de tipo controlador que se encarga de gestionar el CRUD de notas para cada estudiante.
 */
public class ScoreController {

    /**
     *Instancia del objeto Scanner que se incializa vacia para luego ser usada.
     */
    Scanner sc = null;

    /**
     * Instancia del objteto archivo que se inicializa vacia para luego ser usada.
     */
    File archivo = null;

    //creamos una instancia para poder  usar la clase y sus metodos

    /**
     *Instancia del objeto materia para acceder a sus metodos en esta clase.
     */
    Materia materia = new Materia();

    /**
     * Instancia de un objeto tipo ArrayList el cual almacenara las notas registradas en el CRUD.
     */
    ArrayList<Materia> lista_notas = new ArrayList<>();

    /**
     * Atributo tipo String que representa el nombre de la materia el cual se usara durante el CRUD de notas.
     */
    String nombreMateria = "";

    /**
     * Obtejo tipo ArrayList que almacena los nombres de cada uno de los estudiantes registrados en el controlador de estudiantes.
     */
    ArrayList<String> lista_nombres = new ArrayList<>();

    //metodo que crea las notas

    /**
     * Metodo que verifica cada estudiante almacenado en lista_nombres y registra las notas
     * registradas para dicho estudiante las cuales son requeridas por consola al usuario,
     * calcula la definitiva del estudiante a partir de las notas introducidas y
     * luego escribe toda la informacion en un archivo .csv.
     * @param nombreMAteria Nombre de la materia.
     */
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

    /**
     * Metodo que busca los estudiantes existentes y luego pide al usuario las notas asociadas a este,
     *luego guarda las notas en el arreglo lista_notas.
     */
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

    /**
     * Metodo que recibe como parametro el nombre de la materia a buscar y retorna
     * las notas de cada estudiante registradas en esta.
     * @param nombreMateria Nombre de la materia.
     */
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

    /**
     * Metodo que invoca al metodo de buscarLista para retornar al usuario la lista de notas de cada materia,
     * pasando como parametro el nombre de la materia que usa el metodo buscaLista para cada materia.
     */
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

    /**
     * Metodo que toma como parametros el nombre del estudiante y nombre de la materia,
     * y retorna las notas del estudiante en esa materia.
     * @param nombreMateria Nombre materia.
     * @param nombreEstudiante Nombre del estudiante.
     * @return
     */
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

    /**
     * Metodo que invoca al metodo buscaNota pasando los parametros de nombre de estudiante y nombre de la materia,
     * y luego imprime al usuario las notas encontradas asociadas el nombre de estudiante.
     */
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

    /**
     * Metodo que toma como parametros el nombre del estudiante y nombre de la materia,
     * ya que su intencion es sobreescribir estas, remueve los datos de la lista si los encuentra,
     * y los escribe guardandolos en la ultima posicion.
     * @param nombreEstudiante Nombre del estudiante.
     * @param nombreMateria Nombre de la materia.
     */
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

    /**
     * Metodo que invoca el metodo modificaNota, pasando a este los parametros de nombre de estudiante y materia
     * a buscar e imprime mensaje de estado del proceso al usuario en caso de exito o falla.
     */
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

    /**
     * Metodo para borrar las notas de un estudiante.
     * @param nombre Nombre del estudiante.
     * @param nombreMateria Nombre de la materia.
     */
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

    /**
     * Metodo que invoca al metodo borra, pasando a este los parametros de nombre de estudiante y materia,
     * e imprime al usuario el exito o falla del proceso.
     */
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
