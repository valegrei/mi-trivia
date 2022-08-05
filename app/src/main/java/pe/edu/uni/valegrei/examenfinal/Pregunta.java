package pe.edu.uni.valegrei.examenfinal;

import android.os.Parcel;
import android.os.Parcelable;

public class Pregunta implements Parcelable {
    private int textId;
    private int imgId;
    private Boolean resp;

    public Pregunta(int textId, int imgId, Boolean resp) {
        this.textId = textId;
        this.imgId = imgId;
        this.resp = resp;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
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
        dest.writeInt(this.textId);
        dest.writeInt(this.imgId);
        dest.writeValue(this.resp);
    }

    public void readFromParcel(Parcel source) {
        this.textId = source.readInt();
        this.imgId = source.readInt();
        this.resp = (Boolean) source.readValue(Boolean.class.getClassLoader());
    }

    protected Pregunta(Parcel in) {
        this.textId = in.readInt();
        this.imgId = in.readInt();
        this.resp = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public static final Creator<Pregunta> CREATOR = new Creator<Pregunta>() {
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
