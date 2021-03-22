import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUD {

    Connection conexao;

    public CRUD (Connection conexao){
        this.conexao = conexao;
    }


//    C --> Create
    public boolean incluirAluno(Aluno aluno) {
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("INSERT INTO alunos (nome,telefone) VALUES (?,?)");
//                  conexao.prepareStatement("INSERT INTO aula04.alunos (nome,telefone) VALUES (?,?)");
            comando.setString(1, aluno.getNome());
            comando.setString(2, aluno.getTelefone());
            return comando.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


//    R -> Read
    public ResultSet getListaAlunos() {
        ResultSet dados = null;
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("SELECT * FROM alunos");
//                  conexao.prepareStatement("SELECT * from aula04.alunos");
            dados = comando.executeQuery();
            var teste = dados;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dados;
    }


//    U - Update
    public boolean atualizarDadosAluno(Aluno aluno)
    {
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("UPDATE alunos SET nome=?,telefone=? WHERE id_aluno=?");
//                  conexao.prepareStatement("UPDATE aula04.alunos SET nome=?,telefone=? WHERE id_aluno=?");
            comando.setString(1, aluno.getNome());
            comando.setString(2, aluno.getTelefone());
            comando.setInt(3, aluno.getAlunoId());
            return comando.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


//    D - Delete
    public boolean excluirAluno(int alunoId)
    {
        try {
            PreparedStatement comando =
                    conexao.prepareStatement("DELETE FROM alunos WHERE id_aluno=?");
//                  conexao.prepareStatement("DELETE FROM aula04.alunos WHERE id_aluno=?");
            comando.setInt(1,alunoId);
            return comando.execute();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
