package jo.sangmyung.kr.put_on_this_dress;

public class APIUtils {

    public static APIInterface getAPIService() {
        return APIClient.getClient().create(APIInterface.class);
    }
}
