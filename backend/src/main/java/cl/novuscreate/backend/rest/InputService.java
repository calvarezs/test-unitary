package cl.novuscreate.backend.rest;


import cl.novuscreate.backend.entity.Input;

import cl.novuscreate.backend.repository.InputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/inputs")
public class InputService {


    @Autowired
    InputRepository inputRepository;


    @GetMapping
    public Iterable<Input> getAllExamples() {

        return inputRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Input findOne(@PathVariable("id") Integer id) {

        return inputRepository.findOne(id);

    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Input create(@RequestBody Input resource) {
        System.out.println(resource);
        return inputRepository.save(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer Id) {
        Input problem = inputRepository.findOne(Id);

        inputRepository.delete(problem);

        return ResponseEntity.ok().build();
    }
}
