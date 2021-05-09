
import GerenciadorSensores.GerenciadorSensores;

public class Main{

    private static final int quantidadeSensoresPSC = 4;
    private static final int quantidadeSensoresXSC = 4;
    private static final int quantidadeSensoresYSC = 4;

    public static void main(String[] args) throws InterruptedException{

        GerenciadorSensores gerenciadorSensores = new GerenciadorSensores(quantidadeSensoresPSC, quantidadeSensoresXSC, quantidadeSensoresYSC);
        Tela tela = new Tela(gerenciadorSensores);

        while(true){

            Thread.sleep(1000);
            tela.AtualizarTabela();
        }
    }
}