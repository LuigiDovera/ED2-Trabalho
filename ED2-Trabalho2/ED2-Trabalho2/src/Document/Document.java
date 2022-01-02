/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Document;

/**
 *
 * @author Matheus
 */
public class Document {
    private String Nome;
    private double Peso;
    private int distTerm;
    
    public Document(String nome ,double peso, int dist){
        this.Nome = nome;
        this.Peso = peso;
        this.distTerm = dist;
    }
    public int getdisTerm(){
        return this.distTerm;
    } 
    
    public void setdisTerm(int value){
        this.distTerm = value;
    }
            
    public String getNome() {
        return Nome;
    }

    public double getPeso() {
        return Peso;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }
    
    
}
