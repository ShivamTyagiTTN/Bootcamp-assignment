package com.tothenew.springDemo.question4;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Drawable {
    @Override
    public void draw() {

        System.out.println("Drawing Circle");

    }
}
