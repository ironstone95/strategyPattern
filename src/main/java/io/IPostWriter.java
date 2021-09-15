package io;

import model.Post;

import java.io.IOException;
import java.util.List;

public interface IPostWriter {
    List<Post> writePosts(List<Post> posts) throws IOException;

    Post writePost(Post post) throws IOException;
}
