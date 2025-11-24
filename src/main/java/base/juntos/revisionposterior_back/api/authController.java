package base.juntos.revisionposterior_back.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class authController {

    @GetMapping("/hola")
    @PreAuthorize("permitAll()")
    public  String hello(){
        return "hola";
    }


    @GetMapping("/hola2")
    @PreAuthorize("hasAnyRole('004')")
    public  String helloSecured(){
        return "hello Secured";
    }

    @GetMapping("/hola3")
    @PreAuthorize("hasAnyRole('USER')")
    public  String helloSecured2(){
        return "hello Secured 2";
    }
}
