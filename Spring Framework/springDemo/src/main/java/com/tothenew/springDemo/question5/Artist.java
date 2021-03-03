package com.tothenew.springDemo.question5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Artist {

    @Autowired
    private Drawable drawable;

    public Artist(Drawable draw) {
        this.drawable = draw;
    }

    public void drawShape() {
        drawable.draw();
    }

}
