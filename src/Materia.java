/**
 * Clase que representa las notas acumuladas para una materia escolar y contiene un metodo de calculo para
 * la nota final.
 * @author juanpcs
 */
public class Materia extends Student{
    /**
     * Atributo tipo String que representa el nombre de la materia.
     */
    public String materia;

    /**
     * Atributo tipo int que representa la primera calificacion obtenida en la materia.
     */
    public int score1;

    /**
     * Atributo tipo int  que representa la segunda calificacion obtenida en la materia.
     */
    public int score2;

    /**
     *Atributo tipo int que representa la tercera calificacion obtenida en la materia.
     */
    public int score3;

    /**
     * Atributo tipo int que representa la cuarta calificacion obtenida en la materia.
     */
    public int score4;

    /**
     * Atributo tipo int que representa el promedio de las cuatro calificaciones obtenidas en la materia.
     */
    public int def;

    /**
     * Metodo constructor que permite instanciar la clase sin inicializar sus atributos.
     */
    public Materia() {
    }

    /**
     * Metodo constructor que permite instanciar la clase inicializando cada uno de sus atributos.
     * @param materia Nombre de la materia.
     * @param score1 Primera nota de la materia.
     * @param score2 Segunda nota de la materia.
     * @param score3 Tercera nota de la materia.
     * @param score4 Cuarta nota de la materia.
     * @param def Nota definitiva de la materia.
     */
    public Materia(String materia, int score1, int score2, int score3, int score4, int def) {
        this.materia = materia;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.def = def;
    }

    //metodo para calcular la definitiva

    /**
     * Metodo que retorna un promedio de la calificacion final obtenida en la materia a partir de sus calificaciones obtenidas.
     * @param score1 Primera nota de la materia.
     * @param score2 Segunda nota de la materia.
     * @param score3 Tercera nota de la materia.
     * @param score4 Cuarta nota de la materia.
     * @return Promedio de nota final.
     */
    public int calculaDef(int score1, int score2, int score3, int score4){
        return(score1+score2+score3+score4)/4;
    }
}
