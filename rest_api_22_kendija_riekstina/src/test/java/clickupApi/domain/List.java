package clickupApi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class List {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
    @JsonProperty("task_count")
    private String task_count;

    public void setName(final String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setId(final String id){
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setTaskCount(final String task_count){
        this.task_count = name;
    }
    public String getTaskCount(){
        return task_count;
    }
}
