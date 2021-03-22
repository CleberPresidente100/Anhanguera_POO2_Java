import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class Aplicacao {

    private Tela tela;
    private Conexao criarConexao;
    private Connection conexao;
    private CRUD crud;

    public Aplicacao(){

        // Estabelece a Conexão
        criarConexao = new Conexao();
        conexao = criarConexao.GetConexao();

        if(conexao != null){

            // Instancia o CRUD
            crud = new CRUD(conexao);

            // Cria a Tela
            tela = new Tela(this);
        }
    }


    public List<Aluno> getListaAlunos(){

        List<Aluno> listaAlunos = null;

        try {
            // Vai no banco buscar as informações dos Alunos
            ResultSet dados = crud.getListaAlunos();
//            if(dados.getFetchSize() > 0){
                while(dados.next()){

                    // Extrai as informações que chegaram do banco
                    int alunoId = dados.getInt("id_aluno");
                    String nome = dados.getString("nome");
                    String telefone = dados.getString("telefone");

                    // Coloca estas informações na Lista de Alunos
                    listaAlunos.add(new Aluno(alunoId, nome, telefone));
                }
//            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }

        return listaAlunos;
    }



    public String incluirAluno(Aluno aluno){

        String mensagemErro = null;
        Validacoes validacoes = new Validacoes();

        // Valida Campos
        if(!validacoes.validarNome(aluno.getNome())){
            mensagemErro = "Nome inválido";
            return mensagemErro;
        }

        if(!validacoes.validarTelefone(aluno.getTelefone())){
            mensagemErro = "Telefone inválido";
            return mensagemErro;
        }

        // Realiza inclusão no Banco de Dados
        crud.incluirAluno(aluno);

        return mensagemErro;
    }



    public String atualizarDadosAluno(Aluno aluno){

        String mensagemErro = null;
        Validacoes validacoes = new Validacoes();

        // Valida Campos
        if(!validacoes.validarNome(aluno.getNome())){
            mensagemErro = "Nome inválido";
            return mensagemErro;
        }

        if(!validacoes.validarTelefone(aluno.getTelefone())){
            mensagemErro = "Telefone inválido";
            return mensagemErro;
        }

        // Realiza Atualização no Banco de Dados
        crud.atualizarDadosAluno(aluno);

        return mensagemErro;
    }



    public String excluirAluno(int alunoId){

        // Realiza exclusão no Banco de Dados
        crud.excluirAluno(alunoId);
        return null;
    }




}
