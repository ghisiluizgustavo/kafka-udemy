package me.ghisiluizgustavo.strproducer.resources;

import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.strproducer.services.StringProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/producer")
public class StringProducerResource {

    private final StringProducerService producerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMessage(@RequestBody String message){
        producerService.sendMessage(message);
    }
}
