package com.example.AppTienda.Controllers;

import com.example.AppTienda.Domain.DBuy;
import com.example.AppTienda.Domain.DClient;
import com.example.AppTienda.Domain.Services.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shopping")
public class BuyController {

    @Autowired
    private BuyService buyService;

    @GetMapping()
    public ResponseEntity<List<DBuy>> getAll(){
        return new ResponseEntity<>(buyService.getAll(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DBuy>> getById(@PathVariable("id") Integer id){
        Optional<DBuy> buy = buyService.getById(id);
           if(buy.isEmpty()){
               return new ResponseEntity<>(buy , HttpStatus.BAD_REQUEST);
           }else{
               return new ResponseEntity<>(buy , HttpStatus.OK) ;
           }

    }

    @GetMapping("/clients")
    public ResponseEntity<List<DBuy>> clientList(List<DClient> clients){
        return new ResponseEntity<>(buyService.clientList(clients), HttpStatus.OK);
    }


    @PostMapping("/buy")
    public ResponseEntity<DBuy> save(@RequestBody DBuy DBuy){
        return new ResponseEntity<>(buyService.save(DBuy) , HttpStatus.CREATED);
    }


    @DeleteMapping("/buy/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        buyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}
