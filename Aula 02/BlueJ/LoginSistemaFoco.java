import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;

public class LoginSistemaFoco  extends JFrame{

    private JLabel lblUsuario;
    private JTextField txtUsuario;

    private JLabel lblSenha1;
    private JPasswordField txtSenha1;

    private JLabel lblSenha2;
    private JPasswordField txtSenha2;

    private JButton bntInserir;
    private Container ctn;



    public LoginSistemaFoco(){

        setSize(400,250);
        setTitle("Criação de Login");

        ctn = getContentPane();
        ctn.setLayout(null);

        lblUsuario = new JLabel("Usuário");
        txtUsuario = new JTextField();
        lblSenha1 = new JLabel("Senha");
        txtSenha1 = new JPasswordField();
        lblSenha2 = new JLabel("Confirmar Senha");
        txtSenha2 = new JPasswordField();
        bntInserir = new JButton("Inserir");

        lblUsuario.setBounds(0,0,100,25);
        txtUsuario.setBounds(150,0,200,25);
        lblSenha1.setBounds(0,50,100,25);
        txtSenha1.setBounds(150,50,200,25);
        lblSenha2.setBounds(0,1000,100,25);
        txtSenha2.setBounds(150,100,200,25);
        bntInserir.setBounds(140,160,100,50);

        ctn.add(lblUsuario);
        ctn.add(txtUsuario);
        ctn.add(lblSenha1);
        ctn.add(txtSenha1);
        ctn.add(lblSenha2);
        ctn.add(txtSenha2);
        ctn.add(bntInserir);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tratamento do Clique no Botão
        bntInserir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tratarEventoBotaoInserir();
            }
        });


        // Tratamento para a Perda de Foco do campo txtUsuario
        txtUsuario.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                tratarFocoUsuario();
            }
        });
    }



    public void tratarFocoUsuario(){

        String usuario = txtUsuario.getText();

        // Verifica se o Comprimento é Menor do que 3 ou se a Primeira Letra é Diferente de Maiúscula
        if(usuario.length() < 3 || Character.isUpperCase(usuario.charAt(0)) != true){
            JOptionPane.showMessageDialog(this, "O usuário deve ter mais que 3 caracteres e começar em caixa alta.");
        }
    }



    public void tratarEventoBotaoInserir(){

        String usuario = txtUsuario.getText();
        String senha1 = new String(txtSenha1.getPassword());
        String senha2 = new String(txtSenha2.getPassword());
        JOptionPane.showMessageDialog(this, "Senha cadastrada para o usuário: " + usuario);
    }


    public  static void main(String[] args){
        LoginSistemaFoco tela = new LoginSistemaFoco();
    }
}
