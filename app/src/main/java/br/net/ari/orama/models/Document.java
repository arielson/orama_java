package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Document implements Parcelable {
    public int position;
    public String document_type;
    public String name;
    public String document_url;

    protected Document(Parcel in) {
        position = in.readInt();
        document_type = in.readString();
        name = in.readString();
        document_url = in.readString();
    }

    public static final Creator<Document> CREATOR = new Creator<Document>() {
        @Override
        public Document createFromParcel(Parcel in) {
            return new Document(in);
        }

        @Override
        public Document[] newArray(int size) {
            return new Document[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(position);
        dest.writeString(document_type);
        dest.writeString(name);
        dest.writeString(document_url);
    }
}
