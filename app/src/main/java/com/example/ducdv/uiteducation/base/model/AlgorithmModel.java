package com.example.ducdv.uiteducation.base.model;

/**
 * Created by DucDV on 01/29/2018.
 */

public class AlgorithmModel {

    private String codeDemo;
    private String description;
    private String youtubeVideoId;

    public AlgorithmModel(String codeDemo, String description, String youtubeVideoId) {
        this.codeDemo = codeDemo;
        this.description = description;
        this.youtubeVideoId = youtubeVideoId;
    }

    public AlgorithmModel(){

    }

    public String getCodeDemo() {
        return codeDemo;
    }

    public void setCodeDemo(String codeDemo) {
        this.codeDemo = codeDemo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }
}
