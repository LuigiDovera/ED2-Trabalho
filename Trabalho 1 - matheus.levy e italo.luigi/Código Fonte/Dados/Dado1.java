    package Dados;

public class Dado1 implements Comparable<Dado1>{
    private String chave;
    private double valor;

    public Dado1(String chave, double valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }



    /* Retorno:
        -1 : A<B
         0 : A==B
         1 : A>B
    */

    @Override
    public int compareTo(Dado1 B) {
        //Para compararmos os valor em String vamos usar o valor como sendo a ordem alfabetica
        //Assim A>B>C>D>E e assim por diante, sendo o maior elemento o A e o menor o Z.
        Dado1 dado =  B;
        dado.getChave().toUpperCase();              //Trabalhando somente com maiusculas
        int tamanhoString1 = this.getChave().length();
        int tamanhoString2 = dado.getChave().length();

        if(this.getChave().equals(dado.getChave()))     //Verifica se as duas string são iguais
            return 0;       //retorna 0 se as strings são iguais
        else {
            int i = 0;
            while (i < tamanhoString1 && i < tamanhoString2) {
                if ((int) this.getChave().charAt(i) < (int) ((Dado1) B).getChave().charAt(i)) {
                    return -1;    //Retorna 1 se achou um caractere de A que menor que o caractere de B
                }else if((int) this.getChave().charAt(i) > (int) ((Dado1) B).getChave().charAt(i)){
                    return 1;     //Retorna -1 se achou um caractere de A que é maior que o caractere de B
                }
                i++;
            }
            if(i<tamanhoString1) {
                return -1; //Todos os caracteres são iguais mas a string A é menor que a string B
            }else {
                return 1;  //Todos os caracteres são iguais mas a string A é maior que a string B
            }
        }
    }

    @Override
    public String toString() {
        return "key = "+this.chave +"; value:" +this.valor;
    }

    
}
