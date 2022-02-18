import javax.swing.*;
import java.util.ArrayList;

public class PrincipalController {



    //Seccion de menus

    //  metodo menu genearl
    public String menuGeneral(){
        String menu = "******  Administrador de notas Escolares  ******\n\n"+
                "Menu Principal\n"+
                "Por favor seleccione una de las siguientes opciones \n\n"+
                "1. Estudiantes\n"+
                "2. Notas\n"+
                "3. Reportes\n"+
                "4. Exit";
        return JOptionPane.showInputDialog(null, menu);
    }

    //1. menu de Estudiantes
    public String menuEstudiantes(){
        return  JOptionPane.showInputDialog(null, "******  Estudiantes  ******\n"+
                "1. Crear Estudiante\n"+
                "2. Lista Estudiantes\n"+
                "3. Buscar Estudiante\n"+
                "4. Modificar Estudiante\n"+
                "5. Borrar Estudiante\n"+
                "6. Menu Principal\n"+
                "7. Salir");
    }

    //2. Menu Notas
    public String menuNotas(){
        return JOptionPane.showInputDialog(null, "******  Notas ******\n"+
                "1. Crear Notas\n"+
                "2. Lista de Notas\n"+
                "3. Buscar Notas Estudiante\n"+
                "4. Modificar Notas Estudiante\n"+
                "5. Borrar Notas Estudiante\n"+
                "6. Menu Principal\n"+
                "7. Salir");
    }

    //3. menu Reportes
    public String menuReportes(){
        return JOptionPane.showInputDialog(null, "******  Reportes  *****\n"+
                "1. Lista de Reportes\n"+
                "2. Buscar Reporte\n"+
                "3. Menu Principal\n"+
                "4. Salir");
    }



    // 5. metodo para salir
    public void exit(){
        JOptionPane.showMessageDialog(null, "******  Gracias por usar nuestro servicio  *******\n"+
                " *** Bye ***");
    }
}
