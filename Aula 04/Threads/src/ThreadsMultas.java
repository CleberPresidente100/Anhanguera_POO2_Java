public class ThreadsMultas implements Runnable {

    private Thread thread;
    private Arquivos arquivos;
    private String nomeArquivo;
    private String localArquivos;
    private int cor;


    public ThreadsMultas(String nomeArquivo, String localArquivos, int cor){

        this.nomeArquivo = nomeArquivo;
        this.localArquivos = localArquivos;
        this.cor = cor;

        thread = new Thread(this);
        thread.start();
    }

    public void run() {

        arquivos = new Arquivos(localArquivos);

        if(nomeArquivo != null && nomeArquivo != ""){
            arquivos.lerArquivo(nomeArquivo, cor);
        }
    }
}
