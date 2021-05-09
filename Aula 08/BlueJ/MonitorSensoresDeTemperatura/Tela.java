
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import GerenciadorSensores.DadosSensor;
import GerenciadorSensores.GerenciadorSensores;


public class Tela extends JFrame{
    
    private GerenciadorSensores gerenciadorSensores;

    // Tabela
    private JTable tabTabelaMonitoramento;
    private DefaultTableModel estruturaTabela;

    // Container da Tela
    private Container container;


    
    public Tela(GerenciadorSensores gerenciadorSensores){

        this.gerenciadorSensores = gerenciadorSensores;
        CriarTela();
    }



    private void CriarTela(){

        ConstruirLayout();
        AtualizarTabela();

    }

    

    private void ConstruirLayout(){

        setSize(410, 280);
        setTitle("Monitor Sensores de Temperatura");

        // Configurações do Container
        container = getContentPane();
        container.setLayout(null);

    
        // Configurações da Tabela
        estruturaTabela = new DefaultTableModel();
        tabTabelaMonitoramento = new JTable(estruturaTabela);
        estruturaTabela.addColumn("ID Sensor");
        estruturaTabela.addColumn("Status");
        estruturaTabela.addColumn("Temperatura");
        estruturaTabela.addColumn("Fabricante");
        JScrollPane painel = new JScrollPane(tabTabelaMonitoramento);
        painel.setBounds(10, 10, 390, 240);


        container.add(painel);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

    public void AtualizarTabela(){


        ArrayList<DadosSensor> dadosSensores = gerenciadorSensores.lerInformacoesTodosSensores();
        
        estruturaTabela.setNumRows(0);
        
        for (DadosSensor dadosSensor : dadosSensores) {

            estruturaTabela.addRow(new Object[]{
                dadosSensor.idSensor,
                dadosSensor.corTemperatura,
                dadosSensor.temperaturaSensor,
                dadosSensor.nomeFabricanteSensor
            });
        }
    }
}
