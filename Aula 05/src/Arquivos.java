import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Arquivos {

    private String localArquivos;

    public Arquivos(String localArquivos){
        this.localArquivos = localArquivos;
    }



    public File[] listaArquivos(){
        File diretorio = new File(localArquivos);
        return diretorio.listFiles();
    }



    public void lerArquivo(String nomeArquivo){

        Scanner in;

        try {
            in = new Scanner(new FileReader(localArquivos + nomeArquivo));
            while(in.hasNextLine())
            {
                String dados = in.nextLine();

                System.out.println(dados);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
