package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FundSituation implements Parcelable {
    public String code;
    public String name;

    protected FundSituation(Parcel in) {
        code = in.readString();
        name = in.readString();
    }

    public static final Creator<FundSituation> CREATOR = new Creator<FundSituation>() {
        @Override
        public FundSituation createFromParcel(Parcel in) {
            return new FundSituation(in);
        }

        @Override
        public FundSituation[] newArray(int size) {
            return new FundSituation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(code);
        dest.writeString(name);
    }
}
