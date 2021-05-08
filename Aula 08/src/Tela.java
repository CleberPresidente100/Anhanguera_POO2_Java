
import java.awt.Container;
import javax.swing.*;


public class Tela extends JFrame{
    
    private JLabel lblStatusSensorPSC;
    private JLabel lblNomeSensorPSC;
    private JLabel lblTemperaturaSensorPSC;
    
    private JLabel lblStatusSensorXSC;
    private JLabel lblNomeSensorXSC;
    private JLabel lblTemperaturaSensorXSC;
    
    private JLabel lblStatusSensorYSC;
    private JLabel lblNomeSensorYSC;
    private JLabel lblTemperaturaSensorYSC;

    private Container ctn;



    public void CriarTela(){

        ConstruirLayout();
        ConfigurarEventos();

    }

    

    private void ConstruirLayout(){

        setSize(400, 250);
        setTitle("Monitor Sensores de Temperatura");

        ctn = getContentPane();
        ctn.setLayout(null);


    
        lblStatusSensorPSC = new JLabel("");
        lblNomeSensorPSC = new JLabel("");
        lblTemperaturaSensorPSC = new JLabel("");

        lblStatusSensorXSC = new JLabel("");
        lblNomeSensorXSC = new JLabel("");
        lblTemperaturaSensorXSC = new JLabel("");

        lblStatusSensorYSC = new JLabel("");
        lblNomeSensorYSC = new JLabel("");
        lblTemperaturaSensorYSC = new JLabel("");


    
        lblStatusSensorPSC.setBounds();
        lblNomeSensorPSC.setBounds();
        lblTemperaturaSensorPSC.setBounds();

        lblStatusSensorXSC.setBounds();
        lblNomeSensorXSC.setBounds();
        lblTemperaturaSensorXSC.setBounds();

        lblStatusSensorYSC.setBounds();
        lblNomeSensorYSC.setBounds();
        lblTemperaturaSensorYSC.setBounds();


    
        ctn.add(lblStatusSensorPSC);
        ctn.add(lblNomeSensorPSC);
        ctn.add(lblTemperaturaSensorPSC);

        ctn.add(lblStatusSensorXSC);
        ctn.add(lblNomeSensorXSC);
        ctn.add(lblTemperaturaSensorXSC);

        ctn.add(lblStatusSensorYSC);
        ctn.add(lblNomeSensorYSC);
        ctn.add(lblTemperaturaSensorYSC);

    }

    

    private void ConfigurarEventos(){

    }
}
