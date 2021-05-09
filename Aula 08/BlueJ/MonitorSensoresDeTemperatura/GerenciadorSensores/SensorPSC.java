package GerenciadorSensores;


public class SensorPSC implements ISensorTemperatura{

    private int idSensor;
    private String temperatura;
    private GerenciadorTemperatura geradorTemperatura;

    private static final int temperaturaMinima = 10;
    private static final int temperaturaMaxima = 120;



    public SensorPSC(int idSensor){
        
        this.idSensor = idSensor;
        geradorTemperatura = new GerenciadorTemperatura();
    }



    public String getNomeFabricante() {
        return "PSC";
    }



    public String getNomeEscala() {
        return "Fahrenheit";
    }



    public String getTemperatura() {

        String novaTemperatura = geradorTemperatura.lerTemperatura(temperaturaMinima, temperaturaMaxima);

        if(novaTemperatura != null){
            temperatura = novaTemperatura;
        }

        return temperatura;
    }



    public int getIdSensor() {
        return idSensor;
    }
}
