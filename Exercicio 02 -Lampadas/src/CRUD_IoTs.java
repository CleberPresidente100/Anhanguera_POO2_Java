
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CRUD_IoTs {

    private static Connection conexao;

    public CRUD_IoTs (Connection conexao){
        CRUD_IoTs.conexao = conexao;
    }


//    C --> Create
    public boolean incluirIoT(IoTs iot) {
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("INSERT INTO IOTS (Id, CategoriaId, FabricanteId, Nome, Localizacao) VALUES (?,?,?,?,?)");
            comando.setInt(1, iot.Id);
            comando.setInt(2, iot.CategoriaId);
            comando.setInt(3, iot.FabricanteId);
            comando.setString(4, iot.Nome);
            comando.setString(5, iot.Localizacao);
            return comando.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


//    R -> Read
    public ArrayList<IoTs> getListaIoTs() {

        ResultSet resposta = null;
        ArrayList<IoTs> listaIoTs = new ArrayList<IoTs>();


        try {
            
            PreparedStatement comando = conexao.prepareStatement("SELECT * FROM IOTS");
            resposta = comando.executeQuery();

            while (resposta.next()) {

                IoTs item = new IoTs();

                item.Id = resposta.getInt("ID");
                item.CategoriaId = resposta.getInt("CATEGORIA_ID");
                item.FabricanteId = resposta.getInt("FABRICANTE_ID");
                item.Nome = resposta.getString("NOME");
                item.Localizacao = resposta.getString("LOCALIZACAO");

                listaIoTs.add(item);
              }

        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return listaIoTs;
    }


//    U - Update
    public boolean atualizarDadosIoT(IoTs iot)
    {
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("UPDATE IOTS SET CategoriaId=?, FabricanteId=?, Nome=?, Localizacao=? WHERE id=?");
            comando.setInt(1, iot.CategoriaId);
            comando.setInt(2, iot.FabricanteId);
            comando.setString(3, iot.Nome);
            comando.setString(4, iot.Localizacao);
            comando.setInt(5, iot.Id);
            return comando.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


//    D - Delete
    public boolean excluirIoT(int idIoT)
    {
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("DELETE FROM IOTS WHERE id=?");
            comando.setInt(1, idIoT);
            return comando.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
