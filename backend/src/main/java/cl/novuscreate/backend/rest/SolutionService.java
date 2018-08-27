package cl.novuscreate.backend.rest;


import cl.novuscreate.backend.api.GlotCall;
import cl.novuscreate.backend.entity.Example;
import cl.novuscreate.backend.entity.Problem;
import cl.novuscreate.backend.entity.Solution;
import cl.novuscreate.backend.entity.UserProblem;
import cl.novuscreate.backend.repository.ProblemRepository;
import cl.novuscreate.backend.repository.SolutionRepository;
import cl.novuscreate.backend.repository.UserProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/solutions")
public class SolutionService {

    @Autowired
    private SolutionRepository solutionRepository;
    @Autowired
    private UserProblemRepository userProblemRepository;
    @Autowired
    private ProblemRepository problemRepository;

    @GetMapping
    public Iterable<Solution> getAllSolutions() {

        return solutionRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Solution findOne(@PathVariable("id") Integer id) {

        Solution solution = solutionRepository.findOne(id);
//        solution.execPythonScript("def factorial(n):\n" +
//                "    if n == 0:\n" +
//                "        return 1\n" +
//                "    else:\n" +
//                "        return n * factorial(n-1)\n" +
//                "number3 = factorial(number1)");
        solution.execPythonScript(solution.getSolutionCode());


        return solutionRepository.findOne(id);

    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Solution create(@RequestBody Solution resource) {
        System.out.println(resource);
        GlotCall glotCall = new GlotCall(resource.getLanguage(),resource.getSolutionCode());
        resource.setTheSolution(glotCall.runCode());

//        solutionRepository.save(resource);
        Solution solution = solutionRepository.save(resource);
        Problem problem = solution.getUserProblem().getProblem();
        System.out.println(problem);
        Problem problem2 = problemRepository.findOne(problem.getProblemId());
        System.out.println("*****///");
        Set<Example> examples = problem2.getProblemExamples();
        System.out.println(problem2.getProblemTitle());
//        Example example = examples. ;
        Boolean works = false;
        System.out.println(examples.size());
        for (Example example : examples){
            String tipo = example.getResult().getResultType();
//            Integer comparate;
//            if (tipo == "Entero") {
//                comparate = Integer.parseInt(resource.getTheSolution());
//                if(comparate == example.getResult().getResultValue() );
//            }
            System.out.println(example.getExampleTitle());
            System.out.println("********");
            System.out.println(example.getResult().getResultValue());
            System.out.println(resource.getTheSolution());

            System.out.println(example.getResult().getResultValue().getClass());
            System.out.println(resource.getTheSolution().getClass());
            System.out.println("********");

//            if(example.getResult().getResultValue() === resource.getTheSolution()){
              if ( example.getResult().getResultValue().equals(resource.getTheSolution()) ){
                System.out.println("********2");
                System.out.println(example.getResult().getResultValue());
                System.out.println(resource.getTheSolution());
                System.out.println("********2");

                works = true;
            }
        }

        if (works){
            UserProblem userProblem =resource.getUserProblem();
            userProblem.setStatusComplete(1);
            userProblem.setSolution(solution);

            if (solution.getLanguage().equals("Python") || solution.getLanguage().equals("python") ){
                userProblem.setFeedback( solution.staticCodeAnalysisInPython(userProblem.getSolution().getSolutionCode()) );
            }
            else if (solution.getLanguage().equals("C") || solution.getLanguage().equals("c") ){
                userProblem.setFeedback( solution.staticCodeAnalysisInC( userProblem.getSolution().getSolutionCode()) );

            }
            userProblemRepository.save(userProblem);

//            resource.getUserProblem().setCreatedOn();
        }

        return resource;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSolution(@PathVariable(value = "id") Integer Id) {
        Solution problem = solutionRepository.findOne(Id);

        solutionRepository.delete(problem);

        return ResponseEntity.ok().build();
    }


}
