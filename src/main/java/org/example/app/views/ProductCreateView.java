package org.example.app.views;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class ProductCreateView extends BaseView {

    public Map<String, String> getData() {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> data = new HashMap<>();

        String title = "Input name: ";
        System.out.print(title);
        data.put("name", scanner.nextLine().trim());

        title = "Input quota: ";
        System.out.print(title);
        data.put("quota", scanner.nextLine().trim());

        title = "Input price: ";
        System.out.print(title);
        data.put("price", scanner.nextLine().trim());

        return data;
    }
}
