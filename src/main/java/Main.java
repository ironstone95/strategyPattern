import fileSystem.FilePostReader;
import fileSystem.FilePostWriter;
import handler.LogExceptionHandler;
import model.Post;
import network.NetworkPostReader;
import network.NetworkPostWriter;
import network.WebService;
import repository.IRepository;
import repository.RepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IRepository repository = new RepositoryImpl(
                new NetworkPostWriter(WebService.getInstance().getPostAPI()),
                new FilePostReader("unitTest.json"),
                new LogExceptionHandler());

        List<Post> posts = repository.readPosts();
        if (posts != null) {
            for (Post post : posts) {
                System.out.println(post);
            }
            repository.writePost(posts.get(0));
        }
    }
}

