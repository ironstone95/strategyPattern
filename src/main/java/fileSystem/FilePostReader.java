package fileSystem;

import com.google.gson.Gson;
import io.IPostReader;
import model.Post;

import java.io.*;
import java.util.*;

// Reads the json file and caches all posts to a hashmap.
public class FilePostReader implements IPostReader {
    private final String filePath;

    private final Map<Integer, Post> cachedPosts = new HashMap<>();

    public FilePostReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Post> readPosts() throws IOException {
        checkCache();
        return new ArrayList<>(cachedPosts.values());
    }

    @Override
    public Post readPost(int postID) throws IOException {
        checkCache();
        Post post = cachedPosts.get(postID);
        if (post == null) {
            throw new IOException("data not found");
        }
        return post;
    }

    private void checkCache() throws IOException {
        if (cachedPosts.isEmpty()) {
            cachePosts();
            if (cachedPosts.isEmpty()) {
                throw new IOException("cannot find any data in given path " + filePath);
            }
        }
    }

    private void cachePosts() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            Post[] posts = gson.fromJson(reader, Post[].class);
            if (posts != null)
            for (Post post : posts) {
                cachedPosts.put(post.id, post);
            }
        }
    }

}
