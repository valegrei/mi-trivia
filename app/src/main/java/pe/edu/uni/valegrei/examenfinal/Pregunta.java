package pe.edu.uni.valegrei.examenfinal;

import android.os.Parcel;
import android.os.Parcelable;

public class Pregunta implements Parcelable {
    private Integer textId;
    private Integer imgId;
    private Boolean resp;

    public Pregunta(Integer textId, Integer imgId, Boolean resp) {
        this.textId = textId;
        this.imgId = imgId;
        this.resp = resp;
    }

    public Integer getTextId() {
        return textId;
    }

    public void setTextId(Integer textId) {
        this.textId = textId;
    }

    public Integer getImgId() {
        return imgId;
    }

    public void setImgId(Integer imgId) {
        this.imgId = imgId;
    }

    public Boolean getResp() {
        return resp;
    }

    public void setResp(Boolean resp) {
        this.resp = resp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.textId);
        dest.writeValue(this.imgId);
        dest.writeValue(this.resp);
    }

    public void readFromParcel(Parcel source) {
        this.textId = (Integer) source.readValue(Integer.class.getClassLoader());
        this.imgId = (Integer) source.readValue(Integer.class.getClassLoader());
        this.resp = (Boolean) source.readValue(Boolean.class.getClassLoader());
    }

    protected Pregunta(Parcel in) {
        this.textId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.imgId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.resp = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Parcelable.Creator<Pregunta> CREATOR = new Parcelable.Creator<Pregunta>() {
        @Override
        public Pregunta createFromParcel(Parcel source) {
            return new Pregunta(source);
        }

        @Override
        public Pregunta[] newArray(int size) {
            return new Pregunta[size];
        }
    };
}
