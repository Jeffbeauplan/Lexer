package techx.sopl.pr01;

public class Instruction {
    public String op;
    public Integer X;
    public Integer Y;
    
    Instruction(String op, Integer X, Integer Y) {
        this.op = op;
        this.X = X;
        this.Y = Y;
    }
    
    Instruction(String op, Integer X) {
        this.op = op;
        this.X = X;
    }
    
    Instruction(String op) {
        this.op = op;
    }
}