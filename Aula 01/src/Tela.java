
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class Tela extends JFrame{

    private JLabel labelNome;
    private JLabel labelTelefone;
    private JLabel labelStatus;
    private JLabel campoStatus;
    //private JFormattedTextField campoNome;
    private JTextField campoNome;
    private JFormattedTextField campoTelefone;
    private JButton botaoCadastrar;
    private Container cnt;
    private JTextArea campoListaClientes;
    private JLabel labelListaClientes;



    public Tela (){

        montarTela();
    }

    private void montarTela(){

        Cliente clientes = new Cliente();

        cnt = this.getContentPane();
        cnt.setLayout(null);

        // Criando Objetos
        labelNome = new JLabel("Nome: ");
        labelTelefone = new JLabel("Telefone: ");
        labelStatus = new JLabel("Clientes Cadastrados: ");
        campoStatus = new JLabel("");
        campoNome = new JTextField();
        botaoCadastrar = new JButton("Cadastrar");
        campoListaClientes = new JTextArea();
        labelListaClientes = new JLabel("Lista de Clientes");

        try{

            //campoNome = new JFormattedTextField();
            //campoNome.setColumns(10);

            campoTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));

        } catch (ParseException e){
            e.printStackTrace();
        }

        // // Configurando Objetos
        labelNome.setBounds(10,10,100,30);
        campoNome.setBounds(100,10,200,30);
        campoNome.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyReleased(KeyEvent e) {

                char caractere = e.getKeyChar();

                if(!Character.isLetter(caractere) && !Character.isWhitespace(caractere)){
                    if(e.getKeyChar() != KeyEvent.CHAR_UNDEFINED){
                        String texto = campoNome.getText();
                        if(texto.length() > 0){
                            texto = texto.substring(0, texto.length() - 1);
                            campoNome.setText(texto);
                        }
                    }
                }
            }
        });

        labelTelefone.setBounds(10,60,100,30);
        campoTelefone.setBounds(100,60,200,30);

        labelStatus.setBounds(10,200,150,30);
        campoStatus.setBounds(150,200,200,30);
        atualizarStatus(clientes);

        botaoCadastrar.setBounds(50,120,200,30);
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var cadastroRealizado = clientes.adicionarCliente(campoNome.getText(), campoTelefone.getText());

                if(!cadastroRealizado){
                    JOptionPane.showMessageDialog( null, "Nome ou Telefone inválido.");
                    return;
                }

                atualizarStatus(clientes);
                atualizarListaClientes(clientes);
                campoNome.setText("");
                campoTelefone.setText("");
                JOptionPane.showMessageDialog( null, "Cadastro Realizado com Sucesso.");
            }
        });

        labelListaClientes.setBounds(315,10,100,10);
        campoListaClientes.setBounds(315,25,250,200);
        campoListaClientes.setEditable(false);


        // Adicionando Objetos no Frame
        cnt.add(labelNome);
        cnt.add(labelTelefone);
        cnt.add(labelStatus);
        cnt.add(campoStatus);
        cnt.add(campoNome);
        cnt.add(campoTelefone);
        cnt.add(botaoCadastrar);
        cnt.add(campoListaClientes);
        cnt.add(labelListaClientes);


        // Configurando Frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cadastro de Cliente");
        this.setSize(600, 300);
        this.setVisible(true);


    }


    private void atualizarStatus(Cliente clientes){

        campoStatus.setText(clientes.getQuantidadeClientes() + " Clientes Cadastrados.");
    }


    private void atualizarListaClientes(Cliente clientes){

        List<ClienteEstrutura> listaClientes = new ArrayList<>();
        String texto = "";

        listaClientes = clientes.getAllClientes();

        for (ClienteEstrutura cliente: listaClientes
        ) {
            texto += cliente.nome + " : " + cliente.telefone + "\n";
        }

        campoListaClientes.setText(texto);
    }
}
