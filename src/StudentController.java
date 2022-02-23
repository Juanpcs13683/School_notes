import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase controlador en la cual se hace el CRUD referente a la informacion de los estudiantes.
 * @author juanpcs
 */
public class StudentController {

    /**
     * Arreglo dinamico que almacena los estudiantes y sus datos personales.
     */
    private ArrayList<Student> lista_estudiantes = new ArrayList<>();
    /////// Menu Estudiantes


    // 1.1 Crear estudiantes

    /**
     * Metodo para crear un objeto de tipo Student.
     */
    public void crearEstudiante() {
        JOptionPane.showMessageDialog(null, "Creacion de Estudiante\n" +
                "Inserte los datos a continuacion \n\n");
        String name = JOptionPane.showInputDialog(null, "Nombre: ");
        String last_name = JOptionPane.showInputDialog(null, "Apellido: ");
        String age = JOptionPane.showInputDialog(null, "Edad: ");
        String grade = JOptionPane.showInputDialog(null, "Curso: ");

        try {

            lista_estudiantes.add(new Student(name, last_name, Integer.parseInt(age), Integer.parseInt(grade)));

            //imprimimos confirmacion y datos
            JOptionPane.showMessageDialog(null, "Creacion Exitosa\n" +
                    "Estudiante: " + name + " " + last_name + "\n" +
                    "Edad: " + age + "\n" +
                    "Curso: " + grade);

        } catch (Error ex) {
            JOptionPane.showMessageDialog(null, "Error al crear Estudiante");
        }

    }

    //1.2 Lista Estudiantes

    /**
     * Metodo para listar los estudiantes existentes en el arreglo lista_estudiantes.
     */
    public void listaEstudiantes() {

        if (lista_estudiantes.size() > 0) {
            int x = 0;
            try {
                File creadorEstudiantes = new File("src/estudiantes.txt");
                PrintWriter escritor = new PrintWriter(creadorEstudiantes);
                for (Student estudiante : lista_estudiantes) {
                    x++;
                    JOptionPane.showMessageDialog(null, "Estudiante No. " + x + "\n" +
                            "Nombre: " + estudiante.name + " " + estudiante.last_name + "\n" +
                            "Edad: " + estudiante.age + "\n" +
                            "Curso: " + estudiante.grade);
                    escritor.println(estudiante.name + " " + estudiante.last_name);
                }
                escritor.close();
            } catch (FileNotFoundException e) {
                System.out.println("Archivo no creado");
            }

        } else {
            JOptionPane.showMessageDialog(null, "no se encontro registro de estudiantes");
        }
    }

    //1.3 Buscar Estudiante

    /**
     * Metodo para buscar un estudiante especifico en el arreglo lista_estudiantes.
     */
    public void buscarEstudiante() {
        String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre del estudiante");
        for (Student estudiante : lista_estudiantes) {
            if (estudiante.name.equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(null, "Estudiante: "
                        + estudiante.name + " " + estudiante.last_name + "\n " +
                        "Edad: " + estudiante.age + "\n " +
                        "Curso: " + estudiante.grade);
            } else {
                JOptionPane.showMessageDialog(null, "No hay coincidencias.");
            }

        }

    }


    //1.4 Modificar Estudiante

    /**
     * Metodo para sobreescribir la infomacion de un estudiante especifico del arreglo lista_estudiantes.
     */
    public void modificarEstudiante() {
        String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre del estudiante a reemplazar");
        for (Student estudiante : lista_estudiantes) {
            if (estudiante.name.equalsIgnoreCase(nombre)) {
                lista_estudiantes.remove(estudiante);
                //insertamos el nuevo estudiante
                JOptionPane.showMessageDialog(null, "Creacion de Estudiante\n" +
                        "Inserte los datos a continuacion \n\n");
                String name = JOptionPane.showInputDialog(null, "Nombre: ");
                String last_name = JOptionPane.showInputDialog(null, "Apellido: ");
                String age = JOptionPane.showInputDialog(null, "Edad: ");
                String grade = JOptionPane.showInputDialog(null, "Curso: ");
                lista_estudiantes.add(new Student(name, last_name, Integer.parseInt(age), Integer.parseInt(grade)));
                JOptionPane.showMessageDialog(null, "Estudiante Modificado con exito\n" +
                        "Nombre: " + name + " " + last_name + "\n" +
                        "Edad: " + age + "\n" +
                        "Curso: " + grade);
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar Estudiante.");
            }
        }
    }

    //1.5 Borrar Estudiante

    /**
     * Metodo para borrar un estudiante especifico del arreglo lista_estudiantes.
     */
    public void borrarEstudiante() {
        String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre del Estudiante a borrar");
        for (Student estudiante : lista_estudiantes) {
            if (estudiante.name.equalsIgnoreCase(nombre)) {
                JOptionPane.showMessageDialog(null, "Estudiante a Eliminar: \n" +
                        "Nombre: " + estudiante.name + " " + estudiante.last_name + "\n" +
                        "Edad: " + estudiante.age + "\n" +
                        "Curso: " + estudiante.grade);

                try {
                    lista_estudiantes.remove(estudiante);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar Estudiante");
                }
            }
        }
    }
}
