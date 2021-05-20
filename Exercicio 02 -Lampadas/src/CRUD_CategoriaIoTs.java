
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CRUD_CategoriaIoTs {

    Connection conexao;

    public CRUD_CategoriaIoTs (Connection conexao){
        this.conexao = conexao;
    }


//    C --> Create
    

//    R -> Read
    public ArrayList<CategoriasIoTs> getListaCategorias() {

        ResultSet resposta = null;
        ArrayList<CategoriasIoTs> listaCategorias = new ArrayList<CategoriasIoTs>();

        try {
            PreparedStatement comando =
                    conexao.prepareStatement("SELECT * FROM CATEGORIAS_IOTS");
            resposta = comando.executeQuery();

            while (resposta.next()) {

                CategoriasIoTs item = new CategoriasIoTs();

                item.Id = resposta.getInt("ID");
                item.Categoria = resposta.getString("CATEGORIA");

                listaCategorias.add(item);
              }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaCategorias;
    }


//    U - Update
    

//    D - Delete
        
}
