public class Materia {
    public int score1;
    public int score2;
    public int score3;
    public int score4;
    public int def;

    public Materia() {
    }

    public Materia(int score1, int score2, int score3, int score4, int def) {
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
        this.def = def;
    }

    //metodo para calcular la definitiva
    public int totalDef(int score1, int score2, int score3, int score4){
        int total = (score1+score2+score3+score4)/4;
        return total;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public int getScore4() {
        return score4;
    }

    public void setScore4(int score4) {
        this.score4 = score4;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}
