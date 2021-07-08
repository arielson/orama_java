package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Description implements Parcelable {
    public String objective;
    public Object movie_url;
    public String target_audience;
    public String strengths;
    public String strategy;

    protected Description(Parcel in) {
        objective = in.readString();
        target_audience = in.readString();
        strengths = in.readString();
        strategy = in.readString();
    }

    public static final Creator<Description> CREATOR = new Creator<Description>() {
        @Override
        public Description createFromParcel(Parcel in) {
            return new Description(in);
        }

        @Override
        public Description[] newArray(int size) {
            return new Description[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(objective);
        dest.writeString(target_audience);
        dest.writeString(strengths);
        dest.writeString(strategy);
    }
}
