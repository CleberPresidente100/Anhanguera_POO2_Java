
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.*;


public class TelaAdministrador extends JPanel{

    private JPanel telaAdministrador;

    private JLabel lblTitulo;
    private JLabel lblID;
    private JLabel lblFabricante;
    private JLabel lblCategoriaIoT;
    private JLabel lblNome;
    private JLabel lblLocal;

    private JTextField txtNome;
    private JTextField txtLocal;

    private JComboBox cboxID;
    private JComboBox cboxFabricante;
    private JComboBox cboxCategoriaIoT;

    private JButton btnRemover;
    private JButton btnAdicionarAlterar;

    private ArrayList<String> listaComboBoxIDs;
    private ArrayList<String> listaComboBoxFabricantes;
    private ArrayList<String> listaComboBoxCategoriasIoTs;

    private static final int TELA_LARGURA = 500;




    public TelaAdministrador (){

        listaComboBoxIDs = this.getListaIDs();
        listaComboBoxFabricantes = this.getListaFabricantes();
        listaComboBoxCategoriasIoTs = this.getListaCategoriasIoTs();
        
        CriarTela();
    }

    private void CriarTela(){

        telaAdministrador = this;
        // telaAdministrador.setLayout(new BoxLayout(telaAdministrador, BoxLayout.Y_AXIS));
        telaAdministrador.setLayout(null);
        // telaAdministrador.setLayout(new BorderLayout());

        ConstruirLayout();
    }

    private void ConstruirLayout(){


        telaAdministrador.setSize(TELA_LARGURA, 500);


        lblTitulo = new JLabel("Cadastro de IoTs");
        lblTitulo.setBounds((TELA_LARGURA - 200) / 2, 50, 200, 25);
        telaAdministrador.add(lblTitulo);
        
        lblID = new JLabel("ID");
        lblID.setBounds(50, 95, 200, 25);
        telaAdministrador.add(lblID);

        lblCategoriaIoT = new JLabel("Categoria IoT");
        lblCategoriaIoT.setBounds(50, 130, 200, 25);
        telaAdministrador.add(lblCategoriaIoT);

        lblFabricante = new JLabel("Fabricante");
        lblFabricante.setBounds(50, 165, 200, 25);
        telaAdministrador.add(lblFabricante);

        lblNome = new JLabel("Nome");
        lblNome.setBounds(50, 200, 200, 25);
        telaAdministrador.add(lblNome);

        lblLocal = new JLabel("Localizacao");
        lblLocal.setBounds(50, 235, 200, 25);
        telaAdministrador.add(lblLocal);

        txtNome = new JTextField();
        txtNome.setBounds(160, 200, 200, 25);
        telaAdministrador.add(txtNome);

        txtLocal = new JTextField();
        txtLocal.setBounds(160, 235, 200, 25);
        telaAdministrador.add(txtLocal);
        
        btnAdicionarAlterar = new JButton("Adicionar/Alterar");
        btnAdicionarAlterar.setBounds(50, 280, 190, 50);
        telaAdministrador.add(btnAdicionarAlterar);
        
        btnRemover = new JButton("Remover");
        btnRemover.setBounds(250, 280, 110, 50);
        telaAdministrador.add(btnRemover);

        cboxID = new JComboBox<String>();
        cboxID.setBounds(160, 95, 200, 25);
        cboxID = preencherComboBox(cboxID, listaComboBoxIDs);
        cboxID.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){
        
                // System.out.print(event.getSource());
                JComboBox cb = (JComboBox)event.getSource();
                String ID = (String)cb.getSelectedItem();
                AtualizarCampos(ID);
            }
        });
        telaAdministrador.add(cboxID);

        cboxCategoriaIoT = new JComboBox<String>();
        cboxCategoriaIoT.setBounds(160, 130, 200, 25);
        cboxCategoriaIoT = preencherComboBox(cboxCategoriaIoT, listaComboBoxCategoriasIoTs);
        telaAdministrador.add(cboxCategoriaIoT);

        cboxFabricante = new JComboBox<String>();
        cboxFabricante.setBounds(160, 165, 200, 25);
        cboxFabricante = preencherComboBox(cboxFabricante, listaComboBoxFabricantes);
        telaAdministrador.add(cboxFabricante);


        

        // txtNome = new JTextField();
        // txtLocal = new JTextField();

        // cboxID = new JComboBox<String>();
        // cboxID = preencherComboBox(cboxID, listaIDs);

        // cboxCategoriaIoT = new JComboBox<String>();
        // cboxCategoriaIoT = preencherComboBox(cboxCategoriaIoT, listaCategoriasIoTs);

        // btnRemover = new JButton("Remover");
        // btnAdicionarAlterar = new JButton("Adicionar/Alterar");


        // Box caixaEsquerda = Box.createVerticalBox();        
        // caixaEsquerda.add(new JLabel("ID"));
        // caixaEsquerda.add(new JLabel("Tipo Item IoT"));
        // caixaEsquerda.add(new JLabel("Nome"));
        // caixaEsquerda.add(new JLabel("Localizacao"));
        // caixaEsquerda.add(Box.createGlue());
        

        // Box caixaDireita = Box.createVerticalBox();        
        // caixaDireita.add(cboxID);
        // caixaDireita.add(cboxCategoriaIoT);
        // caixaDireita.add(txtNome);
        // caixaDireita.add(txtLocal);
        // caixaDireita.add(Box.createVerticalStrut(10));
        // caixaDireita.add(Box.createGlue());


        // Box caixaCampos = Box.createHorizontalBox();
        // caixaCampos.add(caixaEsquerda);
        // caixaCampos.add(Box.createVerticalStrut(10));
        // caixaCampos.add(caixaDireita);
        // caixaCampos.add(Box.createVerticalStrut(10));
        // caixaCampos.add(Box.createGlue());


        // Box caixaBotoes = Box.createHorizontalBox();
        // caixaBotoes.add(btnAdicionarAlterar);
        // caixaBotoes.add(Box.createHorizontalStrut(30));
        // caixaBotoes.add(btnRemover);

        // telaAdministrador.add(caixaCampos);
        // // telaAdministrador.add(caixaBotoes);
        
        // // telaAdministrador.add(caixaEsquerda);







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



    public JComboBox preencherComboBox(JComboBox campoComboBox, ArrayList<String> listaItens){

        for (String item : listaItens) {

            campoComboBox.addItem(item);            
        }

        return campoComboBox;
    }



    private ArrayList<String> getListaIDs(){

        ListaIoTs listaIoTs = new ListaIoTs();
        ArrayList<IoTs> lista = listaIoTs.getListaIoTs();
        ArrayList<String> listaIDs = new ArrayList<String>();

        listaIDs.add("");

        for (IoTs item : lista) {

            listaIDs.add(Integer.toString(item.Id));
        }


        return listaIDs;
    }



    private ArrayList<String> getListaCategoriasIoTs(){

        ListaCategoriasIoTs listaCategoriasIoTs = new ListaCategoriasIoTs();
        ArrayList<CategoriasIoTs> lista = listaCategoriasIoTs.getListaCategoriasIoTs();
        ArrayList<String> listaCategorias = new ArrayList<String>();

        listaCategorias.add("");

        for (CategoriasIoTs item : lista) {

            listaCategorias.add(item.Categoria);
        }


        return listaCategorias;
    }



    private ArrayList<String> getListaFabricantes(){

        ListaFabricantes listaFabricantes = new ListaFabricantes();
        ArrayList<Fabricantes> lista = listaFabricantes.getListaFabricantes();
        ArrayList<String> listaNomesFabricantes = new ArrayList<String>();

        listaNomesFabricantes.add("");

        for (Fabricantes item : lista) {

            listaNomesFabricantes.add(item.Fabricante);
        }


        return listaNomesFabricantes;
    }



    public void AtualizarCampos(String ID){

        int idIoT = 0;

        try{
            idIoT = Integer.parseInt(ID);
        }
        catch (Exception e){

        }

        
        if(idIoT == 0){

            this.txtNome.setText("");
            this.txtLocal.setText("");
            this.cboxFabricante.setSelectedIndex(0);
            this.cboxCategoriaIoT.setSelectedIndex(0);

            return;
        }

        IoTs itemIoT = new IoTs();
        ListaIoTs listaIoTs = new ListaIoTs();

        itemIoT = listaIoTs.getIoT(idIoT);

        // Altera os Campos de Texto
        this.txtNome.setText(itemIoT.Nome);
        this.txtLocal.setText(itemIoT.Localizacao);


        // Altera ComboBox Fabricante
        if(itemIoT.NomeFabricante != null && itemIoT.NomeFabricante != ""){

            int indice = 0;
            for (String item : listaComboBoxFabricantes) {

                if(item.equals(itemIoT.NomeFabricante)){
                    this.cboxFabricante.setSelectedIndex(indice);
                }
                
                indice++;
            }
        }
        else{
            this.cboxFabricante.setSelectedIndex(0);
        }


        // Altera ComboBox Categoria
        if(itemIoT.NomeCategoria != null && itemIoT.NomeCategoria != ""){
            
            int indice = 0;
            for (String item : listaComboBoxCategoriasIoTs) {

                if(item.equals(itemIoT.NomeCategoria)){

                    this.cboxCategoriaIoT.setSelectedIndex(indice);
                }

                indice++;
            }
        }
        else{
            this.cboxCategoriaIoT.setSelectedIndex(0);
        }

    }



    public JComponent getTelaAdministrador(){

        return telaAdministrador;
    }
    
}
