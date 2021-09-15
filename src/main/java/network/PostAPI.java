package network;

import model.Post;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

// Standard retrofit interface for API calls
public interface PostAPI {
    @GET("/posts")
    Call<List<Post>> getPosts();

    @GET("/posts/{postID}")
    Call<Post> getPost(@Path("postID") int postID);

    @POST("/posts")
    Call<Post> sendPost(@Body Post post);
}
