package jo.sangmyung.kr.put_on_this_dress.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

    @GET("shops/load_all")
    Call<List<ShopResource>> getShops();
}
