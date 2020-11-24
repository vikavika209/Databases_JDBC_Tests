package manager;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:account-manager.properties")
public class PropertiesConfiguration {
}
