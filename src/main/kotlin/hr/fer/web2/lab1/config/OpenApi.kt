package hr.fer.web2.lab1.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApi {
    @Value("\${spring.application.name}")
    var name: String? = null

    @Value("\${spring.application.version:1.0.0}")
    var version: String? = null

    @Value("\${server.port}")
    var port: String? = null

    @Value("\${server.servlet.context-path}")
    var contextPath: String? = null

    @Value("\${API_CONTACT_EMAIL:'env not set'}")
    var contactEmail: String? = null
    @Bean
    fun customOpenAPI(): OpenAPI {
        val contact = if (contactEmail != null && contactEmail!!.contains("@")) Contact().name("Danko Curlin").email(contactEmail) else Contact().name("Danko Curlin")
        return OpenAPI()
            .info(
                Info()
                    .title(name)
                    .description("Sports league api for awd course 2023 (https://www.fer.unizg.hr/en/course/awd)")
                    .version(version)
                    .contact(contact)
            )
            .servers(
                listOf(
                    Server()
                        .description("Local server")
                        .url("http://localhost:$port$contextPath")
                )
            )
    }
}

