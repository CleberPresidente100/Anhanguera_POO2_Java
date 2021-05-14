package GerenciadorSensores;

import java.util.ArrayList;


public class GerenciadorSensores {

    private ArrayList<ISensorTemperatura> listaSensores;

    

    public GerenciadorSensores(int quantidadeSensoresPSC, int quantidadeSensoresXSC, int quantidadeSensoresYSC){
        
        int idSensor = 0;
        listaSensores = new ArrayList<ISensorTemperatura>();

        for(int contador = 0; contador < quantidadeSensoresPSC; contador++){

            idSensor++;
            listaSensores.add(new SensorPSC(idSensor));
        }

        for(int contador = 0; contador < quantidadeSensoresXSC; contador++){
            
            idSensor++;
            listaSensores.add(new SensorXSC(idSensor));
        }

        for(int contador = 0; contador < quantidadeSensoresYSC; contador++){
            
            idSensor++;
            listaSensores.add(new SensorYSC(idSensor));
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
