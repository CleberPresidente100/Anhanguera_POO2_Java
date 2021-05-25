
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
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
                    conexao.prepareStatement("INSERT INTO IOTS (CATEGORIA_ID, FABRICANTE_ID, NOME, LOCALIZACAO) VALUES (?,?,?,?)");
            comando.setInt(1, iot.CategoriaId);
            if(iot.FabricanteId == null || iot.FabricanteId == 0){
                comando.setNull(2, Types.INTEGER);
            }
            else{
                comando.setInt(2, iot.FabricanteId);
            }
                // comando.setInt(2, iot.FabricanteId);
            comando.setString(3, iot.Nome);
            comando.setString(4, iot.Localizacao);
            comando.execute();
            return true;

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
                    conexao.prepareStatement("UPDATE IOTS SET CATEGORIA_ID=?, FABRICANTE_ID=?, NOME=?, LOCALIZACAO=? WHERE id=?");
            comando.setInt(1, iot.CategoriaId);
            if(iot.FabricanteId == null || iot.FabricanteId == 0){
                comando.setNull(2, Types.INTEGER);
            }
            else{
                comando.setInt(2, iot.FabricanteId);
            }
            comando.setString(3, iot.Nome);
            comando.setString(4, iot.Localizacao);
            comando.setInt(5, iot.Id);
            comando.execute();
            return true;

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
            comando.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
