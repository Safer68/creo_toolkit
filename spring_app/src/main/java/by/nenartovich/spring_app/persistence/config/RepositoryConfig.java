package by.nenartovich.spring_app.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("by.nenartovich.spring_app.persistence.model")
@EnableJpaRepositories("by.nenartovich.spring_app.persistence.repository")
public class RepositoryConfig {
}

