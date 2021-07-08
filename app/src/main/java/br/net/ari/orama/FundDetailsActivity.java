package br.net.ari.orama;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

import br.net.ari.orama.core.Constants;
import br.net.ari.orama.models.Fund;

public class FundDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_details);

        Bundle b = this.getIntent().getExtras();
        Fund fund = null;
        if (b != null)
            fund = b.getParcelable(Constants.Fund);
        if (fund != null) {
            ActionBar actionBar = getSupportActionBar();
            Objects.requireNonNull(actionBar).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(actionBar).setSubtitle(fund.simple_name);

            TextView textViewFullName = findViewById(R.id.textViewFullName);
            textViewFullName.setText(fund.full_name);

            TextView textViewManager = findViewById(R.id.textViewManager);
            textViewManager.setText(fund.fund_manager.description);

            TextView textViewObjective = findViewById(R.id.textViewObjective);
            textViewObjective.setText(fund.description.objective);

            TextView textViewStrategy = findViewById(R.id.textViewStrategy);
            textViewStrategy.setText(fund.description.strategy);
        } else
            finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}