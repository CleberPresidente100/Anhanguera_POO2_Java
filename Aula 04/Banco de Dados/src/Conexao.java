
import java.sql.*;

public class Conexao {

    // Parâmetros para se Estabelecer a Conexão com o Banco de Dados
    private Connection conexao;
    private String DataBaseAdrress = "localhost:3306/";
    private String DataBaseName = "aula04";
    private String Parameters = "?useSSL=false&useTimezone=true&serverTimezone=America/Sao_Paulo";
    private String URLBD = "jdbc:mysql://" + DataBaseAdrress + DataBaseName + Parameters;
    private String usuario="root";
    private String senha="";

    public Conexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URLBD,usuario,senha);
        }catch(Exception ex) {
            ex.printStackTrace();
            System.out.print(ex);
        }
    }



    // Método que retorna a Conexão com o Banco
    public Connection GetConexao() {
        return conexao;
    }
}
