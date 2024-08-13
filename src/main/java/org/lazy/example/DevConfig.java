package org.lazy.example;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.lazy.common.Configuration;
import org.lazy.common.Produces;
import org.lazy.core.Environment;
import org.lazy.jpa.HibernateJpaProviderAdapter;
import org.lazy.jpa.JpaLocalTransactionManager;
import org.lazy.jpa.JpaProperties;
import org.lazy.jpa.LocalTransactionManager;
import org.lazy.jpa.integration.LocalEntityManagerFactoryBuilder;

@Named("dev")
@Configuration
public class DevConfig {
    
    private final Environment env;

    public DevConfig(Environment env) {
        this.env = env;
    }

    @Produces
    public EntityManagerFactory entityManagerFactory() {
        return new LocalEntityManagerFactoryBuilder(new HibernateJpaProviderAdapter())
                .packageToScan("org.lazy.example")
                .jpaProperties(additionalProperties())
                .dataSource(dataSource()).build();
    }

    @Produces
    public LocalTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaLocalTransactionManager(entityManagerFactory);
    }

    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty(JpaProperties.DATABSE_DRIVER_CLASS_NAME.getName()));
        dataSource.setUrl(env.getProperty(JpaProperties.DATABASE_URL.getName()));
        dataSource.setUsername(env.getProperty(JpaProperties.DATABASE_USERNAME.getName()));
        dataSource.setPassword(env.getProperty(JpaProperties.DATABASE_PASSWORD.getName()));
        return dataSource;
    }

    Map<String, Object> additionalProperties() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.current_session_context_class", env.getProperty("hibernate.current_session_context_class"));
        return properties;
    }

}
