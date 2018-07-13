package at.bitmedia.schoolreader;

import at.bitmedia.schoolreader.entity.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication(exclude = JmxAutoConfiguration.class)
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class SchoolReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolReaderApplication.class, args);
	}
}
