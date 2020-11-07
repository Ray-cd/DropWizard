package org.example.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {

    private long id;

    private String content;

    public Saying(){
        //Jackson Serialization
    }

    public Saying(long id, String content){
        this.id = id;
        this.content = content;
    }

    // settersc are not there to make it immutableHe

//    @JsonProperty
//    public void setId(long _id){
//        id = _id;
//    }
//
//    @JsonProperty
//    public void setContent( String _content){
//        content = _content;
//    }

    @JsonProperty
    public String getContent(){
        return content;
    }

    @JsonProperty
    public long getId(){
        return id;
    }
}
