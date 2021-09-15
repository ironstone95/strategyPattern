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
                new FilePostWriter("networkPosts.json"),
                new NetworkPostReader(WebService.getInstance().getPostAPI()),
                new LogExceptionHandler());

        List<Post> posts = repository.readPosts();
        if (posts != null) {
            for (Post post : posts) {
                System.out.println(post);
            }
            repository.writePosts(posts);
        }
    }
}

