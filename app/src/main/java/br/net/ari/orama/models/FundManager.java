package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class FundManager implements Parcelable {
    public String description;
    public int id;
    public String full_name;
    public String logo;
    public String slug;
    public String name;

    protected FundManager(Parcel in) {
        description = in.readString();
        id = in.readInt();
        full_name = in.readString();
        logo = in.readString();
        slug = in.readString();
        name = in.readString();
    }

    public static final Creator<FundManager> CREATOR = new Creator<FundManager>() {
        @Override
        public FundManager createFromParcel(Parcel in) {
            return new FundManager(in);
        }

        @Override
        public FundManager[] newArray(int size) {
            return new FundManager[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeInt(id);
        dest.writeString(full_name);
        dest.writeString(logo);
        dest.writeString(slug);
        dest.writeString(name);
    }
}
