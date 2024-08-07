import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LerEscreverCSV {

    public static void main(String[] args) {
        
        //mac
        String csvArquivoIn = "/Users/joaquimcastellsjo/Documents/VisualCode/tratamentoarquivos/entrada.csv";
        String csvArquivoOut = "/Users/joaquimcastellsjo/Documents/VisualCode/tratamentoarquivos/saida.csv";

        //windows
        //String csvArquivo = "//Users//joaquimcastellsjo//documentos//VisualCode//tratamentoarquivos//entrada.csv";
   
        BufferedReader conteudoCSV = null;
        BufferedWriter conteudoWriter = null;
    
        String linha ="";
        String csvSeparadorCampo = ";";

        try {
            conteudoCSV = new BufferedReader(new FileReader(csvArquivoIn));
            conteudoWriter = new BufferedWriter(new FileWriter(csvArquivoOut));
            int i = 0;
            while ( (linha = conteudoCSV.readLine()) != null) {
                String[] registro = linha.split(csvSeparadorCampo);
                //System.out.println(linha);
                
                System.out.println(registro[0] +" - " + registro[1]);
                
                String texto = "registro saida " + registro[0] +" ; " + registro[1] +"\n";
                conteudoWriter.append(texto);
                i++;
            }
            System.out.println("Linhas encontradas: " + i);;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
        } catch (IOException e) {
            System.out.println("IO error :\n" + e.getMessage());           
        } finally {
            if (conteudoCSV != null) {
                try {
                    conteudoCSV.close();
                    conteudoWriter.close();
                    System.out.println("Arquivos encerrados");
                }
                catch (IOException e) {
                    System.out.println("IO error :\n" + e.getMessage());   
                }
            }
        }    
    }

}
