package cl.novuscreate.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="solutions", uniqueConstraints = @UniqueConstraint(columnNames = "SOLUTION_ID"))
public class Solution {

    private int solutionId;
    private String solutionCode;
    private UserProblem userProblem;
    private String theSolution;
    private String language;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "SOLUTION_ID", unique = true, nullable = false)
    public int getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(int solutionId) {
        this.solutionId = solutionId;
    }

    @Column(name = "SOLUTION_CODE", nullable = false, columnDefinition = "TEXT")
    public String getSolutionCode() {
        return solutionCode;
    }

    public void setSolutionCode(String solutionCode) {
        this.solutionCode = solutionCode;
    }


    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "solution")
    public UserProblem getUserProblem() {
        return userProblem;
    }

    public void setUserProblem(UserProblem userProblem) {
        this.userProblem = userProblem;
    }

    @Column(name = "user_solution", nullable = false)
    public String getTheSolution() {
        return theSolution;
    }

    @Column(name = "language_solution", nullable = false)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setTheSolution(String theSolution) {
        this.theSolution = theSolution;
    }

    public boolean verificateSolution(){  
        if(getLanguage() == null)
            return false;
        if(getSolutionCode() == null)
            return false;

        return true;
    }

    public void execPythonScript(String code){
        PythonInterpreter python = new PythonInterpreter();

        int number1 = 10;
//        int number2 = 32;

        python.set("number1", new PyInteger(number1));
//        python.set("number2", new PyInteger(number2));

//        python.exec("def factorial(n):\n" +
//                "    if n == 0:\n" +
//                "        return 1\n" +
//                "    else:\n" +
//                "        return n * factorial(n-1)\n" +
//                "number3 = factorial(number1)");

        python.exec(code);

//        python.exec("number3 = number1+number2");
        PyObject number3 = python.get("number3");
        System.out.println("val : "+number3.toString());
    }

    public String staticCodeAnalysisInPython(String code) {
        //check commentary quality in code word by word
        //Check Regular expressions online:
        // http://www.beansoftware.com/Test-Net-Regular-Expressions/Split-String.aspx
        String Output="";
        //Make split from any commentary in code
        String[] codeWords = code.split("([#])|([“][”][”][”])|\\n");
        String[] codeWordsInLine;

        int currentLineCode = 1;

        //Check for presence of inputs, process and output of function
        boolean hasInputComment = false;
        boolean hasProcessComment = false;
        boolean hasOutputComment = false;

        //Check for comentaries in format:  //comentary
        boolean isHalfComentary = false;
        //Check for comentaries in format:  /*comentary*/
        boolean isTrueComentary = false;

        //For all line of code in codewords
        for (int i = 0; i < codeWords.length; i++) {
            if (codeWords[i].contains("\n")) {
                currentLineCode++;
            }

            //if the string is the start or end of a commentary
            if (codeWords[i].contains("\"\"\"\"")) {
                isTrueComentary = true;
            }
            else if (isTrueComentary == true && codeWords[i].contains("\"\"\"\"")) {
                isTrueComentary = false;
            }
            else if (codeWords[i].contains("#")) {
                isHalfComentary = true;
            }
            else if (isHalfComentary == true || isTrueComentary == true) {
                isHalfComentary = false;
                if (codeWords[i].toLowerCase().contains("entrada")) {
                    hasInputComment = true;
                }
                else if (codeWords[i].toLowerCase().contains("proces")) {
                    hasProcessComment = true;
                }
                else if (codeWords[i].toLowerCase().contains("salida")) {
                    hasOutputComment = true;
                }
            }
            else
            {
                codeWordsInLine = codeWords[i].split("[^a-zA-Z][^a-zA-Z,0-9]*");
                for (String palabra:codeWordsInLine) {
                    if (palabra.length() == 1 && palabra.charAt(0)<'i') {
                        System.out.println("Buenas prácticas: Nombre no representativo en línea : "+currentLineCode);
                        Output += "Buenas prácticas: Nombre no representativo en línea : "+currentLineCode+"\n";
                    }
                    else if (palabra.length() != 0 && palabra.length() < 4 && !palabra.contains("if")) {
                        System.out.println("Buenas prácticas: Nombre demasiado corto en línea : "+currentLineCode);
                        Output += "Buenas prácticas: Nombre demasiado corto en línea : "+currentLineCode+"\n";
                    }
                }
            }
        }

        if (hasInputComment == false)
        {
            System.out.println("Buenas prácticas: Comentario de entrada no encontrado");
            Output += "Buenas prácticas: Comentario de entrada no encontrado\n";
        }
        if (hasOutputComment == false) {
            System.out.println("Buenas prácticas: Comentario de salida no encontrado");
            Output += "Buenas prácticas: Comentario de salida no encontrado\n";
        }
        if (hasProcessComment == false) {
            System.out.println("Buenas prácticas: Comentario de procesamiento no encontrado");
            Output+= "Buenas prácticas: Comentario de procesamiento no encontrado\n";
        }

        return Output;
    }

    public String staticCodeAnalysisInC(String code) {
        int expectedIdentation = 0, currentIdentation = 0;
        int currentLineCode = 1;

        String Output="";
        //Check for comentaries in format:  //comentary
        boolean isHalfComentary = false;
        //Check for comentaries in format:  /*comentary*/
        boolean isTrueComentary = false;

        //Check code structuration and identation letter for letter
        int i = 0;
        int currentState = 1;
        int codeLenght = code.length();
        char currentLetter = code.charAt(0);
        /*DEBUG*/System.out.println("Code Lenght: "+codeLenght);
        while (i<codeLenght) {

            if (currentLetter == '\t') {
                currentIdentation++;
            }
            else if (currentLetter == '\n') {
                if (currentIdentation < expectedIdentation) {
                    System.out.println("Buenas prácticas: Se esperaba identación en línea: "+currentLineCode);System.out.println("Code Lenght: "+codeLenght);
                    Output+= "Buenas prácticas: Se esperaba identación en línea: "+currentLineCode+"\n";

                }
                currentLineCode++;
                currentIdentation = 0;
                isHalfComentary = false;
                /*DEBUG*/System.out.println("New line: "+currentLineCode);
            }

            //check for half and complete comentaries
            if (i+1<codeLenght && code.charAt(i) == '/' && code.charAt(i+1) == '/') {
                isHalfComentary = true;
            }
            else if (i+1<codeLenght && code.charAt(i) == '/' && code.charAt(i+1) == '*') {
                isTrueComentary = true;
            }
            else if (i+1<codeLenght && code.charAt(i) == '*' && code.charAt(i+1) == '/') {
                isTrueComentary = false;
            }

            //if a object in the code is not commented
            if (isHalfComentary == false && isTrueComentary == false){
                switch (code.charAt(i)) {
                    case 1:
                        if (currentLetter == '(') {
                            currentState = 2;
                        }
                        else if (currentLetter == '\t') {
                            System.out.println("Buenas prácticas: No es necesario generar identación en línea: "+currentLineCode);
                            Output+="Buenas prácticas: No es necesario generar identación en línea: "+currentLineCode+"\n";
                        }
                        break;
                    case 2:
                        if (currentLetter == ')') {
                            currentState = 3;
                        }
                        else if (!(currentLetter == ' ' || currentLetter == '\t' || currentLetter == '\n'))
                        {
                            currentState = 1;
                        }
                        break;
                    case 3:
                        if (currentLetter == '{') {
                            currentState = 4;
                            expectedIdentation++;
                        }
                        break;
                    case 4:
                        if (currentLetter == '\n') {
                            currentState = 5;
                        }
                        else if (currentLetter == '}') {
                            expectedIdentation--;
                        }
                        else if (currentLetter == '{') {
                            expectedIdentation++;
                            System.out.println("Buenas prácticas: Se esperaba nueva línea en línea : "+currentLineCode);
                            Output+= "Buenas prácticas: Se esperaba nueva línea en línea : "+currentLineCode+"\n";
                        }
                        break;
                    case 5:
                        if (currentLetter == '{') {
                            currentState = 4;
                            expectedIdentation++;
                        }
                        else if (currentLetter == ';') {
                            currentState = 4;
                        }
                        break;
                    default:
                        currentState = 1;
                        break;
                }
            }
            i++;
            currentLetter = code.charAt(i);
        }

        //check commentary quality in code word by word
        //Check Regular expressions online:
        // http://www.beansoftware.com/Test-Net-Regular-Expressions/Split-String.aspx

        //Make split from any commentary in code
        String[] codeWords = code.split("([/][/])|([/][*])|([*][/])|\\n");
        String[] codeWordsInLine;

        currentLineCode = 1;

        //Check for presence of inputs, process and output of function
        boolean hasInputComment = false;
        boolean hasProcessComment = false;
        boolean hasOutputComment = false;

        //Check for comentaries in format:  //comentary
        isHalfComentary = false;
        //Check for comentaries in format:  /*comentary*/
        isTrueComentary = false;

        //For all line of code in codewords
        for (i = 0; i < codeWords.length; i++) {
            if (codeWords[i].contains("\n")) {
                currentLineCode++;
            }

            //if the string is the start or end of a commentary
            if (codeWords[i].contains("/*")) {
                isTrueComentary = true;
            }
            else if (codeWords[i].contains("*/")) {
                isTrueComentary = false;
            }
            else if (codeWords[i].contains("//")) {
                isHalfComentary = true;
            }
            else if (isHalfComentary == true || isTrueComentary == true) {
                isHalfComentary = false;
                if (codeWords[i].toLowerCase().contains("entrada")) {
                    hasInputComment = true;
                }
                else if (codeWords[i].toLowerCase().contains("proces")) {
                    hasProcessComment = true;
                }
                else if (codeWords[i].toLowerCase().contains("salida")) {
                    hasOutputComment = true;
                }
            }
            else
            {
                codeWordsInLine = codeWords[i].split("[^a-zA-Z][^a-zA-Z,0-9]*");
                for (String palabra:codeWordsInLine) {
                    if (palabra.length() == 1 && palabra.charAt(0)<'i') {
                        System.out.println("Buenas prácticas: Nombre no representativo en línea : "+currentLineCode);
                        Output+="Buenas prácticas: Nombre no representativo en línea : "+currentLineCode+"\n";
                    }
                    else if (palabra.length() != 0 && palabra.length() < 4 && !palabra.contains("if")) {
                        System.out.println("Buenas prácticas: Nombre demasiado corto en línea : "+currentLineCode);
                        Output+= "Buenas prácticas: Nombre demasiado corto en línea : "+currentLineCode+"\n";
                    }
                }
            }
        }

        if (hasInputComment == false)
        {
            System.out.println("Buenas prácticas: Comentario de entrada no encontrado");
            Output+= "Buenas prácticas: Comentario de entrada no encontrado\n";
        }
        if (hasOutputComment == false) {
            System.out.println("Buenas prácticas: Comentario de salida no encontrado");
            Output+="Buenas prácticas: Comentario de salida no encontrado\n";
        }
        if (hasProcessComment == false) {
            System.out.println("Buenas prácticas: Comentario de procesamiento no encontrado");
            Output+="Buenas prácticas: Comentario de procesamiento no encontrado\n";
        }

        return Output;
    }

    public void staticCodeAnalysisInJava(String code) {
        //Because Java and C have similar good practices and for no abuse from self-copy code
        staticCodeAnalysisInC(code);
        return;
    }
}
