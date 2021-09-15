package repository;

import model.Post;

import java.util.List;

public interface IRepository {
    Post readPost(int postId);

    List<Post> readPosts();

    void writePost(Post post);

    void writePosts(List<Post> posts);
}
