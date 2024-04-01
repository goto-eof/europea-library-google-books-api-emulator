package com.andreidodu.europealibrary.googleapiemulator.configuration;

import com.andreidodu.europealibrary.googleapiemulator.dto.ApplicationConfigurationDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    public static final int MAX_NUMBER_REQUESTS_ALLOWED = 10;
    @Bean("applicationConfigurationBean")
    public ApplicationConfigurationDTO applicationConfigurationBean() {
        return new ApplicationConfigurationDTO();
    }

}
