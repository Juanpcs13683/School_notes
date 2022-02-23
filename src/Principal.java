import javax.swing.*;
import java.util.Scanner;

/**
 * Clase principal que cumple la funcion de vista e interactura con el usuario.
 */
public class Principal {
    public static void main(String[] args) {

        /**
         * Instancia del controlador principal.
         */
        PrincipalController controladorPrincipal = new PrincipalController();

        /**
         * Instancia del controlador del modulo estudiante.
         */
        StudentController controladorEstudiante = new StudentController();

        /**
         * Instancia del controlador del modulo de notas.
         */
        ScoreController controladorNotas = new ScoreController();

        /**
         * Instancia del controlador del modulo de reportes.
         */
        ReportController controladorReportes = new ReportController();

        /**
         * Mensaje de biembenida al ingreso del programa.
          */
        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de gestion de notas y reportes");
        boolean continua = true;

        /**
         * El siguiente fragmento de codigo se encarga de brindar al usuario las diferentes opciones, y a partir de las mismas
         * hace un llamado a el controlador de cada modulo y sus metodos.
         */
        while(continua){
            switch (controladorPrincipal.menuGeneral()){
                case "1":
                    boolean continua_e = true;
                    while(continua_e){
                        switch (controladorPrincipal.menuEstudiantes()) {
                            case "1":
                                controladorEstudiante.crearEstudiante();
                                break;
                            case "2":
                                controladorEstudiante.listaEstudiantes();
                                break;
                            case "3":
                                controladorEstudiante.buscarEstudiante();
                                break;
                            case "4":
                                controladorEstudiante.modificarEstudiante();
                                break;
                            case "5":
                                controladorEstudiante.borrarEstudiante();
                                break;
                            case "6":
                                continua_e=false;
                                break;
                            case "7":
                                controladorPrincipal.exit();
                                System.exit(0);
                                break;
                        }
                        }
                    break;
                case "2":

                    boolean continua_n = true;
                    while(continua_n){
                        switch (controladorPrincipal.menuNotas()){
                            case"1":
                               // llamamos metodo de seleccion de materia
                                controladorNotas.crearNotas();
                                break;
                            case "2":
                                controladorNotas.listarNotas();
                                break;
                            case "3":
                                controladorNotas.buscaNotaEstudiante();
                                break;
                            case "4":
                                controladorNotas.modificarNotaEstudiante();
                                break;
                            case "5":
                                controladorNotas.borraNotasEstudiante();
                                break;
                            case "6":
                                continua_n = false;
                                break;
                            case "7":
                                controladorPrincipal.exit();
                                System.exit(0);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida");
                        }

                    }
                    break;
                case "3":
                    boolean continua_r = true;
                    while(continua_r){
                        switch (controladorPrincipal.menuReportes()){
                            case "1":
                                controladorReportes.listaReportes();
                                break;
                            case "2":
                                controladorReportes.buscaReporte();
                                break;
                            case "3":
                                continua_r=false;
                                break;
                            case "4":
                                System.exit(0);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opcion invalida");
                        }
                    }
                    break;
                case "4":
                    controladorPrincipal.exit();
                    continua = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
            }

        }
    }
}
