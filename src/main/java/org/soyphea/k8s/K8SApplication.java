package org.soyphea.k8s;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;
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
        byte[] salt = "notrandom".getBytes();

        PBEParameterSpec cipherSpec = new PBEParameterSpec(salt, 10000); // Noncompliant, predictable salt
      
		char[] chars = null;
		PBEKeySpec spec = new PBEKeySpec(chars, salt, 10000, 256); // Noncompliant, predictable salt
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       
		String file = "users-card.csv";

        File fileUnsafe = new File(file);
        try {
          FileUtils.forceDelete(fileUnsafe); // Noncompliant
   
        }
        catch(IOException ex){
          System.out.println (ex.toString());
        }
    }
  

    @Override
    public void run(String... args) throws Exception {
      //  Logger.info(" Fetched user from k8s ConfigMap <spring-boot-k8s> is :{}", userConfig);

    }
}
