package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Profitabilities implements Parcelable {
    public String m60;
    public String m48;
    public String m24;
    public String m36;
    public String month;
    public String m12;
    public String year;
    public String day;

    protected Profitabilities(Parcel in) {
        m60 = in.readString();
        m48 = in.readString();
        m24 = in.readString();
        m36 = in.readString();
        month = in.readString();
        m12 = in.readString();
        year = in.readString();
        day = in.readString();
    }

    public static final Creator<Profitabilities> CREATOR = new Creator<Profitabilities>() {
        @Override
        public Profitabilities createFromParcel(Parcel in) {
            return new Profitabilities(in);
        }

        @Override
        public Profitabilities[] newArray(int size) {
            return new Profitabilities[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(m60);
        dest.writeString(m48);
        dest.writeString(m24);
        dest.writeString(m36);
        dest.writeString(month);
        dest.writeString(m12);
        dest.writeString(year);
        dest.writeString(day);
    }
}
