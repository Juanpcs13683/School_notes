import javax.swing.*;
import java.util.ArrayList;

public class Controller {

    public ArrayList<Student> lista_estudiantes = new ArrayList<>();

    //aqui van todos los metodos

    //  metodo menu genearl
    public String menuGeneral(){
        String menu = "******  Administrador de notas Escolares  ******\n\n"+
                "Por favor seleccione una accion \n\n"+
                "1. Crear Estudiantes\n"+
                "1. Crear Notas\n"+
                "2. Consultar Notas\n"+
                "2. Generar Reporte\n"+
                "3. Consultar Reporte \n"+
                "4. Buscar Estudiante \n"+
                "5. Exit";
        return JOptionPane.showInputDialog(null, menu);
    }

    //menu de Estudiantes
    public void menuEstudiantes(){
        JOptionPane.showInputDialog(null, "******  Estudiantes  ******\n"+
                "1. Crear Estudiante\n"+
                "2. Lista Estudiantes\n"+
                "3. Buscar Estudiante\n"+
                "4. Modificar Estudiante\n"+
                "5. Borrar Estudiante\n"+
                "6. Menu Principal\n"+
                "7. Salir");
    }

    //Menu Notas
    public void menuNotas(){
        JOptionPane.showInputDialog(null, "******  Notas ******\n"+
                "1. Crear Notas\n"+
                "2. Lista de Notas\n"+
                "3. Buscar Notas Estudiante\n"+
                "4. Modificar Notas Estudiante\n"+
                "5. Borrar Notas Estudiante\n"+
                "6. Menu Principal\n"+
                "7. Salir");
    }

    //menu Reportes
    public void menuReportes(){
        JOptionPane.showInputDialog(null, "******  Reportes  *****\n"+
                "1. Lista de Reportes\n"+
                "2. Buscar Reporte\n"+
                "3. Menu Principal\n"+
                "4. Salir");
    }

    //Crear estudiantes
    public void crearEstudiante(){
        JOptionPane.showMessageDialog(null, "Creacion de Estudiante\n"+
                "Inserte los datos a continuacion \n\n");
        String name = JOptionPane.showInputDialog(null, "Nombre: ");
        String last_name = JOptionPane.showInputDialog(null, "Apellido: ");
        String age = JOptionPane.showInputDialog(null, "Edad: ");
        String grade = JOptionPane.showInputDialog(null, "Curso: ");
        lista_estudiantes.add(new Student(name, last_name, Integer.parseInt(age), Integer.parseInt(grade)));

    }

    // 1. metodo para crear las notas
    public void crearNotas(){

    }

    // 2. metodo para consultar las notas
    public void constularNotas(){

    }

    // 3. metodo para generar repotes
    public void generarReporte(){

    }

    // 4. metodo para constultar reportes
    public void consultarReporte(){

    }

    // 5. metodo para salir
    public void exit(){
        JOptionPane.showMessageDialog(null, "******  Gracias por usar nuestro servicio  *******\n"+
                " *** Bye ***");
    }

    // 6. metodo para crear lista de estudiantes
}
