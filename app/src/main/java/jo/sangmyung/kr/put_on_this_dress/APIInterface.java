package jo.sangmyung.kr.put_on_this_dress;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface APIInterface {

    @GET("shops/load_all")
    Call<List<ShopResource>> getShops();
}
