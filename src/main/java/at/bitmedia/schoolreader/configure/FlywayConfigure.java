package at.bitmedia.schoolreader.configure;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class FlywayConfigure {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Bean(name = "flyway", initMethod = "migrate")
    public Flyway flywayTheDestroyer() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setBaselineOnMigrate(true);
        flyway.setIgnoreMissingMigrations(true);
        return flyway;
    }

}
