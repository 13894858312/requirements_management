package cn.edu.nju.rm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by wangxue on 2018/12/10.
 * @author wangxue
 */
@EnableScheduling
@SpringBootApplication
@MapperScan("cn.edu.nju.rm.dao")
public class Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}
