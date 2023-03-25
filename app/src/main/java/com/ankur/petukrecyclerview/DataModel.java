package com.ankur.petukrecyclerview;

import java.util.List;

public class DataModel {
    private List<String> nestedList;
    private String itemText;
    private boolean isExpandable;
    int img;


    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public DataModel(List<String> itemList, String itemText, int img) {
        this.nestedList = itemList;
        this.itemText = itemText;
        isExpandable = false;
        this.img=img;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public List<String> getNestedList() {
        return nestedList;
    }

    public String getItemText() {
        return itemText;
    }

    public boolean isExpandable() {
        return isExpandable;
    }
}
