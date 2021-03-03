package com.tothenew.springDemo.question5;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements Drawable {
    @Override
    public void draw() {

        System.out.println("Drawing Rectangle");
    }
}
