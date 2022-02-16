import javax.swing.*;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        Controller controlador = new Controller();
        Scanner sc = new Scanner(System.in);

        JOptionPane.showMessageDialog(null, "Biemvenido al sistema de gestion de notas y reportes");
        controlador.menuGeneral();
        while(sc.hasNext()){
            System.out.println("sirvio");
            String op = sc.next();
            switch (op){
                case "1":
                    controlador.crearNotas();
                    break;
                case "2":
                    controlador.constularNotas();
                    break;
                case "3":
                    controlador.generarReporte();
                    break;
                case "4":
                    controlador.consultarReporte();
                case "5":
                    controlador.exit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
            }
            controlador.menuGeneral();
        }
    }
}
