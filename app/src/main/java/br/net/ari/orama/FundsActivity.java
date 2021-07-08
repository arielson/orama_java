package br.net.ari.orama;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import br.net.ari.orama.adapters.FoundAdapter;
import br.net.ari.orama.core.Constants;
import br.net.ari.orama.core.Utilities;
import br.net.ari.orama.models.Fund;
import br.net.ari.orama.viewmodels.FoundsViewModel;

public class FundsActivity extends AppCompatActivity {

    FoundsViewModel foundsViewModel;
    ListView listViewFounds;
    SwipeRefreshLayout swipeRefreshFunds;
    RelativeLayout relativeLayoutLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funds);

        listViewFounds = findViewById(R.id.listViewFunds);
        swipeRefreshFunds = findViewById(R.id.swipeRefreshFunds);
        relativeLayoutLoading = findViewById(R.id.relativeLayoutLoading);
        swipeRefreshFunds.setOnRefreshListener(this::reloadFunds);

        foundsViewModel = new ViewModelProvider(this).get(FoundsViewModel.class);

        foundsViewModel.getMessage().observe(this, message -> {
            if (message.length() > 0) {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                foundsViewModel.clearMessage();
            }
            relativeLayoutLoading.setVisibility(View.GONE);
        });

        loadFunds();
    }

    void loadFunds() {
        if (Utilities.IsNetworkAvailable(this)) {
            foundsViewModel.getFunds().observe(this, funds -> {
                listViewFounds.setAdapter(new FoundAdapter(this, funds));
                relativeLayoutLoading.setVisibility(View.GONE);
                listViewFounds.setOnItemClickListener((parent, view, position, id) -> {
                    Fund item = funds.get(position);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable(Constants.Fund, item);
                    intent.putExtras(bundle);
                    intent.setClass(view.getContext(), FundDetailsActivity.class);
                    startActivity(intent);
                });
                swipeRefreshFunds.setRefreshing(false);
            });
        }
    }

    void reloadFunds() {
        foundsViewModel.clearFunds();
        loadFunds();
    }
}