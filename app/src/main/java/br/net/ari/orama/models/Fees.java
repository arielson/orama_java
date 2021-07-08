package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Fees implements Parcelable {
    public String maximum_administration_fee;
    public String anticipated_retrieval_fee_value;
    public String administration_fee;
    public String anticipated_retrieval_fee;
    public String performance_fee;
    public boolean has_anticipated_retrieval;

    protected Fees(Parcel in) {
        maximum_administration_fee = in.readString();
        anticipated_retrieval_fee_value = in.readString();
        administration_fee = in.readString();
        anticipated_retrieval_fee = in.readString();
        performance_fee = in.readString();
        has_anticipated_retrieval = in.readByte() != 0;
    }

    public static final Creator<Fees> CREATOR = new Creator<Fees>() {
        @Override
        public Fees createFromParcel(Parcel in) {
            return new Fees(in);
        }

        @Override
        public Fees[] newArray(int size) {
            return new Fees[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(maximum_administration_fee);
        dest.writeString(anticipated_retrieval_fee_value);
        dest.writeString(administration_fee);
        dest.writeString(anticipated_retrieval_fee);
        dest.writeString(performance_fee);
        dest.writeByte((byte) (has_anticipated_retrieval ? 1 : 0));
    }
}
