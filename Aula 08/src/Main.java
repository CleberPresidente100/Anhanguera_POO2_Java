
import GerenciadorSensores.GerenciadorSensores;

public class Main{

    private static final int quantidadeSensoresPSC = 4;
    private static final int quantidadeSensoresXSC = 4;
    private static final int quantidadeSensoresYSC = 4;

    public static void main(String[] args) throws InterruptedException{

        // Demonstração de que a Classe GerenciadorSensores é um Singleton (um MonoState na verdade)
        // Para isso são criados 3 objetos aqui e a classe Tela cria um 4º objeto no seu construtor.
        // Como a classe GerenciadorSensores é um Singleton (um MonoState na verdade), o objeto da
        // classe GerenciadorSensores criado na classe Tela conseguirá acessar os sensores adicionados
        // por cada um destes 3 objetos aqui criados.
        // Singleton e Monostate https://www.youtube.com/watch?v=yimeXZ1twWs (acessado 12/05/2021)
        GerenciadorSensores gerenciadorSensores1 = new GerenciadorSensores();
        GerenciadorSensores gerenciadorSensores2 = new GerenciadorSensores();
        GerenciadorSensores gerenciadorSensores3 = new GerenciadorSensores();
        gerenciadorSensores1.AdicionarSensores(quantidadeSensoresPSC, 0, 0);
        gerenciadorSensores2.AdicionarSensores(0, quantidadeSensoresXSC, 0);
        gerenciadorSensores3.AdicionarSensores(0, 0, quantidadeSensoresYSC);
        
        //GerenciadorSensores gerenciadorSensores = new GerenciadorSensores();
        //gerenciadorSensores.AdicionarSensores(quantidadeSensoresPSC, quantidadeSensoresXSC, quantidadeSensoresYSC);


        Tela tela = new Tela();

        while(true){

            Thread.sleep(1000);
            tela.AtualizarTabela();
        }
    }
}