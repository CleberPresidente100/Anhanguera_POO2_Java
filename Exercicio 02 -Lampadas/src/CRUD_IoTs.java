
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class CRUD_IoTs {

    Connection conexao;

    public CRUD_IoTs (Connection conexao){
        this.conexao = conexao;
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
    public ResultSet getListaIoTs() {
        ResultSet dados = null;
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("SELECT * FROM IOTS");
            dados = comando.executeQuery();
            var teste = dados;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados;
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
