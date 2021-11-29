package Dados;

public class Dado2 implements Comparable<Dado2>{
    private double chave;
    private String valor;

    public Dado2(double chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public double getChave() {
        return chave;
    }

    public void setChave(double chave) {
        this.chave = chave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    /*Se for A<B, sendo A o dado que chamou o método
            -1: para A<B
            0: para A==B
            1: para A>B
    */
    
    @Override
    public int compareTo(Dado2 B) {                            
        Dado2 dado =  B;
        if(this.getChave() < dado.getChave())                     
            return -1;
        else if (this.getChave()==B.getChave())       
            return 0;
        else
            return 1;                                          
    }
    
    public String toString() {
        return "key = "+this.chave +"; value:" +this.valor;
    }


    }

