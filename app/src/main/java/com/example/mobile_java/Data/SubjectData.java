package com.example.mobile_java.Data;

public class SubjectData {
    public String SubjectName;
    public String Link;
    public String Image;
    public SubjectData(String subjectName, String link, String image) {
        this.SubjectName = subjectName;
        this.Link = link;
        this.Image = image;
    }
    public String getName()
    {
        return SubjectName;
    }
}