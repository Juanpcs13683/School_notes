import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportController {

    Scanner sc = null;
    ArrayList<String> lista_estudiantes = new ArrayList<>();
    //Metodo para seleccion de materia
    private void seleccionaMateria(String nombreMateria){

    }

    //3.1 Lista reportes
    public void listaReportes(){
        String notaMatematicas = seleccionaMateria();
        try {
            File archivo = new File("src/Notas/"+nombreMateria+".csv");
            sc = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo.");
            System.exit(0);
        }
        while(sc.hasNext()){
            lista_estudiantes.add(sc.nextLine());
        }
        lista_estudiantes.remove(0);
        for (String estudiante:lista_estudiantes) {
            String[] datos_estudiante = estudiante.split(",");
            JOptionPane.showMessageDialog();
        }
    }
}
