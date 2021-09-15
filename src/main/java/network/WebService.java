package network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// A singleton class that provides PostAPI across the application
public class WebService {
    private static WebService INSTANCE = null;
    private final PostAPI postAPI;

    private WebService(Retrofit retrofit) {
        postAPI = retrofit.create(PostAPI.class);
    }

    public PostAPI getPostAPI() {
        return this.postAPI;
    }

    public static WebService getInstance() {
        synchronized (WebService.class) {
            if (INSTANCE == null) {
                synchronized (WebService.class) {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").
                            addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient())
                            .build();
                    INSTANCE = new WebService(retrofit);
                }
            }
        }
        return INSTANCE;
    }
}
