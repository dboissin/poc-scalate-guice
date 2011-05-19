package poc.scalatra.dto;

import java.io.Serializable;


public class SimpleDTO implements Serializable {

    public SimpleDTO() {

    }

    public SimpleDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;


}
