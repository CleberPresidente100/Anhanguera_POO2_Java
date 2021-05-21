
import java.sql.Connection;



public interface I_Conexao {

    public Connection getConexao();
    public void closeConexao();    
}
