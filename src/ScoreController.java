import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreController {
    Scanner sc = null;
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

//2.2 listarNotas
    //submetodo para buscar la lista
    public void buscaLista(String nombreMateria){
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






}
