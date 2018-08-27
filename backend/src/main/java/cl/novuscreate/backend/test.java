package cl.novuscreate.backend;

import java.io.*;

class test{
    public static void main(String a[]){
        try{

            String prg = "import sys\nprint int(sys.argv[1])+int(sys.argv[2])\n";
            BufferedWriter out = new BufferedWriter(new FileWriter("test.py"));
            out.write(prg);
            out.close();
            int number1 = 10;
            int number2 = 32;

            ProcessBuilder pb = new ProcessBuilder("python","test.py",String.valueOf(number1),String.valueOf(number2));

            Process p = pb.start();

            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

//            System.out.println(in.readLine());


            int ret =  Integer.parseInt(in.readLine());


            System.out.println("value is : "+ret);


        }catch(Exception e){System.out.println(e);}
    }
}