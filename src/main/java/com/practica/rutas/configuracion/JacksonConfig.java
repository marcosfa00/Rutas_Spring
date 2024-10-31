package com.practica.rutas.configuracion;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Optional;

@Configuration
public class JacksonConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> jacksonConverter = converters.stream()
                .filter(converter -> converter instanceof MappingJackson2HttpMessageConverter)
                .findFirst();

        if (jacksonConverter.isPresent()) {
            MappingJackson2HttpMessageConverter jacksonMessageConverter =
                    (MappingJackson2HttpMessageConverter) jacksonConverter.get();
            ObjectMapper objectMapper = jacksonMessageConverter.getObjectMapper();

            // Configura el objectMapper
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL); // omitir valores null
            objectMapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL); // valores desconocidos como null
        }
    }
}
