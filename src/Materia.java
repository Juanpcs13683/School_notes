public class Materia extends Student{
    public String materia;
    public int score1;
    public int score2;
    public int score3;
    public int score4;
    public int def;

    public Materia() {
    }

    public Materia(String materia, int score1, int score2, int score3, int score4, int def) {
        this.materia = materia;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.def = def;
    }

    //metodo para calcular la definitiva
    public int calculaDef(int score1, int score2, int score3, int score4){
        return(score1+score2+score3+score4)/4;
    }
}
