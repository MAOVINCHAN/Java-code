package com.learn.demo;

public class LinuxShow implements IShowCmd{
    @Override
    public String show() {
        return "ls";
    }
}
