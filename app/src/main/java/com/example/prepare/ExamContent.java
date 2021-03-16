package com.example.prepare;

public class ExamContent {

    private String title,subTitle;
    private boolean expanded;

    public ExamContent(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
        this.expanded = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
