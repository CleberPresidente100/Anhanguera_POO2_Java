
import java.util.ArrayList;



public class ListaCategoriasIoTs {

    private static CRUD_CategoriasIoTs crud_CategoriasIoTs;
    private static ArrayList<CategoriasIoTs> listaCategoriasIoTs;



    public ListaCategoriasIoTs(){

    }

    
    public void inicializarListaCategoriasIoTs(I_Conexao conexao){

        if(ListaCategoriasIoTs.crud_CategoriasIoTs == null){

            ListaCategoriasIoTs.crud_CategoriasIoTs = new CRUD_CategoriasIoTs(conexao.getConexao());
            ListaCategoriasIoTs.listaCategoriasIoTs = ListaCategoriasIoTs.crud_CategoriasIoTs.getListaCategorias();
        }
    }



    public ArrayList<CategoriasIoTs> getListaCategoriasIoTs(){
        return ListaCategoriasIoTs.listaCategoriasIoTs;
    }



    public void updateListaCategoriasIoTs(){

        ListaCategoriasIoTs.listaCategoriasIoTs = ListaCategoriasIoTs.crud_CategoriasIoTs.getListaCategorias();
    }
    
}
