package com.erya.mall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class MallApplication {

    public static void main(String[] args) throws UnknownHostException {

        Logger log = LoggerFactory.getLogger(MallApplication.class);
        ApplicationContext context = SpringApplication.run(MallApplication.class, args);
        context.getEnvironment();
        Environment env = context.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");

        String path = env.getProperty("server.servlet.context-path");
        path = path == null ? "" : path;
        log.info("\n----------------------------------------------------------\n\t" +
                "SPD:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: \thttp://" + ip + ":" + port + path + "/swagger-ui.html\n\t" +
                "Doc: \t\thttp://" + ip + ":" + port + path + "/doc.html\n" +
                "----------------------------------------------------------");
    }

}
