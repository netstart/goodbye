package io.github.webflux.goodbye;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServerController {

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/goodbye", produces = "text/plain")
    public String goodbye() {
        String msg = "Goodbye with Spring Boot on " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(new Date());
        System.out.println(msg);
        return msg;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/nap", produces = "text/plain")
    public String goodbyeNap() {
        System.out.println("Received request on Thread: " + Thread.currentThread().getName());
        // Sleep 30 seconds
        // Thread.sleep(30000);
        Pi.computePi(20000);
        System.out.println("Back from the nap with " + Thread.currentThread().getName());
        return "Nap from " + new Date().toString();
    }

}