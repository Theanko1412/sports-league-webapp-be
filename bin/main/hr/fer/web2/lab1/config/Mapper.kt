package hr.fer.web2.lab1.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class Mapper {

    @Bean
    fun modelMapper(): ModelMapper {
        return ModelMapper()
    }
}