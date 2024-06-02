package com.example.AppTienda.Controllers;

import com.example.AppTienda.Domain.DCategory;
import com.example.AppTienda.Domain.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<DCategory>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DCategory>> getById(@PathVariable("id")Integer id){

        Optional<DCategory> category = categoryService.getById(id);

        if(category.isEmpty()){
            return new ResponseEntity<>(category,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<>(category,HttpStatus.OK);
        }

    }

    @PostMapping("/category")
    public ResponseEntity<DCategory> save(@RequestBody DCategory category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED) ;
    }


    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void>  deleteById(@PathVariable("id") Integer id){
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
