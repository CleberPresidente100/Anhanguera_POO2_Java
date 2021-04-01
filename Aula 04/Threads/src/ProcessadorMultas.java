
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class ProcessadorMultas implements Runnable{

    private Thread th;
    private String caminhosArquivos;
    private int qtdFiles;
    private int arquivoAtual;

    public ProcessadorMultas(String pCaminhosArquivos)
    {
        th = new Thread(this);
        caminhosArquivos = pCaminhosArquivos;
    }


    public void inciar()
    {
        th.start();
    }


    public void run() {
        File diretorio = new File(caminhosArquivos);
        File[] listaDeArquivos = diretorio.listFiles();
        qtdFiles = listaDeArquivos.length;
        for (int i = 0; i < listaDeArquivos.length; i++) {
            arquivoAtual = i;
            if (listaDeArquivos[i].isFile()) {
                String nomeArquivos = listaDeArquivos[i].getName();
                processaMulta(caminhosArquivos+nomeArquivos);
            }
        }
    }


    public void processaMulta(String nomeArquivo)
    {
        Scanner in;
        try {
            in = new Scanner(new FileReader(nomeArquivo));
            while(in.hasNext())
            {
                String[] dados = in.next().split(";");
                String placa = dados[0];
                String valor = dados[1];
                System.out.println("Placa do carro " + placa + " Valor da multa "+ valor);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ProcessadorMultas pa1 = new ProcessadorMultas("Multas\\");
        pa1.inciar();
    }
}
