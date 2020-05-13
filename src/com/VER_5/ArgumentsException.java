package com.VER_5;

public class ArgumentsException extends Exception {

    private String text;

    public ArgumentsException(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
