
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;



public class TelaListaIoTs extends JPanel{

    private JPanel telaListaIoTs;

    private JLabel lblID;
    private JLabel lblFabricante;
    private JLabel lblCategoriaIoT;
    private JLabel lblNome;
    private JLabel lblLocal;
    private JLabel lblEstado;


    public TelaListaIoTs(){

        telaListaIoTs = new JPanel(new BorderLayout());

        telaListaIoTs.setSize(500, 500);

        MontarTela();

    }


    public void MontarTela(){



        Box cabecalho = Box.createHorizontalBox();
        cabecalho.setSize(50, 25);
        // cabecalho.setLayout(null);

        lblID = new JLabel("ID");
        // lblID.setSize(100, 25);
        // cabecalho.add(lblID, BorderLayout.PAGE_START);
        lblID.setBounds(0, 10, 10, 25);
        cabecalho.add(lblID);

        lblFabricante = new JLabel("FABRICANTE");
        // lblFabricante.setSize(30, 25);
        lblID.setBounds(0, 25, 10, 25);
        cabecalho.add(lblFabricante);
        
        // lblCategoriaIoT = new JLabel("CATEGORIA");
        // // lblFabricante.setSize(30, 25);
        // lblID.setBounds(0, 40, 10, 25);
        // cabecalho.add(lblCategoriaIoT);
        
        // lblNome = new JLabel("NOME");
        // // lblFabricante.setSize(30, 25);
        // lblID.setBounds(0, 55, 10, 25);
        // cabecalho.add(lblNome);
        
        // lblLocal = new JLabel("LOCAL");
        // // lblFabricante.setSize(30, 25);
        // lblID.setBounds(0, 70, 10, 25);
        // cabecalho.add(lblLocal);
        
        // lblEstado = new JLabel("ESTADO");
        // // lblFabricante.setSize(30, 25);
        // lblID.setBounds(0, 85, 10, 25);
        // cabecalho.add(lblEstado);

        // telaListaIoTs.add(cabecalho, BorderLayout.PAGE_START);
        telaListaIoTs.add(cabecalho, BorderLayout.PAGE_START);
        
    }



    public JComponent getTelaListaIoTs(){

        return telaListaIoTs;
    }

    
}
