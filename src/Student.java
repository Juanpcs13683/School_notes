/**
 * Clase que representa un estudiante, sus atributos y algunos de metodos accesores
 * @author juanpcs
 */
public class Student {

    public String name;
    public String last_name;
    public int age;
    public int grade;

    public Student() {
    }

    public Student(String name, String last_name, int age, int grade) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
