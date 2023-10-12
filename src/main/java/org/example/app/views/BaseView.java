package org.example.app.views;

import org.springframework.stereotype.Component;

@Component
public class BaseView {

    public void getOutput(String output) {
        System.out.println(output);
    }
}
