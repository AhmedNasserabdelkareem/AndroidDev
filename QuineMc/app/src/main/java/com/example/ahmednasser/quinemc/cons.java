package com.example.ahmednasser.quinemc;

import android.widget.TextView;

/**
 * Created by Ahmednasser on 8/2/2017.
 */

public class cons {
    private SinglyLinkedList first;
    private SinglyLinkedList sec;
    private String c;
    private String d;


    public cons (String x , String y) {
        c=x;
        d=y;
    }
    public cons(SinglyLinkedList x , SinglyLinkedList y){
        first=x;
        sec=y;
    }

    public SinglyLinkedList min(){
        return first;
    }
    public SinglyLinkedList dont (){
        return sec;
    }
    public String steps (){
        return c;
    }
    public String result (){
        return d;
    }

}
