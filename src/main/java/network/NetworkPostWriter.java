package network;

import io.IPostWriter;
import model.Post;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NetworkPostWriter implements IPostWriter {
    private final PostAPI api;

    public NetworkPostWriter(PostAPI api) {
        this.api = api;
    }

    @Override
    public List<Post> writePosts(List<Post> posts) throws IOException {
        List<Post> respPosts = new ArrayList<>();
        for (Post post : posts) {
            respPosts.add(writePost(post));
        }
        return respPosts;
    }

    @Override
    public Post writePost(Post post) throws IOException {
        Call<Post> call = api.sendPost(post);
        Response<Post> response = call.execute();
        if (response.isSuccessful()) {
            return response.body();
        }
        return null;
    }
}
