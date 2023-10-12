package org.example.app.views;

import org.example.app.utils.Constants;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class AppView {

    Scanner scanner = new Scanner(System.in);

    public int getOption() {
        showMenu();
        int option = -1;
        try {
            option = scanner.nextInt();
        } catch (InputMismatchException ime) {
            System.out.println(Constants.INCORRECT_VALUE_MSG);
        }
        return option;
    }

    private void showMenu() {
        System.out.print("""
                
                ______ MENU ___________
                1 - Create product.
                2 - View all products.
                3 - View product by id.
                4 - Update product.
                5 - Delete product.
                0 - Close the App.
                """);
    }

    public void getOutput(String output) {
        if (output.equals(Constants.APP_CLOSE_MSG)) {
            System.out.println(output);
        }
        scanner.close();
        System.exit(0);
    }
}
