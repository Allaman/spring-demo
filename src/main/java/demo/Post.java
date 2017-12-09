package demo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(includeFieldNames = false)
public class Post {

    private final long id;
    private final String content;

    public Post(long id, String content) {
        this.id = id;
        this.content = content;
    }
}