
/**
 * @file App.java
 * @author markJia(markjia@tencent.com)
 */

package server_demo.src.main.java.com.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {

  @RequestMapping("/")
  String home() {
    return "hello world";
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
