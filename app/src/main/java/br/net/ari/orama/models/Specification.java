package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Specification implements Parcelable {
    public String fund_main_strategy_name;
    public FundSuitabilityProfile fund_suitability_profile;
    public FundRiskProfile fund_risk_profile;
    public String fund_main_strategy_explanation;
    public String fund_type;
    public String fund_class;
    public FundMacroStrategy fund_macro_strategy;
    public String fund_class_anbima;
    public FundMainStrategy fund_main_strategy;
    public boolean is_qualified;

    protected Specification(Parcel in) {
        fund_main_strategy_name = in.readString();
        fund_main_strategy_explanation = in.readString();
        fund_type = in.readString();
        fund_class = in.readString();
        fund_class_anbima = in.readString();
        is_qualified = in.readByte() != 0;
    }

    public static final Creator<Specification> CREATOR = new Creator<Specification>() {
        @Override
        public Specification createFromParcel(Parcel in) {
            return new Specification(in);
        }

        @Override
        public Specification[] newArray(int size) {
            return new Specification[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fund_main_strategy_name);
        dest.writeString(fund_main_strategy_explanation);
        dest.writeString(fund_type);
        dest.writeString(fund_class);
        dest.writeString(fund_class_anbima);
        dest.writeByte((byte) (is_qualified ? 1 : 0));
    }
}
