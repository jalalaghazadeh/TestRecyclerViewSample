package com.mrjalal.testrecyclerviewsample;

/**
 * Created by user on 1/24/2018.
 */

public class SimpleModel {
    private int id = 0;
    private String text;
    private int itemColor;

    private SimpleModel(SimpleModelBuilder builder) {
        this.id = builder.id;
        this.text = builder.text;
        this.itemColor = builder.itemColor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getItemColor() {
        return itemColor;
    }

    public void setItemColor(int itemColor) {
        this.itemColor = itemColor;
    }

    public static class SimpleModelBuilder{
        private int id = 0;
        private String text;
        private int itemColor;

        public SimpleModelBuilder() {

        }

        public SimpleModelBuilder id(int id){
            this.id = id;
            return this;
        }

        public SimpleModelBuilder text(String text){
            this.text = text;
            return this;
        }

        public SimpleModelBuilder itemColor(int itemColor){
            this.itemColor = itemColor;
            return this;
        }

        public SimpleModel build(){
            return new SimpleModel(this);
        }

    }
}
