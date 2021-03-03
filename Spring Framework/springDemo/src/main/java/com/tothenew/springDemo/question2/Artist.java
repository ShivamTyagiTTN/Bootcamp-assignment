package com.tothenew.springDemo.question2;

public class Artist {

    private Drawable drawable;

    public Artist(Drawable draw) {
        this.drawable = draw;
    }

    public void drawShape(){
        drawable.draw();
    }

}
