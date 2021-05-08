import GerenciadorSensores.GerenciadorSensores;

public class Main{

    private static final int quantidadeSensoresPSC = 4;
    private static final int quantidadeSensoresXSC = 4;
    private static final int quantidadeSensoresYSC = 4;

    public static void main(String[] args){

        GerenciadorSensores gerenciadorSensores = new GerenciadorSensores(quantidadeSensoresPSC, quantidadeSensoresXSC, quantidadeSensoresYSC);

        System.out.print("\n\nTeste\n\n");

    }

}