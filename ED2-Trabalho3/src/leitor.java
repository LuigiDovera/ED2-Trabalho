import Grafo.Grafo;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Matheus
 */
public class leitor {
    public static void lerTxt(Grafo g, String filePath) {
		
        JFrame screen = null;

        try {
            File inputFile = new File(filePath);

            if(inputFile.canRead()) {

                Scanner input;
                String line;
                String[] lineItem;
                double pesoTotal=0;
                try {

                    // Coletando o grafo, a primeira linha é ignorada e as restantes tornam-se os vértices e arestas
                    input = new Scanner(inputFile);
                    input.nextLine();
                    try {

                        while(input.hasNextLine()) {

                            line = input.nextLine();
                            lineItem = line.split(" ");
                            if(lineItem.length == 3) { // Grafo ponderado
                                g.put(lineItem[0], lineItem[1], Double.parseDouble(lineItem[2]));
                                pesoTotal += Double.parseDouble(lineItem[2]);
                            } else if(lineItem.length == 2) { // Grafo não ponderado
                                g.put(lineItem[0], lineItem[1]);
                            } else { // Apenas vértice em alguma linha
                                g.put(lineItem[0]);
                            }

                        }
                        if(pesoTotal != 0){
                            g.setWtotal(pesoTotal);
                        }

                    } catch(java.util.NoSuchElementException e) {

                        System.out.println("Leitura do arquivo finalizada.");

                    } 

                } catch (IOException e) {
                    e.printStackTrace();
                } 

            }

        } catch (java.lang.NullPointerException e) {
            System.out.println("Tente novamente e selecione um arquivo.");
        } catch(Exception e) {
            System.out.println("Tente novamente.");
        }
    }
}
