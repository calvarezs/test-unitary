package cl.novuscreate.backend.rest;

import cl.novuscreate.backend.entity.Problem;
import cl.novuscreate.backend.entity.User;
import cl.novuscreate.backend.repository.ProblemRepository;
import cl.novuscreate.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserService {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProblemRepository problemRepository;


    @GetMapping
    public Iterable<User> getAllUsers() {

        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User findOne(@PathVariable("id") Integer id) {

        return userRepository.findOne(id);

    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User create(@RequestBody User resource) {
        System.out.println(resource);
        return userRepository.save(resource);
    }


//    @PutMapping("/{id}")
//    public User updateNote(@PathVariable(value = "id") Integer productId,
//                               @Valid @RequestBody User userDetails) {
//
//        User user = userRepository.findOne(productId);
//
//
//        user.setCategoryName(categoryDetails.getCategoryName());
//
//
//        Category updatedCategory = categoryRepository.save(category);
//        return updatedCategory;
//    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Integer Id) {
        User user = userRepository.findOne(Id);

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{id}/problems", method = RequestMethod.GET)
    @ResponseBody
    public Set<Problem> findActorMovies(@PathVariable("id") Integer id) {

        User user = userRepository.findOne(id);

        return user.getProblems();
    }


}
