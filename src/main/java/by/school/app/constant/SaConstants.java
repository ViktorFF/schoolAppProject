package by.school.app.constant;

/**
 * SaConstants.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
public class SaConstants {
    public static final String SA_VERSION = "0.0.1";
    public static final String BASE_PACKAGE = "by.school.app";
    public static final String JPA_BASE_PACKAGE = BASE_PACKAGE + ".repository";
    public static final String ENTITY_BASE_PACKAGE = BASE_PACKAGE + ".model";

    private SaConstants() {
        //empty
    }

    public static final class SaJpaConfigConstants {
        public static final String DRIVER_CLASS_NAME  = "org.postgresql.Driver";
        public static final String DATA_SOURCE_URL_PROPERTY  = "spring.datasource.url";
        public static final String DATA_SOURCE_USERNAME_PROPERTY  = "spring.datasource.username";
        public static final String DATA_SOURCE_PASSWORD_PROPERTY  = "spring.datasource.password";
        public static final String DDL_AUTO_PROPERTY  = "spring.jpa.hibernate.ddl-auto";

        private SaJpaConfigConstants() {
            //empty
        }
    }
}
