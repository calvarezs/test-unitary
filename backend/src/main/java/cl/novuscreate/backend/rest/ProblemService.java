package cl.novuscreate.backend.rest;

//import cl.novuscreate.backend.entity.User;
//import cl.novuscreate.backend.repository.UserRepository;
import cl.novuscreate.backend.entity.*;
import cl.novuscreate.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/problems")
public class ProblemService {


    @Autowired
    private ProblemRepository problemRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private UserProblemRepository userProblemRepository;

    @Autowired
    private ExampleRepository exampleRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private InputRepository inputRepository;



    @GetMapping
    public Iterable<Problem> getAllProblems() {

        return problemRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Problem findOne(@PathVariable("id") Integer id) {

        return problemRepository.findOne(id);

    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Problem create(@RequestBody Problem resource) {
        System.out.println(resource);

        problemRepository.save(resource);

        if ( !resource.getProblemExamples().isEmpty()  ){
            for (Example example : resource.getProblemExamples()) {
                System.out.println(example.getExampleTitle());

                exampleRepository.save(example);

                if ( example.getResult() != null ){
//                    System.out.println("El id es"+);
                    example.getResult().setExample(example);
                    resultRepository.save(example.getResult());
                }

                if (example.getExampleInputs() != null){
                    for (Input input : example.getExampleInputs()){
//                        input.setExample(example);
                        inputRepository.save(input);
                    }
                }

            }
        }

        return resource;
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
        Problem problem = problemRepository.findOne(Id);

        problemRepository.delete(problem);

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{problem_id}/users/{id}/completed",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Problem createCompleteUserProblem(@PathVariable("id") Integer id, @PathVariable("problem_id") Integer problem_id) {
        User user = userRepository.findOne(id);
        if(user!=null)
        {
            Problem problem = problemRepository.findOne(problem_id);
            UserProblem userProblem = new UserProblem(user, problem, 1);
            userProblemRepository.save(userProblem);
            return problem;
        }
        else
        {
            return null;
        }

    }

    @RequestMapping(value = "/{problem_id}/users/{id}/incompleted",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Problem createIncompleteUserProblem(@PathVariable("id") Integer id, @PathVariable("problem_id") Integer problem_id) {
        User user = userRepository.findOne(id);
        if(user!=null)
        {
            Problem problem = problemRepository.findOne(problem_id);
            UserProblem userProblem = new UserProblem(user, problem, 0);
            userProblemRepository.save(userProblem);
            return problem;
        }
        else
        {
            return null;
        }

    }




}

