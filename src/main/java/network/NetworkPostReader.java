package network;

import io.IPostReader;
import model.Post;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

// The class makes 'synchronous' calls to given postAPI.
public class NetworkPostReader implements IPostReader {
    private final PostAPI postAPI;

    public NetworkPostReader(PostAPI postAPI) {
        this.postAPI = postAPI;
    }

    @Override
    public List<Post> readPosts() throws IOException {
        Call<List<Post>> call = postAPI.getPosts();
        Response<List<Post>> response = call.execute();
        if (response.isSuccessful()) return response.body();
        else return null;
    }

    @Override
    public Post readPost(int postID) throws IOException {
        Call<Post> call = postAPI.getPost(postID);
        Response<Post> response = call.execute();
        if (response.isSuccessful()) return response.body();
        else return null;
    }
}
