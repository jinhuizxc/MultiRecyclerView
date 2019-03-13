package com.jh.multirecyclerview;

public class Person {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    public int type;
    public int avaterColor;
    public int contentColor;
    public String name;
    public String content;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getAvaterColor() {
        return avaterColor;
    }

    public void setAvaterColor(int avaterColor) {
        this.avaterColor = avaterColor;
    }

    public int getContentColor() {
        return contentColor;
    }

    public void setContentColor(int contentColor) {
        this.contentColor = contentColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Person{" +
                "type=" + type +
                ", avaterColor=" + avaterColor +
                ", contentColor=" + contentColor +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
