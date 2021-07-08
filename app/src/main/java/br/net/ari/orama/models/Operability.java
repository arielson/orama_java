package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Operability implements Parcelable {
    public boolean has_operations_on_thursdays;
    public String retrieval_liquidation_days_type;
    public String application_quotation_days_type;
    public int retrieval_quotation_days;
    public String anticipated_retrieval_quotation_days_type;
    public String anticipated_retrieval_quotation_days_str;
    public String retrieval_quotation_days_type;
    public int anticipated_retrieval_quotation_days;
    public boolean has_operations_on_wednesdays;
    public String minimum_balance_permanence;
    public boolean has_operations_on_mondays;
    public boolean has_grace_period;
    public String application_time_limit;
    public String retrieval_time_limit;
    public boolean has_operations_on_fridays;
    public int anticipate_retrieval_liquidation_days;
    public String minimum_initial_application_amount;
    public String anticipate_retrieval_liquidation_days_type;
    public String retrieval_special_type;
    public String anticipate_retrieval_liquidation_days_str;
    public String application_quotation_days_str;
    public Object grace_period_in_days_str;
    public String retrieval_quotation_days_str;
    public int grace_period_in_days;
    public String retrieval_liquidation_days_str;
    public String minimum_subsequent_retrieval_amount;
    public boolean retrieval_direct;
    public int retrieval_liquidation_days;
    public int application_quotation_days;
    public String max_balance_permanence;
    public String maximum_initial_application_amount;
    public boolean has_operations_on_tuesdays;
    public String minimum_subsequent_application_amount;

    protected Operability(Parcel in) {
        has_operations_on_thursdays = in.readByte() != 0;
        retrieval_liquidation_days_type = in.readString();
        application_quotation_days_type = in.readString();
        retrieval_quotation_days = in.readInt();
        anticipated_retrieval_quotation_days_type = in.readString();
        anticipated_retrieval_quotation_days_str = in.readString();
        retrieval_quotation_days_type = in.readString();
        anticipated_retrieval_quotation_days = in.readInt();
        has_operations_on_wednesdays = in.readByte() != 0;
        minimum_balance_permanence = in.readString();
        has_operations_on_mondays = in.readByte() != 0;
        has_grace_period = in.readByte() != 0;
        application_time_limit = in.readString();
        retrieval_time_limit = in.readString();
        has_operations_on_fridays = in.readByte() != 0;
        anticipate_retrieval_liquidation_days = in.readInt();
        minimum_initial_application_amount = in.readString();
        anticipate_retrieval_liquidation_days_type = in.readString();
        retrieval_special_type = in.readString();
        anticipate_retrieval_liquidation_days_str = in.readString();
        application_quotation_days_str = in.readString();
        retrieval_quotation_days_str = in.readString();
        grace_period_in_days = in.readInt();
        retrieval_liquidation_days_str = in.readString();
        minimum_subsequent_retrieval_amount = in.readString();
        retrieval_direct = in.readByte() != 0;
        retrieval_liquidation_days = in.readInt();
        application_quotation_days = in.readInt();
        max_balance_permanence = in.readString();
        maximum_initial_application_amount = in.readString();
        has_operations_on_tuesdays = in.readByte() != 0;
        minimum_subsequent_application_amount = in.readString();
    }

    public static final Creator<Operability> CREATOR = new Creator<Operability>() {
        @Override
        public Operability createFromParcel(Parcel in) {
            return new Operability(in);
        }

        @Override
        public Operability[] newArray(int size) {
            return new Operability[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (has_operations_on_thursdays ? 1 : 0));
        dest.writeString(retrieval_liquidation_days_type);
        dest.writeString(application_quotation_days_type);
        dest.writeInt(retrieval_quotation_days);
        dest.writeString(anticipated_retrieval_quotation_days_type);
        dest.writeString(anticipated_retrieval_quotation_days_str);
        dest.writeString(retrieval_quotation_days_type);
        dest.writeInt(anticipated_retrieval_quotation_days);
        dest.writeByte((byte) (has_operations_on_wednesdays ? 1 : 0));
        dest.writeString(minimum_balance_permanence);
        dest.writeByte((byte) (has_operations_on_mondays ? 1 : 0));
        dest.writeByte((byte) (has_grace_period ? 1 : 0));
        dest.writeString(application_time_limit);
        dest.writeString(retrieval_time_limit);
        dest.writeByte((byte) (has_operations_on_fridays ? 1 : 0));
        dest.writeInt(anticipate_retrieval_liquidation_days);
        dest.writeString(minimum_initial_application_amount);
        dest.writeString(anticipate_retrieval_liquidation_days_type);
        dest.writeString(retrieval_special_type);
        dest.writeString(anticipate_retrieval_liquidation_days_str);
        dest.writeString(application_quotation_days_str);
        dest.writeString(retrieval_quotation_days_str);
        dest.writeInt(grace_period_in_days);
        dest.writeString(retrieval_liquidation_days_str);
        dest.writeString(minimum_subsequent_retrieval_amount);
        dest.writeByte((byte) (retrieval_direct ? 1 : 0));
        dest.writeInt(retrieval_liquidation_days);
        dest.writeInt(application_quotation_days);
        dest.writeString(max_balance_permanence);
        dest.writeString(maximum_initial_application_amount);
        dest.writeByte((byte) (has_operations_on_tuesdays ? 1 : 0));
        dest.writeString(minimum_subsequent_application_amount);
    }
}
