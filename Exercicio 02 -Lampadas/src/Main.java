import java.util.ArrayList;

public class Main{

    public static void main(String[] args) throws InterruptedException{

        // Lampada lampada01 = new Lampada();
        // Lampada lampada02 = new Lampada();
        // Lampada lampada03 = new Lampada();
        // Lampada lampada04 = new Lampada();

        // lampada01.setId(1);
        // lampada01.setLocalizacao("Sala");
        // lampada01.setNome("Lampada01");

        // lampada02.setId(2);
        // lampada02.setLocalizacao("Sala");
        // lampada02.setNome("Lampada02");

        // lampada03.setId(3);
        // lampada03.setLocalizacao("Sala");
        // lampada03.setNome("Lampada03");

        // lampada04.setId(4);
        // lampada04.setLocalizacao("Sala");
        // lampada04.setNome("Lampada04");

        // ListaLampadas listaLampadas = new ListaLampadas();

        // listaLampadas.addLampada(lampada01);
        // listaLampadas.addLampada(lampada04);
        // listaLampadas.addLampada(lampada03);

        // listaLampadas.editarLampada(lampada04, lampada02);


        ArrayList<String> listaIDs = new ArrayList<String>();
        ArrayList<String> listaTiposIoTs = new ArrayList<String>();


        listaIDs.add("1");
        listaIDs.add("2");
        listaIDs.add("3");

        listaTiposIoTs.add("Lâmpada");
        listaTiposIoTs.add("Sensor Temperatura");




        TelaUsuario telaUsuario = new TelaUsuario();
        Tela tela1 = new Tela("Teste Usuário",
                             EnumMenus.OPCOES,
                             telaUsuario
                            );

        TelaAdministrador telaAdministrador = new TelaAdministrador(listaIDs, listaTiposIoTs);
        Tela tela2 = new Tela("Teste Administrador23",
                             EnumMenus.LISTA_IOTS,
                             telaAdministrador.getTelaAdministrador()
                            );



        ListaTelas listaTelas = new ListaTelas();
        listaTelas.adicionarTela(tela1);
        listaTelas.adicionarTela(tela2);

        TelaPrincipal telaPrincipal = new TelaPrincipal(listaTelas.getListaTelas());
        
    }
}