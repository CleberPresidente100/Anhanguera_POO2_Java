
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class TelaUsuario extends JPanel{
    // public class TelaUsuario extends JScrollPane{

    // private Container container;
    private JPanel telaUsuario;


    // private JLabel lblTeste;
    // private JLabel lblTeste2;
    // private JLabel lblId = new JLabel("ID");
    // private JLabel lblNome = new JLabel("Nome");
    // private JLabel lblLocal = new JLabel("Local");

    // private JTextField txtId;
    // private JTextField txtNome;
    // private JTextField txtLocal;




    public TelaUsuario (){

        telaUsuario = this;
        telaUsuario.setLayout(new BoxLayout(telaUsuario, BoxLayout.Y_AXIS));
        
        CriarTela();
    }

    private void CriarTela(){

        ConstruirLayout();
    }

    private void ConstruirLayout(){

        telaUsuario.setSize(500, 500);





        
        // Criação da Estrutura do Título
        JLabel lblTitulo = new JLabel("Lista IoTs");
        lblTitulo.setBorder(new LineBorder(Color.RED));
        lblTitulo.setPreferredSize(new Dimension(500, 50));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setVerticalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(20f));


        Box boxTitulo = Box.createHorizontalBox();
        boxTitulo.setBorder(new LineBorder(Color.ORANGE));
        boxTitulo.add(Box.createHorizontalGlue());
        boxTitulo.add(Box.createVerticalStrut(50));
        boxTitulo.add(lblTitulo);
        boxTitulo.add(Box.createHorizontalGlue());


        
        // Criação da Estrutura do Cabeçalho da Tabela
        JLabel lblCabecalho01 = new JLabel("Cabeçalho01");
        lblCabecalho01.setBorder(new LineBorder(Color.YELLOW));
        lblCabecalho01.setPreferredSize(new Dimension(75, 50));
        lblCabecalho01.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblCabecalho02 = new JLabel("Cabeçalho02");
        lblCabecalho02.setBorder(new LineBorder(Color.GREEN));
        lblCabecalho02.setPreferredSize(new Dimension(150, 50));
        lblCabecalho02.setHorizontalAlignment(SwingConstants.CENTER);
        lblCabecalho02.setBackground(Color.MAGENTA);
        lblCabecalho02.setForeground(Color.BLUE);

        JButton btnCabecalhoBotao = new JButton("CabeçalhoBotão");
        btnCabecalhoBotao.setBorder(new LineBorder(Color.BLUE));
        btnCabecalhoBotao.setPreferredSize(new Dimension(150, 150));


        // Box boxCabecalho = Box.createHorizontalBox();
        // boxCabecalho.setBorder(new LineBorder(Color.MAGENTA));
        // boxCabecalho.add(lblCabecalho01);
        // boxCabecalho.add(lblCabecalho02);
        // boxCabecalho.add(btnCabecalhoBotao);
        // boxCabecalho.add(Box.createHorizontalGlue());
        // boxCabecalho.add(Box.createVerticalStrut(100));

        JPanel boxCabecalho = new JPanel();
        boxCabecalho.setBorder(new LineBorder(Color.MAGENTA));
        boxCabecalho.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        boxCabecalho.setPreferredSize(new Dimension(500, 100));
        boxCabecalho.add(Box.createRigidArea(new Dimension(10,0)));
        boxCabecalho.add(lblCabecalho01);
        boxCabecalho.add(Box.createRigidArea(new Dimension(10,0)));
        boxCabecalho.add(lblCabecalho02);
        boxCabecalho.add(Box.createRigidArea(new Dimension(10,0)));
        boxCabecalho.add(btnCabecalhoBotao);



        
        // Criação da Estrutura da Tabela
        JLabel lblTeste4 = new JLabel("Usuário");
        lblTeste4.setBorder(new LineBorder(Color.YELLOW));
        lblTeste4.setPreferredSize(new Dimension(50, 150));

        JLabel lblTeste5 = new JLabel("Usuário2");
        lblTeste5.setBorder(new LineBorder(Color.GREEN));
        lblTeste5.setPreferredSize(new Dimension(75, 75));

        JButton btnTeste6 = new JButton("Botão");
        btnTeste6.setBorder(new LineBorder(Color.BLUE));
        btnTeste6.setPreferredSize(new Dimension(150, 50));


        // Box boxTabela = Box.createHorizontalBox();
        // boxTabela.setBorder(new LineBorder(Color.BLACK));
        // boxTabela.setLayout(new BoxLayout(boxTabela, BoxLayout.X_AXIS));
        // boxTabela.add(lblTeste4);
        // boxTabela.add(lblTeste5);
        // boxTabela.add(btnTeste6);
        // boxTabela.add(Box.createHorizontalGlue());
        // boxTabela.add(Box.createVerticalStrut(30));


        JPanel boxTabela = new JPanel();
        boxTabela.setBorder(new LineBorder(Color.BLACK));
        boxTabela.setLayout(new FlowLayout());
        // boxTabela.setLayout(new BoxLayout(boxTabela, BoxLayout.X_AXIS));
        boxTabela.setPreferredSize(new Dimension(500, 200));
        boxTabela.setAlignmentX(SwingConstants.LEFT);
        boxTabela.add(lblTeste4);
        boxTabela.add(lblTeste5);
        boxTabela.add(btnTeste6);



        telaUsuario.add(boxTitulo);
        telaUsuario.add(boxCabecalho);
        telaUsuario.add(boxTabela);







        telaUsuario.setVisible(true);
    }



    public JComponent getTelaUsuario(){

        return telaUsuario;
    }
    
}
