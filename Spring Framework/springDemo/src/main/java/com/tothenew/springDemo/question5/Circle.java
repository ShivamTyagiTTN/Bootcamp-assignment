package com.tothenew.springDemo.question5;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Primary annotation used to resolve ambiguity
@Primary
@Component
public class Circle implements Drawable {
    @Override
    public void draw() {

        System.out.println("Drawing Circle");

    }
}
