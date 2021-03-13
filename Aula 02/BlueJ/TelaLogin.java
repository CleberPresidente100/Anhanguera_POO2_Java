
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;

public class TelaLogin extends JFrame implements ActionListener, FocusListener {

    private JLabel lblUsuario;
    private JTextField txtUsuario;

    private JLabel lblSenha;
    private JPasswordField txtSenha;

    private JLabel lblSenha2;
    private JPasswordField txtSenha2;

    private JButton bntEntrar;
    private Container ctn;

    private Aplicacao aplicacao;


    public TelaLogin(Aplicacao aplicacao) {

        this.aplicacao = aplicacao;
        CriarTelaLogin();
    }

    public void CriarTelaLogin(){

        ConstruirLayout();
        ConfigurarEventos();
    }



    private void ConstruirLayout (){

        setSize(400,250);
        setTitle("Login");

        ctn = getContentPane();
        ctn.setLayout(null);

        lblUsuario = new JLabel("Usuário");
        txtUsuario = new JTextField();
        lblSenha = new JLabel("Senha");
        txtSenha = new JPasswordField();
        bntEntrar = new JButton("Entrar");

        lblUsuario.setBounds(0,0,100,25);
        txtUsuario.setBounds(150,0,200,25);
        lblSenha.setBounds(0,50,100,25);
        txtSenha.setBounds(150,50,200,25);
        bntEntrar.setBounds(140,160,100,50);

        ctn.add(lblUsuario);
        ctn.add(txtUsuario);
        ctn.add(lblSenha);
        ctn.add(txtSenha);
        ctn.add(bntEntrar);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    private void ConfigurarEventos(){

        // Tratamento do Clique nos Botões

        /*  setActionCommand --> Usado para criar um Nome Identificador para o Evento de Clicar no Botão.
            Pois caso exista mais de um botão na tela será necessário identificar qual foi o botão que
            gerou o evento.
            https://hajsoftutorial.com/setactioncommand-getactioncommand/
         */
        bntEntrar.setActionCommand("Entrar");
        bntEntrar.addActionListener(this);

        // Tratamento para a Perda de Foco do campo txtUsuario
        txtUsuario.setActionCommand("Usuario");
        txtUsuario.addFocusListener(this);
    }


    // Ação Executada ao se Pressionar o Botão
    public void actionPerformed(ActionEvent e){
        System.out.println("Comando: " + e.getActionCommand());

        if(e.getActionCommand() == "Entrar") validarTelaLogin();
    }


    // Ação Executada quando o campo Usuário perde o Foco
    public void focusLost(FocusEvent e){
        validarTelaLogin();
    }


    // Ação Executada quando o campo Usuário ganha o Foco
    public void focusGained(FocusEvent e){
    }



    private void validarTelaLogin(){

        String mensagemErro;
        Validacoes validacoes = new Validacoes();

        mensagemErro = validacoes.validarNomeUsuario(txtUsuario.getText());

        if(mensagemErro != null){
            JOptionPane.showMessageDialog( this, mensagemErro);
        }
    }
}



