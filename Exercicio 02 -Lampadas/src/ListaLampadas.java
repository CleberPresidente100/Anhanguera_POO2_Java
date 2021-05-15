import java.util.ArrayList;

// Caso não se utilize o Banco de Dados, esta classe MonoState pode ser
// utilizada para se armazenar os dados.
public class ListaLampadas {

    private ArrayList<Lampada> listaLampadas = null;

    // MonoState
    public ListaLampadas(){

        if(listaLampadas == null){
            listaLampadas = new ArrayList<Lampada>();
        }
    }

    public void addLampada(Lampada lampada){
        listaLampadas.add(lampada);
    }

    public ArrayList<Lampada> getListaLampadas(){
        return listaLampadas;
    }

    public void editarLampada(Lampada lampada, Lampada novaLampada){

        listaLampadas.remove(lampada);
        listaLampadas.add(novaLampada);
    }
}
