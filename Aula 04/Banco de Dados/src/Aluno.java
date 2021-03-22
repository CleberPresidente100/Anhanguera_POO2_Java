
public class Aluno {

    private int alunoId;
    private String nome;
    private String telefone;

    public Aluno(int alunoId, String nome, String telefone){

        this.alunoId = alunoId;
        this.nome = nome;
        this.telefone = telefone;

    }

    public String getNome(){
        return nome;
    }

    public int getAlunoId(){
        return alunoId;
    }

    public String getTelefone(){
        return telefone;
    }
}
