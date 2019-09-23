package com.xfcc.entity;

//创业动态实体
public class Information {
    private Integer id;
    private String title;
    private String time;
    private String context;
    private String img;
    public Information() {
        super();
    }
    public Information(Integer id,String title,String time,String context,String img) {
        super();
        this.id = id;
        this.title = title;
        this.time = time;
        this.context = context;
        this.img = img;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContext() {
        return this.context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
