package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Benchmark implements Parcelable {
    public int id;
    public String name;

    protected Benchmark(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Benchmark> CREATOR = new Creator<Benchmark>() {
        @Override
        public Benchmark createFromParcel(Parcel in) {
            return new Benchmark(in);
        }

        @Override
        public Benchmark[] newArray(int size) {
            return new Benchmark[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
    }
}
