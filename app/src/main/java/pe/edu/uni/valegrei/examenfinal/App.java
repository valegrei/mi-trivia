package pe.edu.uni.valegrei.examenfinal;

import android.app.Application;
import android.os.Environment;

import com.bosphere.filelogger.FL;
import com.bosphere.filelogger.FLConfig;
import com.bosphere.filelogger.FLConst;

import java.io.File;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FL.init(new FLConfig.Builder(this)
                .minLevel(FLConst.Level.V)
                .logToFile(true)
                .dir(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "file_logger_trivia_valegrei"))
                .retentionPolicy(FLConst.RetentionPolicy.FILE_COUNT)
                .build()
        );
        FL.setEnabled(true);
    }
}
