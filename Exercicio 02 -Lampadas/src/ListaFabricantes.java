
import java.util.ArrayList;



public class ListaFabricantes {

    private static CRUD_Fabricantes crud_Fabricantes;
    private static ArrayList<Fabricantes> listaFabricantes;



    public ListaFabricantes(){
        
    }


    public void iniciazliaListaFabricantes(I_Conexao conexao){

        if(ListaFabricantes.crud_Fabricantes == null){

            ListaFabricantes.crud_Fabricantes = new CRUD_Fabricantes(conexao.getConexao());
            ListaFabricantes.listaFabricantes = ListaFabricantes.crud_Fabricantes.getListaFabricantes();
        }
    }



    public ArrayList<Fabricantes> getListaFabricantes(){
        return ListaFabricantes.listaFabricantes;
    }



    public void updateListaFabricantes(){

        ListaFabricantes.listaFabricantes = ListaFabricantes.crud_Fabricantes.getListaFabricantes();
    }
    
}
