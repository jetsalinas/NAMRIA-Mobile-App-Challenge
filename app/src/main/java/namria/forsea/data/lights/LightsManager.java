package namria.forsea.data.lights;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Jose Salinas on 6/3/2017.
 */

public class LightsManager {

    private ArrayList<LightPoint> getListOfLights() {
        return null;
    }

    /**
     * @param context The calling application's context
     * @param filename The file name of the list of lights database
     * @return Returns an array list of strings containing raw data of each light point, otherwise returns null
     */
    public ArrayList<String> parseLightsDatabase(Context context, String filename) {

        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        ArrayList<String> lightsStringArray = null;

        try {
            fileInputStream = context.openFileInput(filename);
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            lightsStringArray = new ArrayList<>();
            String line;
            while((line = bufferedReader.readLine()) != null) {
                lightsStringArray.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        }

        return lightsStringArray;
    }
}
