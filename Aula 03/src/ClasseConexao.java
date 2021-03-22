import java.sql.*;

public class ClasseConexao {

    //parâmetros para conexão
    private Connection conexao;
    private String URLBD = "jdbc:mysql://localhost:3306/poo2?useSSL=false&useTimezone=true&serverTimezone=America/Sao_Paulo";
    private String usuario="root";
    private String senha="";

    //criando a conexão no construtor
    public ClasseConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URLBD,usuario,senha);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    //criando um método para acessar a conexão
    public Connection getConexao() {
        return conexao;
    }
}