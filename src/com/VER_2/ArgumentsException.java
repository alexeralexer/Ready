package com.VER_2;

import java.io.IOException;

class ArgumentsException extends IOException {

    public ArgumentsException (){
    }

    public ArgumentsException (String mess){
        System.out.println(mess);
    }



    public String checkAndGetDirectory(String a){
        return a;
    }




}
