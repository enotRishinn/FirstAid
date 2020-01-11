package com.practice.firstaid.data.aid_data;

public class Problem {
    public Integer id;
    public String name;
    public String firstBlock;
    public String firstImgUrl;
    public String secondBlock;
    public String secondImgUrl;
    public String thirdBlock;
    public String thirdImgUrl;
    public String fourthBlock;

    public Problem(Integer id, String name, String firstBlock, String firstImgUrl, String secondBlock, String secondImgUrl, String thirdBlock, String thirdImgUrl, String fourthBlock) {
        this.id = id;
        this.name = name;
        this.firstBlock = firstBlock;
        this.firstImgUrl = firstImgUrl;
        this.secondBlock = secondBlock;
        this.secondImgUrl = secondImgUrl;
        this.thirdBlock = thirdBlock;
        this.thirdImgUrl = thirdImgUrl;
        this.fourthBlock = fourthBlock;
    }
}
