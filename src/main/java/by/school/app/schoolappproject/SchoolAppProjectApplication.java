package by.school.app.schoolappproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static by.school.app.constant.SaConstants.BASE_PACKAGE;

/**
 * SchoolAppProjectApplication.
 *
 * @author Victor Bakhanovich <victor.bahanovich@gmail.com>
 */
@SpringBootApplication(scanBasePackages = {BASE_PACKAGE})
public class SchoolAppProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchoolAppProjectApplication.class, args);
    }
}
