package br.com.tilmais.springbootbrincandocomjpa;

import br.com.tilmais.springbootbrincandocomjpa.settings.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class SpringBootBrincandoComJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBrincandoComJpaApplication.class, args);
    }

}
