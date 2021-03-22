import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Tela  extends JFrame implements ActionListener, KeyListener {

    final Aplicacao app;

//    Objetos da Tela
    private JLabel lblNome;
    private JTextField txtNome;
    private JLabel lblTelefone;
    private JTextField txtTelefone;
    private JButton btnCadastrar;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    private JTable tabela;
    private DefaultTableModel modelo;
    private Container tela;



    public Tela(Aplicacao app){
        this.app = app;
        CriarTela();
    }


    public void CriarTela(){

        // Configura o Layout
        configurarLayout();

        // Configura Objetos
        configurarObjetos();

        // Configura os Eventos
        configurarEventos();

        setVisible(true);
    }



    private void configurarLayout(){

        setSize(400, 500);
        setTitle("Cadastro de Alunos");
        tela = getContentPane();
        tela.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    private void configurarObjetos(){

        // Configuração dos Rótulos
        lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 45, 80, 25);
        tela.add(lblNome);

        lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 85, 80, 25);
        tela.add(lblTelefone);


        // Configuração das Caixas de Texto
        txtNome = new JTextField();
        txtNome.setBounds(90, 45, 150, 25);
        tela.add(txtNome);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(90, 85, 150, 25);
        tela.add(txtTelefone);

        // Configuração dos Botões
        btnCadastrar = new JButton("Inserir");
        btnCadastrar.setBounds(10, 170, 100, 50);
        tela.add(btnCadastrar);

        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.setBounds(110, 170, 100, 50);
        tela.add(btnAtualizar);

        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(210, 170, 100, 50);
        tela.add(btnExcluir);

        // Configuração da Tabela
        modelo = new DefaultTableModel();
        tabela = new JTable(modelo);
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        JScrollPane painel = new JScrollPane(tabela);
        painel.setBounds(10, 240, 300, 200);
        tela.add(painel);

        // Popula a Tabela Criada Anteriormente
        preencherTabela();
    }



    private void preencherTabela() {

        List<Aluno> listaAlunos = app.getListaAlunos();

        modelo.setNumRows(0);

        if(listaAlunos != null){
            for (Aluno aluno: listaAlunos) {
                modelo.addRow(new Object[]{aluno.getAlunoId(), aluno.getNome(), aluno.getTelefone()});
            }
        }
    }



    private void configurarEventos(){

        // Tratamento do Clique nos Botões

        /*  setActionCommand --> Usado para criar um Nome Identificador para o Evento de Clicar no Botão.
            Pois caso exista mais de um botão na tela será necessário identificar qual foi o botão que
            gerou o evento.
            https://hajsoftutorial.com/setactioncommand-getactioncommand/
         */
        btnCadastrar.setActionCommand("Cadastrar");
        btnCadastrar.addActionListener(this);

        btnExcluir.setActionCommand("Excluir");
        btnExcluir.addActionListener(this);

        btnAtualizar.setActionCommand("Atualizar");
        btnAtualizar.addActionListener(this);


        // Tratamento de Pressionar Tecla no Campo Telefone
        txtTelefone.setName("Telefone");
        txtTelefone.addKeyListener(this);
    }


    // Ação Executada ao se Pressionar um Botão
    public void actionPerformed(ActionEvent e){

        String mensagemErro = null;

        switch (e.getActionCommand()){

            case "Cadastrar":
                Aluno aluno = new Aluno(0, txtNome.getText(), txtTelefone.getText());
                mensagemErro = app.incluirAluno(aluno);

                // Atualiza a Tabela na Tela
                preencherTabela();
                break;

            case "Excluir":
                // ID do Aluno inserido manualmente para teste
                mensagemErro = app.excluirAluno(1);
                break;

            case "Atualizar":
                // Criação do objeto apenas para teste
                mensagemErro = app.atualizarDadosAluno(new Aluno(3, "Teste", "Teste"));
                break;

            default:
                mensagemErro = "Action Command não reconhecido";
                System.out.print("DEFAULT");
        }

        if(mensagemErro != null){
            JOptionPane.showMessageDialog( this, mensagemErro);
        }
    }

    // Ação Executada ao se Pressionar uma Tecla

    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {

        if(e.getComponent().getName() == "Telefone"){

            Validacoes validacoes = new Validacoes();

            String telefone = validacoes.formatarTelefone(txtTelefone.getText());
            txtTelefone.setText(telefone);
        }
    }
}
