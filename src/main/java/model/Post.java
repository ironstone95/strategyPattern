package model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.TestOnly;

import java.util.Objects;

public class Post {
    public int userId;
    public int id;
    public String title;
    @SerializedName("body")
    public String content;

    public Post(int userId, int id, String title, String content) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return userId == post.userId && id == post.id && Objects.equals(title, post.title) && Objects.equals(content, post.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, title, content);
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
