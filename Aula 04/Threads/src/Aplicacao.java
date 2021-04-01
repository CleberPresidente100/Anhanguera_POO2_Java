import java.io.File;

public class Aplicacao {

    private String localArquivos;
    private File[] listaArquivos;
    private Arquivos arquivos;
    private String nomeArquivo;


    public Aplicacao() {

        // O local do Arquivo deveria ser inserido pelo usuário
        // Mas está sendo passado por aqui para fins didáticos.
        localArquivos = "Multas\\";
        arquivos = new Arquivos(localArquivos);
        listaArquivos = arquivos.listaArquivos();
    }


    public void inciar()
    {
        int cor = 0;
        for (var arquivo : listaArquivos) {
            if (arquivo.isFile()) {
                cor++;
                nomeArquivo = arquivo.getName();
                var threadsMultas = new ThreadsMultas(nomeArquivo, localArquivos, cor);
            }
        }
    }
}
