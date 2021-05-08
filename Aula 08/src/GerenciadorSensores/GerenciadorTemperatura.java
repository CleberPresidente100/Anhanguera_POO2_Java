package GerenciadorSensores;

import java.time.*;
import java.time.temporal.ChronoUnit;


public class GerenciadorTemperatura {

    private LocalDateTime dataHora;

    private static final int intervaloDeLeitura = 5;



    public GerenciadorTemperatura(){
        dataHora = LocalDateTime.now();
    }



    public String lerTemperatura(int temperaturaMinima, int temperaturaMaxima){

        long secondsDiff = ChronoUnit.SECONDS.between(dataHora, LocalDateTime.now());

        // Só gera uma nova temperatura caso já tenha se passado 5 segundos
        if(secondsDiff >= intervaloDeLeitura){

            dataHora = LocalDateTime.now();

            // Math.random() * (max - min + 1) + min
            double temperatura = Math.random() * (temperaturaMaxima - temperaturaMinima + 1) + temperaturaMinima;

            // Arredonda com duas casas decimais
            temperatura = Math.round(temperatura * 100) / 100;

            return Double.toString(temperatura);
        }

        return null;
    }



    public String converterTemperaturaFahrenheitParaCelsius(String temperaturaFahrenheit){
        
        float temperaturaCelsius = 0;

        temperaturaCelsius = (5/9) * Float.parseFloat(temperaturaFahrenheit);
        
        return Float.toString(temperaturaCelsius);
    } 



    public EnumCoresTemperaturas getCorTemperatura(String temperatura){
        
        float temperaturaLida = Float.parseFloat(temperatura);

        if(temperaturaLida >= 19 && temperaturaLida <= 24){
            return EnumCoresTemperaturas.VERDE;
        }

        if(temperaturaLida <= 5 && temperaturaLida > 24){
            return EnumCoresTemperaturas.AMARELO;
        }
        
        return EnumCoresTemperaturas.VERMELHO;
    }    
}
