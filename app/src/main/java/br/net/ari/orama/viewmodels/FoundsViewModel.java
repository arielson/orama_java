package br.net.ari.orama.viewmodels;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import br.net.ari.orama.core.Utilities;
import br.net.ari.orama.models.Fund;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoundsViewModel extends ViewModel {

    private MutableLiveData<String> message;
    public MutableLiveData<String> getMessage() {
        if(message == null)
            message = new MutableLiveData<>();

        return message;
    }

    public void clearMessage() {
        if(message == null)
            message = new MutableLiveData<>();

        message.postValue("");
    }

    private MutableLiveData<List<Fund>> funds;
    public LiveData<List<Fund>> getFunds() {
        if (funds == null) {
            funds = new MutableLiveData<>();
            loadFunds();
        }
        return funds;
    }

    public void loadFunds() {
        Utilities.Service().GetFundos("fund_detail_full").enqueue(new Callback<List<Fund>>() {
            @Override
            public void onResponse(@NonNull Call<List<Fund>> call, @NonNull Response<List<Fund>> response) {
                if (response.isSuccessful()) {
                    List<Fund> items = response.body();
                    assert items != null;
                    items = items.stream().filter(fund -> fund.is_active).collect(Collectors.toList());
                    funds.postValue(items);
                } else {
                    try {
                        assert response.errorBody() != null;
                        message.postValue("Ocorreu um erro na requisição. Tente novamente mais tarde.");
                        Log.d("Founds", response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Fund>> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void clearFunds() {
        if (funds != null)
            funds = new MutableLiveData<>();
        loadFunds();
    }
}