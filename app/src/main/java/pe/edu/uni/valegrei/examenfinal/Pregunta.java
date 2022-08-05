package pe.edu.uni.valegrei.examenfinal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Clase que contiene los recursos de las preguntas
 * Se implementa Parcelable para guardar en Bundle
 */
public class Pregunta implements Parcelable {
    private int textId;
    private int imgId;
    private boolean resp;

    public Pregunta(int textId, int imgId, boolean resp) {
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

    public boolean getResp() {
        return resp;
    }

    public void setResp(boolean resp) {
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
        dest.writeByte(this.resp ? (byte) 1 : (byte) 0);
    }

    public void readFromParcel(Parcel source) {
        this.textId = source.readInt();
        this.imgId = source.readInt();
        this.resp = source.readByte() != 0;
    }

    protected Pregunta(Parcel in) {
        this.textId = in.readInt();
        this.imgId = in.readInt();
        this.resp = in.readByte() != 0;
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
