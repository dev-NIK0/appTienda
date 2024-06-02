package com.example.AppTienda.Controllers;

import com.example.AppTienda.Domain.DClient;
import com.example.AppTienda.Domain.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @GetMapping
    public ResponseEntity<List<DClient>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DClient>> getById(@PathVariable("id") Integer id){
        Optional<DClient> client = clientService.getById(id);
        if(client.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @PostMapping("/client")
    public ResponseEntity<DClient> save(@RequestBody DClient client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")  Integer id){
        clientService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
