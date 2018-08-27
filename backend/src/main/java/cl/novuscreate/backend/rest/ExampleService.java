package cl.novuscreate.backend.rest;

import cl.novuscreate.backend.entity.Example;
import cl.novuscreate.backend.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/examples")
public class ExampleService {

    @Autowired
    ExampleRepository exampleRepository;


    @GetMapping
    public Iterable<Example> getAllExamples() {

        return exampleRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Example findOne(@PathVariable("id") Integer id) {

        return exampleRepository.findOne(id);

    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Example create(@RequestBody Example resource) {
        System.out.println(resource);
        return exampleRepository.save(resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer Id) {
        Example problem = exampleRepository.findOne(Id);

        exampleRepository.delete(problem);

        return ResponseEntity.ok().build();
    }
}
