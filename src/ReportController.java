import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase controlador que gestiona el modulo de reportes que se encarga de listar y buscar los reportes de los estudiantes existentes.
 * @author juanpcs
 */
public class ReportController {

    /**
     * Instancia vacia del objeto Scanner.
     */
    Scanner sc = null;
    //Metodo para seleccion de materia

    /**
     * Metodo que busca la nota definitiva de el estudiante y materia requeridos y la retorna de existir,
     * en caso contrario retorna la nota como "0".
     * @param nombreEstudiante Nombre del estudiante a buscar.
     * @param nombreMateria Materia a buscar.
     * @return Nota definitiva de la materia, en caso de no encontrarla retorna "0" para dicha materia.
     */
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

    /**
     * Metodo que se llama al metodo de buscar notas, pasando como parametros los nombres almacenados
     * y el nombre de cada materia, en caso de tener "0" en todas las materias, imprime que no existen notas,
     * de lo contrario imprime las notas encontradas.
     * */
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

    /**
     * Metodo que invoca al metodo de buscarNotas pasando como parametro un nombre que se pide al usuario por consola,
     * y buscando asi coincidencias en cada una de las materias, en caso de  no encotrar imprime la no existencia de notas.
     */
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
