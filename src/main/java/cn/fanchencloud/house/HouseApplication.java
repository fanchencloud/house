package cn.fanchencloud.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author chen
 */
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HouseApplication.class, args);
    }

}
