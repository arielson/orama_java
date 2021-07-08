package br.net.ari.orama.interfaces;

import java.util.List;

import br.net.ari.orama.models.Fund;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("json/fund_detail_full.json")
    Call<List<Fund>> GetFundos(@Query("serializ er") String tipo);
}
