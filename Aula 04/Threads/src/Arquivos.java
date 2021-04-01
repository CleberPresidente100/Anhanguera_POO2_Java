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



    public void lerArquivo(String nomeArquivo, int cor){

        Scanner in;

        try {
            in = new Scanner(new FileReader(localArquivos + nomeArquivo));
            while(in.hasNext())
            {
                String[] dados = in.next().split(";");
                String placa = dados[0];
                String valor = dados[1];

                switch (cor){
                    case 1:
                        System.out.print(Cores.RED);
                        break;
                    case 2:
                        System.out.print(Cores.GREEN);
                        break;
                    default:
                        System.out.print(Cores.WHITE);
                        break;

                }
                System.out.println("Placa do carro : \"" + placa + "\" --> Valor da multa : R$ " + valor);
                System.out.print(Cores.RESET);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
