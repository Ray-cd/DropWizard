package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;


public class HelloWorldConfiguration extends Configuration {

    @NotNull
    private String template;

    @NotNull
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate(){
        return template;
    }

    @JsonProperty
    public void setTemplate(String template){
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName(){
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name){
        this.defaultName =name;
    }

}

