package com.liimadev.sanguesolidario.configs;

import com.liimadev.sanguesolidario.models.Sexo;
import com.liimadev.sanguesolidario.models.TipoSanguineo;
import com.liimadev.sanguesolidario.repositories.SexoRepository;
import com.liimadev.sanguesolidario.repositories.TipoSanguineoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Inicializador {
    private final String[] sexos = {"Masculino", "Feminino"},
            tipos = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};


    @Bean
    CommandLineRunner iniciarBanco (SexoRepository sexoRepository, TipoSanguineoRepository tipoSanguineoRepository) {
        return args -> {
            if(sexoRepository.count() == 0) {
                for (String sexo : sexos)
                    sexoRepository.save(new Sexo(0, sexo));
            }

            if(tipoSanguineoRepository.count() == 0) {
                for(String tipo : tipos)
                    tipoSanguineoRepository.save(new TipoSanguineo(0, tipo));
            }
        };
    }
}
