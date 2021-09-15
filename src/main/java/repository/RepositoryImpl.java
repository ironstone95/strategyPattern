package repository;

import handler.IExceptionHandler;
import io.IPostReader;
import io.IPostWriter;
import model.Post;

import java.io.IOException;
import java.util.List;

public class RepositoryImpl implements IRepository {
    private final IPostWriter writer;
    private final IPostReader reader;
    private final IExceptionHandler errorHandler;

    public RepositoryImpl(IPostWriter writer, IPostReader reader, IExceptionHandler errorHandler) {
        this.writer = writer;
        this.reader = reader;
        this.errorHandler = errorHandler;
    }

    public Post readPost(int postId) {
        try {
            return reader.readPost(postId);
        } catch (IOException ioe) {
            errorHandler.handle(ioe);
        }
        return null;
    }

    public List<Post> readPosts() {
        try {
            return reader.readPosts();
        } catch (IOException ioe) {
            errorHandler.handle(ioe);
        }
        return null;
    }

    public void writePost(Post post) {
        try {
            writer.writePost(post);
        } catch (IOException ioe) {
            errorHandler.handle(ioe);
        }
    }

    public void writePosts(List<Post> posts) {
        try {
            writer.writePosts(posts);
        } catch (IOException ioe) {
            errorHandler.handle(ioe);
        }
    }
}
