
import java.util.ArrayList;



public class ListaTelas {

    private ArrayList<Tela> listaTelas;


    public ListaTelas(){

        if(listaTelas == null){
            
            listaTelas = new ArrayList<Tela>();
        }

    }



    public void adicionarTela(Tela tela){
        
        listaTelas.add(tela);
    }



    public ArrayList<Tela> getListaTelas(){
        
        return listaTelas;
    }
    
}
