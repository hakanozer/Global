package restRead;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Services {
	
	@GET("product.php?ref=5380f5dbcc3b1021f93ab24c3a1aac24&start=0")
	Call<JsonProduct> allProduct();

}
