package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

    public static int menuChoice(String message, String[] choices) throws IOException, NumberFormatException {
        int selected;
        int i = 0;
        System.out.println("***************************");
        System.out.println(message);
        for (String option : choices){
            System.out.println(i++ + " " + option);
        }
        System.out.println("***************************");

        do{
            selected = Integer.valueOf(IO.getUserInput("Selecciona una opcion:"));
        } while(selected < 0 && selected >= choices.length);
        return selected;
    }

    public static int getUserNumericInput(String message) throws IOException, NumberFormatException {
        return Integer.valueOf(getUserInput(message));
    }

    public static String getUserInput(String message) throws IOException {
        BufferedReader keyboard;
        String input;
        do{
            System.out.println(message);
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            input = keyboard.readLine();
        } while(null == input);

        return input;
    }
}
