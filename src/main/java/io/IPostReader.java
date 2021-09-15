package io;

import model.Post;

import java.io.IOException;
import java.util.List;

public interface IPostReader {
    List<Post> readPosts() throws IOException;

    Post readPost(int postID) throws IOException;
}
