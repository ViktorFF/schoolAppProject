package by.school.app.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

import java.util.Properties;

import static by.school.app.constant.SaConstants.ENTITY_BASE_PACKAGE;
import static by.school.app.constant.SaConstants.JPA_BASE_PACKAGE;
import static by.school.app.constant.SaConstants.SaJpaConfigConstants.DATA_SOURCE_PASSWORD_PROPERTY;
import static by.school.app.constant.SaConstants.SaJpaConfigConstants.DATA_SOURCE_URL_PROPERTY;
import static by.school.app.constant.SaConstants.SaJpaConfigConstants.DATA_SOURCE_USERNAME_PROPERTY;
import static by.school.app.constant.SaConstants.SaJpaConfigConstants.DDL_AUTO_PROPERTY;
import static by.school.app.constant.SaConstants.SaJpaConfigConstants.DRIVER_CLASS_NAME;

/**
 * SaJpaConfig.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = JPA_BASE_PACKAGE)
public class SaJpaConfig {
    private static final String HIBERNATE_HBM_2_DDL_AUTO = "hibernate.hbm2ddl.auto";

    private final Environment env;

    @Autowired
    public SaJpaConfig(final Environment env) {
        this.env = env;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.POSTGRESQL);
        vendorAdapter.setGenerateDdl(true);

        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(ENTITY_BASE_PACKAGE);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        dataSource.setUrl(env.getProperty(DATA_SOURCE_URL_PROPERTY));
        dataSource.setUsername(env.getProperty(DATA_SOURCE_USERNAME_PROPERTY));
        dataSource.setPassword(env.getProperty(DATA_SOURCE_PASSWORD_PROPERTY));
        return dataSource;
    }

    private Properties additionalProperties() {
        final Properties properties = new Properties();
        properties.setProperty(HIBERNATE_HBM_2_DDL_AUTO, env.getProperty(DDL_AUTO_PROPERTY));
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
