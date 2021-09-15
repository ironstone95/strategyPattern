import fileSystem.FilePostReader;
import fileSystem.FilePostWriter;
import model.Post;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemTest {
    private static final String postsJson = "[{\"userId\":999,\"id\":999,\"title\":\"test post title with id 999\",\"body\":\"test post title with id 999\"},{\"userId\":1000,\"id\":1000,\"title\":\"test post title with id 1000\",\"body\":\"test post title with id 1000\"}]";
    private static final String postJson = "[{\"userId\":999,\"id\":999,\"title\":\"test post title with id 999\",\"body\":\"test post title with id 999\"}]";
    private static final List<Post> testPosts = new ArrayList<>();

    @BeforeAll
    static void setObjects() {
        testPosts.add(new Post(999, 999, "test post title with id 999", "test post title with id 999"));
        testPosts.add(new Post(1000, 1000, "test post title with id 1000", "test post title with id 1000"));
    }

    @Test
    void testFileSystemWritePost() {
        String path = "testFileSystemWritePost.json";
        FilePostWriter fpw = new FilePostWriter(path);
        try {
            Post post = fpw.writePost(testPosts.get(0));
            assertEquals(post.id, 999);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clearFile(path);
        }
    }

    @Test
    void testFileSystemWritePosts() {
        String path = "testFileSystemWritePosts.json";
        FilePostWriter fpw = new FilePostWriter(path);
        try {
            List<Post> resPosts = fpw.writePosts(testPosts);
            assertEquals(resPosts.get(0).id, testPosts.get(0).id);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            clearFile(path);
        }
    }


    @Test
    void testFileSystemReadPost() {
        String path = "testFileSystemReadPost.json";
        FilePostReader fpr = new FilePostReader(path);
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(postJson);
            Post post = fpr.readPost(999);
            assertEquals(999, post.id);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clearFile(path);
        }
    }

    @Test
    void testFileSystemReadPosts() {
        String path = "testFileSystemReadPosts.json";
        FilePostReader fpr = new FilePostReader(path);
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(postsJson);
            List<Post> resPosts = fpr.readPosts();
            assertEquals(2, resPosts.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            clearFile(path);
        }

    }

    void clearFile(String path) {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            boolean deleteResult = file.delete();
            assertTrue(deleteResult);
        }
    }
}
