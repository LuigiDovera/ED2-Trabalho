package Dados;

public class Dado3 implements Comparable<Dado3>{
    private int chave;
    private int[] valor;

    public Dado3(int chave, int[] valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int[] getValor() {
        return valor;
    }

    public void setValor(int[] valor) {
        this.valor = valor;
    }
    
    /*Se for A<B, sendo A o dado que chamou o método
            -1: para A<B
            0: para A==B
            1: para A>B
    */

    @Override
    public int compareTo(Dado3 B) {                            
        Dado3 dado = (Dado3) B;
        if(this.getChave()<dado.getChave())                    
            return -1;
        else if (this.getChave()== dado.getChave())       
            return 0;
        else
            return 1;                                          
    }
    
    public String toString() {
        return "key = "+this.chave +"; value:" +this.valor;
    }
}
