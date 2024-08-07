import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerCSV {

    public static void main(String[] args) {
        
        //mac
        String csvArquivo = "/Users/joaquimcastellsjo/Documents/VisualCode/tratamentoarquivos/entrada.csv";

        //windows
        //String csvArquivo = "//Users//joaquimcastellsjo//documentos//VisualCode//tratamentoarquivos//entrada.csv";
   
        BufferedReader conteudoCSV = null;
    
        String linha ="";
        String csvSeparadorCampo = ";";

        try {
            conteudoCSV = new BufferedReader(new FileReader(csvArquivo));
            int i = 0;
            while ( (linha = conteudoCSV.readLine()) != null) {
                String[] registro = linha.split(csvSeparadorCampo);
                //System.out.println(linha);
                System.out.println(registro[0] +" - " + registro[1]);
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
                    System.out.println("Arquivo encerrado");
                }
                catch (IOException e) {
                    System.out.println("IO error :\n" + e.getMessage());   
                }
            }
        }    
    }

}
