
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CRUD_CategoriaIoTs {

    Connection conexao;

    public CRUD_CategoriaIoTs (Connection conexao){
        this.conexao = conexao;
    }


//    C --> Create
    

//    R -> Read
    public ResultSet getListaCategorias() {
        ResultSet dados = null;
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("SELECT * FROM CATEGORIAS_IOTS");
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
