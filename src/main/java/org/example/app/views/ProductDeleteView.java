package org.example.app.views;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductDeleteView extends BaseView {

    public String getData() {
        Scanner scanner = new Scanner(System.in);
        String title = "Input id: ";
        System.out.print(title);
        return scanner.nextLine().trim();
    }
}
