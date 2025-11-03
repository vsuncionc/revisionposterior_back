package base.juntos.revisionposterior_back.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authController {

    @GetMapping("/hola")
    public  String hello(){
        return "hola";
    }


    @GetMapping("/hola-secured")
    public  String helloSecured(){
        return "hello Secured";
    }
}
