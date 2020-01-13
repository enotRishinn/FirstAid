package com.practice.firstaid.data.aid_data;

public class Problem {
    public Integer blocks;
    public String name;
    public String decription;
    public String descriptionImgUrl;
    public String symptoms;
    public String firstBlock;
    public String firstImgUrl;
    public String secondBlock;
    public String secondImgUrl;
    public String thirdBlock;
    public String thirdImgUrl;
    public String fourthBlock;

    public Problem(Integer blocks, String name, String decription, String descriptionImgUrl, String symptoms, String firstBlock, String firstImgUrl, String secondBlock, String secondImgUrl, String thirdBlock, String thirdImgUrl, String fourthBlock) {
        this.blocks = blocks;
        this.name = name;
        this.decription = decription;
        this.descriptionImgUrl = descriptionImgUrl;
        this.symptoms = symptoms;
        this.firstBlock = firstBlock;
        this.firstImgUrl = firstImgUrl;
        this.secondBlock = secondBlock;
        this.secondImgUrl = secondImgUrl;
        this.thirdBlock = thirdBlock;
        this.thirdImgUrl = thirdImgUrl;
        this.fourthBlock = fourthBlock;
    }
}
