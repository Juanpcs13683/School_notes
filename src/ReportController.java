import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportController {

    Scanner sc = null;
    //Metodo para seleccion de materia
    private String buscaNotas(String nombreEstudiante,String nombreMateria){
        String notaDefinitiva = "0";
        try {
            File notasMateria = new File("src/Notas/"+nombreMateria+".csv");
            sc = new Scanner(notasMateria);
        } catch (FileNotFoundException e) {
            notaDefinitiva = "0";

        }
        ArrayList<String> lista_datos = new ArrayList<>();
        while(sc.hasNext()){
            lista_datos.add(sc.nextLine());
        }
        if(lista_datos.isEmpty()!=true){
            for (String dato:lista_datos) {
                String[] datos_separados = dato.split(",");
                if(nombreEstudiante.equalsIgnoreCase(datos_separados[0])){
                    notaDefinitiva = datos_separados[6];
                }
            }
        }else{
            notaDefinitiva = "0";
        }

    return notaDefinitiva;
    }

    //3.1 Lista reportes
    public void listaReportes() {

        try {
            File nombres = new File("src/estudiantes.txt");
            sc = new Scanner(nombres);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Archivo no encontrado.");
        }
        ArrayList<String> lista_nombres = new ArrayList<>();
        while (sc.hasNext()){
            lista_nombres.add(sc.nextLine());
        }
        for (String nombre:lista_nombres) {
            String matematicas = buscaNotas(nombre, "Matematicas");
            String fisica = buscaNotas(nombre, "Fisica");
            String español = buscaNotas(nombre, "Español");
            String sociales = buscaNotas(nombre, "Sociales");

            if(matematicas=="0" && fisica=="0" && español=="0" && sociales =="0"){
                JOptionPane.showMessageDialog(null, "Reporte de notas\n"+
                        "No hay notas registradas para el estudiante "+nombre);
            }else {
                JOptionPane.showMessageDialog(null, "Reporte de Notas\n" +
                        "Estudiante: " + nombre + "\n" +
                        "Matematicas: " + matematicas + "\n" +
                        "Fisica: " + fisica + "\n" +
                        "Español: "+español+"\n"+
                        "Sociales: " + sociales);
            }
        }
    }

    //3.2 Buscar reporte
    public void buscaReporte(){
        String nombre = JOptionPane.showInputDialog(null, "Buscar Reporte\n"+
                "Ingrese nombre completo del estudiante: ");
        String matematicas = buscaNotas(nombre, "Matematicas");
        String fisica = buscaNotas(nombre, "Fisica");
        String español = buscaNotas(nombre, "Español");
        String sociales = buscaNotas(nombre, "Sociales");
        if(matematicas!="0" || fisica!="0" || español!="0" || sociales!="0"){
            JOptionPane.showMessageDialog(null, "Reporte de Notas\n" +
                    "Estudiante: " + nombre + "\n" +
                    "Matematicas: " + matematicas + "\n" +
                    "Fisica: " + fisica + "\n" +
                    "Español: "+español+"\n"+
                    "Sociales: " + sociales);
        }else{
            JOptionPane.showMessageDialog(null, "Reporte de notas\n"+
                    "No hay notas registradas para el estudiante "+nombre);
        }
    }
}
