
import Dados.Dado1;
import Leitura.Leitor;
import Ordenacoes.MergeSort;
import Ordenacoes.MergeSortPadrão;
import Ordenacoes.QuickSort;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Matheus
 */
public class Utils {
    
    static public double mediaAritimetica(List<Long> objetos) {
	double somatorio = 0;
	for (Long d : objetos) {
		somatorio += d;
	}
	return somatorio / objetos.size();
    }
    
    static public double variancia(List<Long> objetos){
        if (objetos.size() == 1) {
            return 0.0;
        } else {
            double mediaAritimetica = mediaAritimetica(objetos);
            double somatorio = 0l;
            for (int i = 0; i < objetos.size(); i++) {
                double result = objetos.get(i)- mediaAritimetica;
                somatorio = somatorio + result * result;
            }
            return Math.sqrt(((double) 1 /( objetos.size()-1))* somatorio);
            }
    }
}
