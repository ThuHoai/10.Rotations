package com.example.hoaiktt.a10rotations;

import java.io.Serializable;

/**
 * Created by hoaiktt on 7/25/2017.
 */

public class Messeage implements Serializable{
    private String mContent;

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public Messeage(String mContent) {

        this.mContent = mContent;
    }
}
