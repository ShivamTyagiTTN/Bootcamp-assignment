package com.tothenew.springDemo.question3and6;

import org.springframework.stereotype.Component;

@Component
public class Circle implements Drawable {
    @Override
    public void draw() {

        System.out.println("Drawing Circle");

    }
}
