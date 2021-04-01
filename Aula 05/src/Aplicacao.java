
import java.io.File;


public class Aplicacao {

    private String localArquivos;
    private File[] listaArquivos;
    private Arquivos arquivos;
    private String nomeArquivo;


    public Aplicacao() {

        // O local do Arquivo deveria ser inserido pelo usuário
        // Mas está sendo passado por aqui para fins didáticos.
        localArquivos = "NotasFiscais\\";
        arquivos = new Arquivos(localArquivos);
        listaArquivos = arquivos.listaArquivos();
    }


    public void inciar()
    {
        for (var arquivo : listaArquivos) {
            if (arquivo.isFile()) {
                nomeArquivo = arquivo.getName();
                arquivos.lerArquivo(nomeArquivo);
            }
        }
    }
}
