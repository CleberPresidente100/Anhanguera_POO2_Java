
import java.sql.Connection;
import java.util.ArrayList;



public class ListaIoTs {

    private static Connection conexao;
    private static CRUD_IoTs crud_IoTs;
    private static ArrayList<IoTs> listaIoTs;



    public ListaIoTs(){

    }



    public void inicializaListaIoTs(I_Conexao conexao){

        if(ListaIoTs.crud_IoTs == null){

            ListaIoTs.conexao = conexao.getConexao();

            ArrayList<IoTs> lista;
            ListaIoTs.crud_IoTs = new CRUD_IoTs(conexao.getConexao());
            lista = ListaIoTs.crud_IoTs.getListaIoTs();

            ListaIoTs.listaIoTs = ObterDescricoesChavesEstrangeiras(lista);
        }
    }



    public ArrayList<IoTs> getListaIoTs(){
        return ListaIoTs.listaIoTs;
    }



    public IoTs getIoT(int idIoT){

        for (IoTs item : listaIoTs) {
            
            if(item.Id == idIoT){
                return item;
            }
        }
        
        return null;
    }



    public void updateListaIoTs(){

        ArrayList<IoTs> lista;

        lista = ListaIoTs.crud_IoTs.getListaIoTs();
        ListaIoTs.listaIoTs = ObterDescricoesChavesEstrangeiras(lista);
        // ListaIoTs.listaIoTs = ListaIoTs.crud_IoTs.getListaIoTs();
    }



    public boolean incluirIoT(IoTs novoIoT){

        boolean resultado;

        CRUD_IoTs crud_IoTs = new CRUD_IoTs(ListaIoTs.conexao);

        resultado = crud_IoTs.incluirIoT(novoIoT);
        
        updateListaIoTs();

        return resultado;
    }



    public boolean atualizarIoT(IoTs novoIoT){

        boolean resultado;

        CRUD_IoTs crud_IoTs = new CRUD_IoTs(ListaIoTs.conexao);

        resultado = crud_IoTs.atualizarDadosIoT(novoIoT);
        
        updateListaIoTs();

        return resultado;
    }



    public boolean excluirIoT(int idIoT){

        boolean resultado;

        CRUD_IoTs crud_IoTs = new CRUD_IoTs(ListaIoTs.conexao);

        resultado = crud_IoTs.excluirIoT(idIoT);
        
        updateListaIoTs();

        return resultado;
    }



    private ArrayList<IoTs> ObterDescricoesChavesEstrangeiras(ArrayList<IoTs> lista){
        
        CRUD_Fabricantes crud_Fabricantes = new CRUD_Fabricantes(ListaIoTs.conexao);
        CRUD_CategoriasIoTs crud_CategoriasIoTs = new CRUD_CategoriasIoTs(ListaIoTs.conexao);
        
        ArrayList<IoTs> listaAtualizada = new ArrayList<IoTs>();
        ArrayList<Fabricantes> listaFabricantes = new ArrayList<Fabricantes>();
        ArrayList<CategoriasIoTs> listaCategoriasIoTs = new ArrayList<CategoriasIoTs>();

        listaFabricantes = crud_Fabricantes.getListaFabricantes();
        listaCategoriasIoTs = crud_CategoriasIoTs.getListaCategorias();

        for(IoTs item : lista){

            if(item.FabricanteId > 0){

                for(Fabricantes fabricante: listaFabricantes){

                    if(item.FabricanteId == fabricante.Id){
    
                        item.NomeFabricante = fabricante.Fabricante;
                    }
                }
            }

            if(item.CategoriaId > 0){
                
                for(CategoriasIoTs categoria : listaCategoriasIoTs){

                    if(item.CategoriaId == categoria.Id){
    
                        item.NomeCategoria = categoria.Categoria;
                    }
                }
            }

            listaAtualizada.add(item);           
        }

        return listaAtualizada;
    }
    
}
