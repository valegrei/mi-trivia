package pe.edu.uni.valegrei.examenfinal;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que controlara la logica de la aplicacion
 * Se implementa Parcelable para guardar el estado en un Bundle
 */
public class Trivia implements Parcelable {

    private List<Pregunta> preguntas;
    private int posicion;

    public Trivia(List<Pregunta> preguntas, int posicion) {
        this.preguntas = preguntas;
        this.posicion = posicion;
    }

    public Pregunta getPreguntaActual() {
        return preguntas.get(posicion);
    }

    //Devuelve true si es correcto
    public boolean comprobarRespuesta(boolean resp) {
        return resp == getPreguntaActual().getResp();
    }

    public void siguiente() {
        posicion++;
        if (posicion >= preguntas.size())
            posicion = 0;
    }

    public void anterior() {
        posicion--;
        if (posicion < 0)
            posicion = 0;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public static Trivia nuevaTrivia() {
        List<Pregunta> preguntas = new ArrayList<>();
        preguntas.add(new Pregunta(R.string.preg1, R.drawable.image1, false));
        preguntas.add(new Pregunta(R.string.preg2, R.drawable.image2, false));
        preguntas.add(new Pregunta(R.string.preg3, R.drawable.image3, true));
        preguntas.add(new Pregunta(R.string.preg4, R.drawable.image4, false));
        preguntas.add(new Pregunta(R.string.preg5, R.drawable.image5, false));
        preguntas.add(new Pregunta(R.string.preg6, R.drawable.image6, true));
        preguntas.add(new Pregunta(R.string.preg7, R.drawable.image7, true));
        preguntas.add(new Pregunta(R.string.preg8, R.drawable.image8, false));
        preguntas.add(new Pregunta(R.string.preg9, R.drawable.image9, true));
        preguntas.add(new Pregunta(R.string.preg10, R.drawable.image10, true));

        //Combina las preguntas aleatoriamente
        Collections.shuffle(preguntas);

        return new Trivia(preguntas, 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.preguntas);
        dest.writeInt(this.posicion);
    }

    public void readFromParcel(Parcel source) {
        this.preguntas = source.createTypedArrayList(Pregunta.CREATOR);
        this.posicion = source.readInt();
    }

    protected Trivia(Parcel in) {
        this.preguntas = in.createTypedArrayList(Pregunta.CREATOR);
        this.posicion = in.readInt();
    }

    public static final Creator<Trivia> CREATOR = new Creator<Trivia>() {
        @Override
        public Trivia createFromParcel(Parcel source) {
            return new Trivia(source);
        }

        @Override
        public Trivia[] newArray(int size) {
            return new Trivia[size];
        }
    };

}
