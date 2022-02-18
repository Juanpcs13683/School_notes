import javax.swing.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreController {

    Scanner sc;
    //creamos una instancia para poder  usar la clase y sus metodos
    Materia materia = new Materia();
    ArrayList<Materia> lista_notas = new ArrayList<>();
    String nombreMateria = "";


    //Metodo para Crear el archivo
    public String seleccionMateria(){
        while(nombreMateria == "") {
            switch (JOptionPane.showInputDialog(null, "Seleccione una materia\n" +
                    "1. Matematicas\n" + "2. Fisca\n" + "3. Español\n" + "4. Sociales")) {
                case "1":
                    nombreMateria = "Matematicas";
                    try{
                        sc = new Scanner("src/csv/Notas/Matematicas.csv");
                    }catch (Exception ex){
                        try{
                            File creadorMatematicas = new File("src/Notas/Matematicas.csv");
                            JOptionPane.showMessageDialog(null, "Archivo Matematicas creado con exito");

                        }catch (Exception){
                            JOptionPane.showMessageDialog(null, "Error al crear ");
                        }
                    }
                    break;
                case "2":
                    nombreMateria = "Fisica";
                    break;
                case "3":
                    nombreMateria = "Español";
                    break;
                case "4":
                    nombreMateria = "Soiales";
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Opcion no valida");
            }
        }
        return nombreMateria;
    }

    public void csv(){
        try {
            File creador = new File("src/Notas/"+nombreMateria+".csv");
            PrintWriter escritor= new PrintWriter(creador);
            escritor.println("Nombre,Materia,Nota1,Nota2,Nota3,Nota4,Definitiva");
            escritor.close();
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Archivo existente");
        }
    }

    // Metodo selecionar materia


    //2.1 Crear Notas
    public void crearNota(){
        try {
            //cargamos el archivo csv
            File notas = new File("src/Notas/Notas.csv");
            PrintWriter escritor = new PrintWriter(notas);
            String nombre = JOptionPane.showInputDialog(null, "Crear Nota\n" +
                    "Por favor ingrese los datos a continuacion\n" +
                    "Nombre Estudiante: ");


            String nombreMateria = seleccionMateria();

            String nota1 = JOptionPane.showInputDialog(null, "Nota 1.");
            String nota2 = JOptionPane.showInputDialog(null, "Nota 2.");
            String nota3 = JOptionPane.showInputDialog(null, "Nota 3");
            String nota4 = JOptionPane.showInputDialog(null, "Nota 4");
            String definitiva = String.valueOf( materia.calculaDef(Integer.parseInt(nota1), Integer.parseInt(nota2),
                    Integer.parseInt(nota3), Integer.parseInt(nota4)));

            //Escribimos en el documento csv
            escritor.println(nombre+","+nombreMateria+","+nota1+","+nota2+","+nota3+","+nota4+","+definitiva);
            escritor.close();

            //guardamos la nota en el arreglo
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al Crear Nota");

        }
    }


}
