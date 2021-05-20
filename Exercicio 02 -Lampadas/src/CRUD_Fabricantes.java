
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CRUD_Fabricantes {

    Connection conexao;

    public CRUD_Fabricantes (Connection conexao){
        this.conexao = conexao;
    }


//    C --> Create


//    R -> Read
    public ResultSet getListaFabricantes() {
        ResultSet dados = null;
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("SELECT * FROM FABRICANTES");
            dados = comando.executeQuery();
            var teste = dados;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados;
    }


//    U - Update


//    D - Delete
    
}
