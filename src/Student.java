/**
 * Clase que representa un estudiante, sus atributos y algunos de metodos accesores
 * @author juanpcs
 */
public class Student {

    /**
     * Atributo tipo String que representa el nombre de un estudiante.
     */
    public String name;

    /**
     * Atributo tipo String que representa el apellido de un estudiante.
     */
    public String last_name;

    /**
     * Atributo tipo int que representa la edad del estudiante.
     */
    public int age;

    /**
     * Atributo tipo int que representa el curso en que se encuentra el estudiante.
     */
    public int grade;

    /**
     * Metodo constructor que permite instanciar la clase sin inicializar sus atributos.
     */
    public Student() {
    }

    /**
     * Metodo constructor que permite instanciar la clasae inicializando cada uno de sus atributos.
     * @param name Nombre del estudiante.
     * @param last_name Apellido del estudiante.
     * @param age Edad del estudiante.
     * @param grade Curso del estudiante.
     */
    public Student(String name, String last_name, int age, int grade) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.grade = grade;
    }


}
