package com.example.s14007.myapplication;

/**
 * Created by s14007 on 16/07/27.
 */
public class Person {
    // 名前
    private String name;
    // 趣味
    private String hobby;

    public Person(String name, String hobby){
        super();

        this.name = name;
        this.hobby = hobby;
    }

    public String getName(){
        return this.name;
    }

    public String getHobby(){
        return this.hobby;
    }
}
