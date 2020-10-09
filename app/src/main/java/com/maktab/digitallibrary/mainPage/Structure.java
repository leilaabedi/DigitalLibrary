package com.maktab.digitallibrary.mainPage;

public class Structure {
    public String title;
    public String content;
    public String more;
    public String imgAddress;
    public int id;

    public Structure(String title, String content, String more, String imgAddress, int id) {
        this.title = title;
        this.content = content;
        this.more = more;
        this.imgAddress = imgAddress;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
