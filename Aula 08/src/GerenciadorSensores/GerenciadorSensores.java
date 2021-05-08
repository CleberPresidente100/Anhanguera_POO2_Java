package GerenciadorSensores;

import java.util.List;


public class GerenciadorSensores {

    private List<ISensorTemperatura> listaSensores;

    

    public GerenciadorSensores(int quantidadeSensoresPSC, int quantidadeSensoresXSC, int quantidadeSensoresYSC){
        
        int idSensor = 0;

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



    public DadosSensor lerInformacoesSensore(int idSensor){

        DadosSensor dadosSensor = new DadosSensor();
        GerenciadorTemperatura gerenciadorTemperatura = new GerenciadorTemperatura();

        for (ISensorTemperatura sensor : listaSensores) {
            
            if(sensor.getIdSensor() == idSensor){

                dadosSensor.idSensor = idSensor;
                dadosSensor.nomeSensor = sensor.getNomeFabricante();
                dadosSensor.temperaturaSensor = sensor.getTemperatura();
                dadosSensor.corTemperatura = gerenciadorTemperatura.getCorTemperatura(sensor.getTemperatura());
                
                return dadosSensor;
            }
        }
        
        return dadosSensor;
    }
}
