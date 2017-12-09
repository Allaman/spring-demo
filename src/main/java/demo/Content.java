package demo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = false)
public class Content {

    private final long id;
    private final String content;

    public Content(long id, String content) {
        this.id = id;
        this.content = content;
    }
}