package cl.novuscreate.backend;

import org.python.util.PythonInterpreter;
import org.python.core.*;

class jython{
    public static void main(String a[]){

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

        python.exec("def factorial(n):\n" +
                "    if n == 0:\n" +
                "        return 1\n" +
                "    else:\n" +
                "        return n * factorial(n-1)\n" +
                "number3 = factorial(number1)");



//        python.exec("number3 = number1+number2");
        PyObject number3 = python.get("number3");
        System.out.println("val : "+number3.toString());
    }
}
