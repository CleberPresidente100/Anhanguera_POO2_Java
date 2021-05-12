package GerenciadorSensores;

import java.util.ArrayList;


public class GerenciadorSensores {

    // Esta variável pode ser substituida pelo listaSensores.size(), mas será
    // mantida para efeitos didaticos.
    private static int idNovoSensor;

    private static ArrayList<ISensorTemperatura> listaSensores;
    

    public GerenciadorSensores(){
        
        if(listaSensores == null){
    
            idNovoSensor = 0;
            
            listaSensores = new ArrayList<ISensorTemperatura>();
        }
    }
    

    public void AdicionarSensores(int quantidadeSensoresPSC, int quantidadeSensoresXSC, int quantidadeSensoresYSC){

        for(int contador = 0; contador < quantidadeSensoresPSC; contador++){

            idNovoSensor++;
            listaSensores.add(new SensorPSC(idNovoSensor));
        }

        for(int contador = 0; contador < quantidadeSensoresXSC; contador++){
            
            idNovoSensor++;
            listaSensores.add(new SensorXSC(idNovoSensor));
        }

        for(int contador = 0; contador < quantidadeSensoresYSC; contador++){
            
            idNovoSensor++;
            listaSensores.add(new SensorYSC(idNovoSensor));
        }
    }



    public DadosSensor lerInformacoesSensor(int idSensor){

        DadosSensor dadosSensor = new DadosSensor();
        GerenciadorTemperatura gerenciadorTemperatura = new GerenciadorTemperatura();

        for (ISensorTemperatura sensor : listaSensores) {
            
            if(sensor.getIdSensor() == idSensor){

                dadosSensor.idSensor = idSensor;
                dadosSensor.nomeFabricanteSensor = sensor.getNomeFabricante();
                dadosSensor.temperaturaSensor = sensor.getTemperatura();
                dadosSensor.corTemperatura = gerenciadorTemperatura.getCorTemperatura(sensor.getTemperatura());
                
                return dadosSensor;
            }
        }
        
        return dadosSensor;
    }



    public ArrayList<DadosSensor> lerInformacoesTodosSensores(){

        ArrayList<DadosSensor> dadosSensores = new ArrayList<DadosSensor>();
        GerenciadorTemperatura gerenciadorTemperatura = new GerenciadorTemperatura();
        
        for (ISensorTemperatura sensor : listaSensores) {
            
            DadosSensor infoSensor = new DadosSensor();
            
            infoSensor.idSensor = sensor.getIdSensor();
            infoSensor.nomeFabricanteSensor = sensor.getNomeFabricante();
            infoSensor.temperaturaSensor = sensor.getTemperatura();
            infoSensor.corTemperatura = gerenciadorTemperatura.getCorTemperatura(sensor.getTemperatura());
            
            dadosSensores.add(infoSensor);
        }
        
        return dadosSensores;
    }
}
