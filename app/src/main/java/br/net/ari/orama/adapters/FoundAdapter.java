package br.net.ari.orama.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

import br.net.ari.orama.R;
import br.net.ari.orama.core.Utilities;
import br.net.ari.orama.models.Fund;

public class FoundAdapter extends BaseAdapter {
    private static List<Fund> mLista;
    private final LayoutInflater mInflater;

    public FoundAdapter(FragmentActivity fragment, List<Fund> results) {
        mLista = results;
        mInflater = LayoutInflater.from(fragment);
    }

    @Override
    public int getCount() {
        return mLista.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mLista.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        final Fund item = mLista.get(position);
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.cardview_found, parent, false);
            holder.textViewSimpleName = convertView.findViewById(R.id.textViewSimpleName);
            holder.linearLayoutColor = convertView.findViewById(R.id.linearLayoutColor);
            holder.imageViewLogo = convertView.findViewById(R.id.imageViewLogo);
            holder.textViewAdministrationFee = convertView.findViewById(R.id.textViewAdministrationFee);
            holder.textViewMinimumInitialApplicationAmount = convertView.findViewById(R.id.textViewMinimumInitialApplicationAmount);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.textViewSimpleName.setText(item.simple_name);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.linearLayoutColor.setBackgroundColor(color);
        Picasso.get().load(Utilities.ServiceUrl + item.fund_manager.logo).placeholder(R.mipmap.ic_launcher).into(holder.imageViewLogo);
        holder.textViewAdministrationFee.setText(String.format("%s %% (12M)",item.fees.administration_fee));
        holder.textViewMinimumInitialApplicationAmount.setText(String.format("R$ %s", item.operability.minimum_initial_application_amount));

        return convertView;
    }

    private static class ViewHolder {
        TextView textViewSimpleName;
        LinearLayout linearLayoutColor;
        ImageView imageViewLogo;
        TextView textViewAdministrationFee;
        TextView textViewMinimumInitialApplicationAmount;
    }
}
