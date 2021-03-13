import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String telefone;

    private List<ClienteEstrutura> listaClientes = new ArrayList<>();

    public boolean adicionarCliente(String nome, String telefone){

        String regex = "\\D";

        String telefoneFormatado = telefone.replaceAll(regex, "");

        if(nome.isEmpty() || telefoneFormatado.isEmpty()){
            return false;
        }

        ClienteEstrutura novoCliente = new ClienteEstrutura();
        novoCliente.id = listaClientes.size();
        novoCliente.nome = nome;
        novoCliente.telefone = telefone;

        listaClientes.add(novoCliente);

        return true;
    }

    public List<ClienteEstrutura> getAllClientes (){

        return listaClientes;
    }

    public ClienteEstrutura getCliente (int id){

        for (ClienteEstrutura cliente: listaClientes
        ) {
            if(cliente.id == id){
                return cliente;
            }
        }
        return null;
    }

    public int getQuantidadeClientes(){
        return listaClientes.size();
    }




//    public Cliente (String nome, String telefone){
//        this.nome = nome;
//        this.telefone = telefone;
//    }
//
//    public String getCadastro(){
//        return nome + " : " + telefone;
//    }

}
