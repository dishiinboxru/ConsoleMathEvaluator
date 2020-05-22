package org.dshimanskii;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        while (true) {

                //creating a map to store variables
                Map<String, String> variables = new HashMap<String, String>();
                Validator validator = new Validator();

                Scanner sc = new Scanner(System.in);
                String originalExpressionModified;

            try {
                do {
                    //request for input
                    System.out.println("please specify the expression you'd like to evaluate");
                    originalExpressionModified = sc.nextLine();
                }
                while (validator.validateAllDigitsAre16bits(originalExpressionModified) && validator.validateNotEmpty(originalExpressionModified))
                    //TODO basic validation that only math signs, digits and char.digit pattern is used
                        ;

                System.out.println("OK");

                //requesting an input for each variable ()
                //System.out.println("now receiving variables");

                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    if (line.equals("calculate")) {
                        break;
                    }

                    variables.put(line.split("=")[0].trim(), line.split("=")[1].trim());
                    System.out.println("OK");
                    //System.out.println("OK, variable received");
                }

                //System.out.println("variables we collected are " + variables.toString());
                //iterating over the map in order to replace all variables
                for (Map.Entry<String, String> entry : variables.entrySet()) {
                    CharSequence var1 = entry.getKey();
                    CharSequence val1 = entry.getValue();

                    originalExpressionModified = originalExpressionModified.replace(var1, val1);
                    //System.out.println("modified expression is " + originalExpressionModified);
                }

                //getting the script ready
                ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
                ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");

                String inputFromUser = originalExpressionModified;
                Object resultFromUser = scriptEngine.eval(inputFromUser);

                System.out.println("Result of calculation from user  is   = " + resultFromUser);
                break; //If you want the programm to receive expressions indefinetly, not once per run, remove this line

            } catch (ScriptException e) {
                System.out.println("incorrect math expression, try again . The cause of the problem is " + e);
                continue;
            }
        }


        //TODO - rounding result to human readable
    }
}