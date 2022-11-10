package com.raq.demoreactive;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

/*

    @GetMapping("/demo")
    public Mono<String> greetingMessage(){
        return getMessage();
    }
*/

    @GetMapping("/demo")
    public Mono<String> greetingMessage(){
        return getMessage().zipWith(getAbdulFromDB()).map(value -> value.getT1() + value.getT2());
    }


    private Mono<String> getMessage(){
        return Mono.just("Hello").delayElement(Duration.ofSeconds(5));
    }

    private Mono<String> getAbdulFromDB(){
        return Mono.just("Abdul").delayElement(Duration.ofSeconds(5));
    }


}
