
import java.sql.*;


public class ConexaoMySQL implements I_Conexao{
    
    // Parâmetros para se Estabelecer a Conexão com o Banco de Dados
    private static Connection conexao;
    private static final String DataBaseAdrress = "den1.mysql6.gear.host";
    private static final String DataBaseName = "gerenciadoriots";
    // private static final String Parameters = "";
    private static final String URLDB = "jdbc:mysql://" + DataBaseAdrress + "/" + DataBaseName;// + Parameters;
    private static final String usuario = "gerenciadoriots";
    private static final String senha = "Un8XM~6L3zJ_";



    public ConexaoMySQL(){

        if(ConexaoMySQL.conexao == null){

            System.out.print("\n\n\nEndereço --> " + URLDB + "\n\n");

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                ConexaoMySQL.conexao = DriverManager.getConnection(URLDB, usuario, senha);
                System.out.print("Conexão com o Banco de Dados \"" + DataBaseAdrress + "/" + DataBaseName + "\" foi estabelecida com Sucesso !\n\n\n");
            }
            catch(Exception ex){
                ex.printStackTrace();
                System.out.print(ex);
            }
        }
    }



    public Connection getConexao(){
        return ConexaoMySQL.conexao;
    }



    public void closeConexao(){

        if(ConexaoMySQL.conexao != null){

            try{

                ConexaoMySQL.conexao.close();
                System.out.print("Conexão com o Banco de Dados \"" + DataBaseAdrress + "/" + DataBaseName + "\" foi encerrada com Sucesso !");
            }
            catch(Exception ex){
                ex.printStackTrace();
                System.out.print(ex);
            }
        }
    }

    
}

/*

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
*/
