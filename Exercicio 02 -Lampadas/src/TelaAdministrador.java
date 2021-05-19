
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



public class TelaAdministrador extends JPanel{

    private JPanel telaAdministrador;

    private JLabel lblTitulo;
    private JLabel lblID;
    private JLabel lblTipoIoT;
    private JLabel lblNome;
    private JLabel lblLocal;

    private JTextField txtNome;
    private JTextField txtLocal;

    private JComboBox cboxID;
    private JComboBox cboxTipoIoT;

    private JButton btnRemover;
    private JButton btnAdicionarAlterar;

    private ArrayList<String> listaIDs;
    private ArrayList<String> listaTiposIoTs;




    public TelaAdministrador (ArrayList<String> listaIDs, ArrayList<String> listaTiposIoTs){

        this.listaIDs = listaIDs;
        this.listaTiposIoTs = listaTiposIoTs;
        
        CriarTela();
    }

    private void CriarTela(){

        telaAdministrador = this;
        // telaAdministrador.setLayout(new BoxLayout(telaAdministrador, BoxLayout.Y_AXIS));
        telaAdministrador.setLayout(null);

        ConstruirLayout();
    }

    private void ConstruirLayout(){


        telaAdministrador.setSize(500, 500);


        lblTitulo = new JLabel("Cadastro de IoTs");
        lblTitulo.setBounds(170, 40, 200, 25);
        telaAdministrador.add(lblTitulo);
        
        lblID = new JLabel("ID");
        lblID.setBounds(50, 95, 200, 25);
        telaAdministrador.add(lblID);

        lblTipoIoT = new JLabel("Tipo Item IoT");
        lblTipoIoT.setBounds(50, 130, 200, 25);
        telaAdministrador.add(lblTipoIoT);

        lblNome = new JLabel("Nome");
        lblNome.setBounds(50, 165, 200, 25);
        telaAdministrador.add(lblNome);

        lblLocal = new JLabel("Localizacao");
        lblLocal.setBounds(50, 200, 200, 25);
        telaAdministrador.add(lblLocal);

        txtNome = new JTextField();
        txtNome.setBounds(160, 165, 200, 25);
        telaAdministrador.add(txtNome);

        txtLocal = new JTextField();
        txtLocal.setBounds(160, 200, 200, 25);
        telaAdministrador.add(txtLocal);
        
        btnAdicionarAlterar = new JButton("Adicionar/Alterar");
        btnAdicionarAlterar.setBounds(50, 245, 190, 50);
        telaAdministrador.add(btnAdicionarAlterar);
        
        btnRemover = new JButton("Remover");
        btnRemover.setBounds(250, 245, 110, 50);
        telaAdministrador.add(btnRemover);

        cboxID = new JComboBox<String>();
        cboxID.setBounds(160, 95, 200, 25);
        cboxID = preencherComboBox(cboxID, listaIDs);
        telaAdministrador.add(cboxID);

        cboxTipoIoT = new JComboBox<String>();
        cboxTipoIoT.setBounds(160, 130, 200, 25);
        cboxTipoIoT = preencherComboBox(cboxTipoIoT, listaTiposIoTs);
        telaAdministrador.add(cboxTipoIoT);

        // Box caixaEsquerda = Box.createVerticalBox();        
        // caixaEsquerda.add(Box.createVerticalStrut(25));
        // caixaEsquerda.add(lblID);
        // caixaEsquerda.add(lblTipoIoT);
        // caixaEsquerda.add(lblNome);
        // caixaEsquerda.add(lblLocal);
        // caixaEsquerda.add(Box.createGlue());
        // JPanel painelEsquerdo = new JPanel();
        // painelEsquerdo.add(caixaEsquerda);



        // Box caixaDireita = Box.createVerticalBox();
        // caixaDireita.add((Box.createVerticalStrut(25)));
        // caixaDireita.add(cboxID);
        // caixaDireita.add(cboxTipoIoT);
        // caixaDireita.add(txtNome);
        // caixaDireita.add(txtLocal);
        // caixaDireita.add(Box.createGlue());
        // JPanel painelDireito = new JPanel();
        // painelDireito.add(caixaDireita);
        


        // Box caixaCampos = Box.createHorizontalBox();
        // caixaCampos.add(painelEsquerdo);
        // caixaCampos.add(Box.createHorizontalStrut(5));
        // caixaCampos.add(painelDireito);
        // caixaCampos.add(Box.createGlue());
        // JPanel painelCampos = new JPanel();
        // painelCampos.add(caixaCampos);



        // Box caixaBotoes = Box.createHorizontalBox();
        // caixaBotoes.add((Box.createHorizontalStrut(25)));
        // caixaBotoes.add(btnAdicionarAlterar);
        // caixaBotoes.add(btnRemover);
        // caixaBotoes.add(Box.createGlue());
        // JPanel painelBotoes = new JPanel();
        // painelBotoes.add(caixaBotoes);



        // Box tela = Box.createVerticalBox();
        // tela.add((Box.createVerticalStrut(5)));
        // tela.add(lblTitulo);
        // tela.add(painelCampos);
        // tela.add(painelBotoes);
        // tela.add(Box.createGlue());


    //     content.setLayout(new BorderLayout());
    // content.add(top, BorderLayout.CENTER);

    // BoxLayout box = new BoxLayout(content, BoxLayout.Y_AXIS);

    // content.setLayout(box);
    // content.add(top);


        // telaAdministrador.add(painelCampos);


        telaAdministrador.setVisible(true);
    }



    public JComboBox preencherComboBox(JComboBox comboBox, ArrayList<String> listaItens){

        for (String item : listaItens) {

            comboBox.addItem(item);            
        }

        return comboBox;
    }



    public ArrayList<String> getListaIDs(){

        return null;
    }



    public ArrayList<String> getListaTiposIoTs(){

        return null;
    }



    public JComponent getTelaAdministrador(){

        return telaAdministrador;
    }
    
}
