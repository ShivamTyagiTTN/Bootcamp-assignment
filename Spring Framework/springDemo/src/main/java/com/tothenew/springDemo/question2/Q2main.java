/*
*   Q2. Write a program to demonstrate Loosely Coupled code.
*/

package com.tothenew.springDemo.question2;

public class Q2main {

    public static void main(String[] args) {

        Artist artist = new Artist(new Rectangle());

        artist.drawShape();

    }

}