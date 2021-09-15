import model.Post;
import network.NetworkPostReader;
import network.NetworkPostWriter;
import network.WebService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkTest {
    @Test
    void testPostApiGetSingle() {
        NetworkPostReader npr = new NetworkPostReader(WebService.getInstance().getPostAPI());
        try {
            Post post = npr.readPost(1);
            assertEquals(1, post.id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPostApiGetAll() {
        NetworkPostReader npr = new NetworkPostReader(WebService.getInstance().getPostAPI());
        try {
            List<Post> posts = npr.readPosts();
            assertEquals(100, posts.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPostApiPostSingle() {
        Post post = new Post(101, 101, "testPost", "testPost");
        NetworkPostWriter npw = new NetworkPostWriter(WebService.getInstance().getPostAPI());
        try {
            Post writePost = npw.writePost(post);
            assertEquals(post, writePost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testPostApiPostList() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(101, 101, "testPost", "testPost"));
        posts.add(new Post(101, 102, "testPost", "testPost"));
        NetworkPostWriter npw = new NetworkPostWriter(WebService.getInstance().getPostAPI());
        try {
            List<Post> writePosts = npw.writePosts(posts);
            assertEquals(posts.size(), writePosts.size());
            assertEquals(posts.get(0), writePosts.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
