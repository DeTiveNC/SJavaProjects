// WebConfig.java
package dev.Springdetivenc.movieapp.Configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow all origins, you might want to restrict this based on your requirements
        config.addAllowedOrigin("*");

        // Allow all HTTP methods (GET, POST, PUT, DELETE, etc.)
        config.addAllowedMethod("*");

        // Allow all headers
        config.addAllowedHeader("*");

        // Allow credentials (you might not need this depending on your use case)
        config.setAllowCredentials(true);

        // Add the following line to expose headers
        config.addExposedHeader("Access-Control-Allow-Origin");

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
