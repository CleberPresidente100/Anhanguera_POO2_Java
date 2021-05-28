import java.util.ArrayList;

public class Main{

    public static void main(String[] args) throws InterruptedException{

        // ConexaoMySQL conexaoMySQL = new ConexaoMySQL();

        // CRUD_IoTs crud_IoTs = new CRUD_IoTs(conexaoMySQL.getConexao());
        // CRUD_Fabricantes crud_Fabricantes = new CRUD_Fabricantes(conexaoMySQL.getConexao());
        // CRUD_CategoriasIoTs crud_CategoriaIoTs = new CRUD_CategoriasIoTs(conexaoMySQL.getConexao());

        // ArrayList<IoTs> listaIoTs = crud_IoTs.getListaIoTs();
        // ArrayList<Fabricantes> listaFabricantes = crud_Fabricantes.getListaFabricantes();
        // ArrayList<CategoriasIoTs> listaCategoriasIoTs = crud_CategoriaIoTs.getListaCategorias();

        // ListaIoTs listaIoTs2 = new ListaIoTs();
        // listaIoTs2.inicializaListaIoTs(conexaoMySQL);
        // ListaFabricantes listaFabricantes2 = new ListaFabricantes();
        // listaFabricantes2.iniciazliaListaFabricantes(conexaoMySQL);
        // ListaCategoriasIoTs listaCategoriasIoTs2 = new ListaCategoriasIoTs();
        // listaCategoriasIoTs2.inicializarListaCategoriasIoTs(conexaoMySQL);






        // TelaAdministrador telaAdministrador = new TelaAdministrador();
        // Tela tela1 = new Tela("Administração",
        //                      EnumMenus.OPCOES,
        //                      telaAdministrador.getTelaAdministrador()
        //                     );

        TelaLampadas telaUsuario = new TelaLampadas();
        Tela tela2 = new Tela("Teste Usuário",
                                EnumMenus.LISTA_IOTS,
                                telaUsuario
                            );

        // TelaListaIoTs telaIoTs = new TelaListaIoTs();
        // Tela tela3 = new Tela("Tela IoTs",
        //                         EnumMenus.LISTA_IOTS,
        //                         telaIoTs.getTelaListaIoTs()
        //                     );


        ListaTelas listaTelas = new ListaTelas();
        // listaTelas.adicionarTela(tela1);
        listaTelas.adicionarTela(tela2);
        // listaTelas.adicionarTela(tela3);

        TelaPrincipal telaPrincipal = new TelaPrincipal(listaTelas.getListaTelas());


        // System.out.print("PROGRAMA ENCERRADO");

        // conexaoMySQL.closeConexao();
        
    }
}