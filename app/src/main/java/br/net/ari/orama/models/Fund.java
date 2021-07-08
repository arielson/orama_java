package br.net.ari.orama.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Fund implements Parcelable {
    public String initial_date;
    public List<Object> performance_audios;
    public Fees fees;
    public boolean is_simple;
    public String description_seo;
    public Operability operability;
    public String full_name;
    public Object opening_date;
    public int id;
    public boolean is_closed;
    public String simple_name;
    public Object target_fund;
    public List<Document> documents;
    public Specification specification;
    public String quota_date;
    public String tax_classification;
    public String cnpj;
    public Description description;
    public List<Object> performance_videos;
    public boolean is_active;
    public Benchmark benchmark;
    public boolean orama_standard;
    public String slug;
    public FundSituation fund_situation;
    public String volatility_12m;
    public Object strategy_video;
    public Object insurance_company_code;
    public Profitabilities profitabilities;
    public String closed_to_capture_explanation;
    public Object closing_date;
    public boolean show_detailed_review;
    public String net_patrimony_12m;
    public boolean is_closed_to_capture;
    public FundManager fund_manager;
    public boolean esg_seal;

    protected Fund(Parcel in) {
        initial_date = in.readString();
        is_simple = in.readByte() != 0;
        description_seo = in.readString();
        full_name = in.readString();
        id = in.readInt();
        is_closed = in.readByte() != 0;
        simple_name = in.readString();
        quota_date = in.readString();
        tax_classification = in.readString();
        cnpj = in.readString();
        is_active = in.readByte() != 0;
        orama_standard = in.readByte() != 0;
        slug = in.readString();
        volatility_12m = in.readString();
        closed_to_capture_explanation = in.readString();
        show_detailed_review = in.readByte() != 0;
        net_patrimony_12m = in.readString();
        is_closed_to_capture = in.readByte() != 0;
        esg_seal = in.readByte() != 0;
        fund_manager = in.readParcelable(FundManager.class.getClassLoader());
        fees = in.readParcelable(Fees.class.getClassLoader());
        operability = in.readParcelable(Operability.class.getClassLoader());
        fund_situation = in.readParcelable(FundSituation.class.getClassLoader());
        profitabilities = in.readParcelable(Profitabilities.class.getClassLoader());
        benchmark = in.readParcelable(Benchmark.class.getClassLoader());
        specification = in.readParcelable(Specification.class.getClassLoader());
        description = in.readParcelable(Description.class.getClassLoader());
    }

    public static final Creator<Fund> CREATOR = new Creator<Fund>() {
        @Override
        public Fund createFromParcel(Parcel in) {
            return new Fund(in);
        }

        @Override
        public Fund[] newArray(int size) {
            return new Fund[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(initial_date);
        dest.writeByte((byte) (is_simple ? 1 : 0));
        dest.writeString(description_seo);
        dest.writeString(full_name);
        dest.writeInt(id);
        dest.writeByte((byte) (is_closed ? 1 : 0));
        dest.writeString(simple_name);
        dest.writeString(quota_date);
        dest.writeString(tax_classification);
        dest.writeString(cnpj);
        dest.writeByte((byte) (is_active ? 1 : 0));
        dest.writeByte((byte) (orama_standard ? 1 : 0));
        dest.writeString(slug);
        dest.writeString(volatility_12m);
        dest.writeString(closed_to_capture_explanation);
        dest.writeByte((byte) (show_detailed_review ? 1 : 0));
        dest.writeString(net_patrimony_12m);
        dest.writeByte((byte) (is_closed_to_capture ? 1 : 0));
        dest.writeByte((byte) (esg_seal ? 1 : 0));
        dest.writeParcelable(fund_manager, flags);
        dest.writeParcelable(fees, flags);
        dest.writeParcelable(operability, flags);
        dest.writeParcelable(fund_situation, flags);
        dest.writeParcelable(profitabilities, flags);
        dest.writeParcelable(benchmark, flags);
        dest.writeParcelable(specification, flags);
        dest.writeParcelable(description, flags);
    }
}
