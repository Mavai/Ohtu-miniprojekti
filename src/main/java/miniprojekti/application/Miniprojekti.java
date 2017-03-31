package miniprojekti.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by marko on 31.3.2017.
 */

@SpringBootApplication
@Controller
public class Miniprojekti {
    @RequestMapping("*")
    public String home() {
        return "index";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Miniprojekti.class, args);
    }
}
