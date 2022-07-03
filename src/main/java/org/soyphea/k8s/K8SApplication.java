package org.soyphea.k8s;

import lombok.extern.slf4j.Slf4j;

import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.soyphea.k8s.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class K8SApplication implements CommandLineRunner {


    @Autowired
    UserConfig userConfig;

    public static void main(String[] args) {
        SpringApplication.run(K8SApplication.class, args);
        String xVaultToken = System.getenv("XVaultToken");
        String cityAppConfig = System.getenv("CityApp_Config");
        System.out.println(xVaultToken);
        System.out.println(cityAppConfig);
        String user = "root";
        String pass = "123456789";
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnknownHostException
    {
        String input = req.getParameter("input");

        MongoClient mongoClient = new MongoClient();
        DB database             = mongoClient.getDB("exampleDatabase");
        //DBCollection collection = database.getCollection("exampleCollection");
        //BasicDBObject query     = new BasicDBObject();

       // query.put("$where", "this.field == \"" + input + "\""); // Noncompliant
    }

    @Override
    public void run(String... args) throws Exception {
      //  Logger.info(" Fetched user from k8s ConfigMap <spring-boot-k8s> is :{}", userConfig);

    }
}
