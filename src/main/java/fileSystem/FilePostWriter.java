package fileSystem;

import com.google.gson.Gson;
import io.IPostWriter;
import model.Post;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilePostWriter implements IPostWriter {
    private String path;

    public FilePostWriter(String path) {
        this.path = path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public List<Post> writePosts(List<Post> posts) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(gson.toJson(posts));
        }
        return posts;
    }

    /**
     * This method clears the given file and writes given post to the file.
     *
     * @param post is the object that will be written to the file.
     * @return passed parameter without changing
     * @throws IOException if an error occurs in file system.
     */
    @Override
    public Post writePost(Post post) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write(gson.toJson(new Post[]{post}));
        }
        return post;
    }
}
