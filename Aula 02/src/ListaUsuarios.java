
import  java.util.ArrayList;

public class ListaUsuarios {

    private ArrayList<Usuario> lista;

    public ListaUsuarios() {
        lista = new ArrayList<Usuario>();
    }

    public void add(Usuario usuario){
        lista.add(usuario);
    }

    public ArrayList<Usuario> getLista(){
        return lista;
    }
}
