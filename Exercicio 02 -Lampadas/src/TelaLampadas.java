
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class TelaLampadas extends JPanel{
    // public class TelaLampadas extends JScrollPane{

    private JPanel telaLampadas;
    private JComponent[][] matrizTabela;

    // Constantes da Tabela
    private static final Color COR_BORDA = Color.BLACK;
    private static final Color COR_FUNDO_CABECALHO = Color.LIGHT_GRAY;
    private static final Color COR_FUNDO_TABELA = Color.WHITE;

    private static final int ALTURA_LINHA_CABECALHO = 50;
    private static final int ALTURA_LINHA_TABELA = 30;

    private static final int LARGURA_COLUNA_01 = 50;
    private static final int LARGURA_COLUNA_02 = 25;
    private static final int LARGURA_COLUNA_03 = 100;
    private static final int LARGURA_COLUNA_04 = 100;
    private static final int LARGURA_COLUNA_05 = 100;
    private static final int LARGURA_COLUNA_06 = 30;
    private static final int LARGURA_COLUNA_07 = 90;



    private JLabel lblColuna_01_Comando;
    private JLabel lblColuna_02_Estado;
    private JLabel lblColuna_03_Categoria;
    private JLabel lblColuna_04_Nome;
    private JLabel lblColuna_05_Localizacao;
    private JLabel lblColuna_06_Id;
    private JLabel lblColuna_07_Fabricante;
    // private JLabel lblColuna_01_;
    




    public TelaLampadas (){

        telaLampadas = this;
        
        CriarTela();
    }

    private void CriarTela(){

        telaLampadas.setSize(500, 500);
        telaLampadas.setLayout(new BoxLayout(telaLampadas, BoxLayout.Y_AXIS));

        MontarComponentes();

        telaLampadas.setVisible(true);
    }

    private void MontarComponentes(){

        // *********************************************************
        // CRIAÇÃO DA ESTRUTURA DO TÍTULO DA VIEW
        // *********************************************************
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



        // *********************************************************
        // CRIAÇÃO DA ESTRUTURA DO CABEÇALHO DA TABELA
        // *********************************************************
        JButton btnColuna_01_Comando = new JButton("Comando");
        btnColuna_01_Comando.setBorder(new LineBorder(COR_BORDA));
        btnColuna_01_Comando.setBackground(COR_FUNDO_CABECALHO);
        btnColuna_01_Comando.setPreferredSize(new Dimension(LARGURA_COLUNA_01, ALTURA_LINHA_CABECALHO));
        btnColuna_01_Comando.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnColuna_02_Estado = new JButton("Estado");
        btnColuna_02_Estado.setBorder(new LineBorder(COR_BORDA));
        btnColuna_02_Estado.setBackground(COR_FUNDO_CABECALHO);
        btnColuna_02_Estado.setPreferredSize(new Dimension(LARGURA_COLUNA_02, ALTURA_LINHA_CABECALHO));
        btnColuna_02_Estado.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnColuna_03_Categoria = new JButton("Categoria");
        btnColuna_03_Categoria.setBorder(new LineBorder(COR_BORDA));
        btnColuna_03_Categoria.setBackground(COR_FUNDO_CABECALHO);
        btnColuna_03_Categoria.setPreferredSize(new Dimension(LARGURA_COLUNA_03, ALTURA_LINHA_CABECALHO));
        btnColuna_03_Categoria.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnColuna_04_Nome = new JButton("Nome");
        btnColuna_04_Nome.setBorder(new LineBorder(COR_BORDA));
        btnColuna_04_Nome.setBackground(COR_FUNDO_CABECALHO);
        btnColuna_04_Nome.setPreferredSize(new Dimension(LARGURA_COLUNA_04, ALTURA_LINHA_CABECALHO));
        btnColuna_04_Nome.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnColuna_05_Localizacao = new JButton("Localizacao");
        btnColuna_05_Localizacao.setBorder(new LineBorder(COR_BORDA));
        btnColuna_05_Localizacao.setBackground(COR_FUNDO_CABECALHO);
        btnColuna_05_Localizacao.setPreferredSize(new Dimension(LARGURA_COLUNA_05, ALTURA_LINHA_CABECALHO));
        btnColuna_05_Localizacao.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnColuna_06_Id = new JButton("ID");
        btnColuna_06_Id.setBorder(new LineBorder(COR_BORDA));
        btnColuna_06_Id.setBackground(COR_FUNDO_CABECALHO);
        btnColuna_06_Id.setPreferredSize(new Dimension(LARGURA_COLUNA_06, ALTURA_LINHA_CABECALHO));
        btnColuna_06_Id.setHorizontalAlignment(SwingConstants.CENTER);

        JButton btnColuna_07_Fabricante = new JButton("Fabricante");
        btnColuna_07_Fabricante.setBorder(new LineBorder(COR_BORDA));
        btnColuna_07_Fabricante.setBackground(COR_FUNDO_CABECALHO);
        btnColuna_07_Fabricante.setPreferredSize(new Dimension(LARGURA_COLUNA_07, ALTURA_LINHA_CABECALHO));
        btnColuna_07_Fabricante.setHorizontalAlignment(SwingConstants.CENTER);



        JPanel boxCabecalho = new JPanel();
        boxCabecalho.setBorder(new LineBorder(Color.MAGENTA));
        boxCabecalho.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        boxCabecalho.setPreferredSize(new Dimension(500, ALTURA_LINHA_CABECALHO));
        boxCabecalho.add(Box.createRigidArea(new Dimension(2, 0)));
        boxCabecalho.add(btnColuna_01_Comando);
        boxCabecalho.add(btnColuna_02_Estado);
        boxCabecalho.add(btnColuna_03_Categoria);
        boxCabecalho.add(btnColuna_04_Nome);
        boxCabecalho.add(btnColuna_05_Localizacao);
        boxCabecalho.add(btnColuna_06_Id);
        boxCabecalho.add(btnColuna_07_Fabricante);



        // *********************************************************
        // CRIAÇÃO DA ESTRUTURA BÁSICA DO JPANEL
        // *********************************************************
        telaLampadas.add(boxTitulo);
        telaLampadas.add(boxCabecalho);



        // *********************************************************
        // CRIAÇÃO DAS LINHAS DA TABELA
        // *********************************************************
        JLabel lblTeste4 = new JLabel("Usuário");
        lblTeste4.setBorder(new LineBorder(Color.YELLOW));
        lblTeste4.setPreferredSize(new Dimension(50, ALTURA_LINHA_CABECALHO));

        JLabel lblTeste5 = new JLabel("Usuário2");
        lblTeste5.setBorder(new LineBorder(Color.GREEN));
        lblTeste5.setPreferredSize(new Dimension(75, ALTURA_LINHA_CABECALHO));

        JButton btnTeste6 = new JButton("Botão");
        btnTeste6.setBorder(new LineBorder(Color.BLUE));
        btnTeste6.setPreferredSize(new Dimension(150, ALTURA_LINHA_CABECALHO));


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
        boxTabela.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        // boxTabela.setLayout(new BoxLayout(boxTabela, BoxLayout.X_AXIS));
        // boxTabela.setSize(new Dimension(500, ALTURA_LINHA_CABECALHO));
        boxTabela.setPreferredSize(new Dimension(500, ALTURA_LINHA_CABECALHO + 10));
        // boxTabela.setAlignmentX(SwingConstants.LEFT);
        boxTabela.add(lblTeste4);
        boxTabela.add(lblTeste5);
        boxTabela.add(btnTeste6);




        telaLampadas.add(boxTabela);
        telaLampadas.add(Box.createVerticalGlue());







    }



    public JComponent getTelaUsuario(){

        return telaLampadas;
    }
    
}
