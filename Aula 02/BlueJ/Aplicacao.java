


public class Aplicacao {

    private TelaLogin telaLogin;
    private ListaUsuarios listaUsuarios;


    public Aplicacao (){

        listaUsuarios = new ListaUsuarios();
        telaLogin = new TelaLogin(this);
    }

    public void CadastrarUsuario(String usuario, String senha){

        Usuario novoUsuario = new Usuario(usuario, senha);
        listaUsuarios.add(novoUsuario);
        return;
    }
}
