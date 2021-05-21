
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CRUD_Fabricantes {

    private static Connection conexao;

    public CRUD_Fabricantes (Connection conexao){
        CRUD_Fabricantes.conexao = conexao;
    }


//    C --> Create


//    R -> Read
    public ArrayList<Fabricantes> getListaFabricantes() {

        ResultSet resposta = null;
        ArrayList<Fabricantes> listaFabricantes = new ArrayList<Fabricantes>();

        try {
            PreparedStatement comando =
                    conexao.prepareStatement("SELECT * FROM FABRICANTES");
            resposta = comando.executeQuery();

            while (resposta.next()) {

                Fabricantes item = new Fabricantes();

                item.Id = resposta.getInt("ID");
                item.Fabricante = resposta.getString("FABRICANTE");

                listaFabricantes.add(item);
              }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaFabricantes;
    }


//    U - Update


//    D - Delete
    
}
