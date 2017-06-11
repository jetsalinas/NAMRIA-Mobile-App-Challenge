package namria.forsea.network;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Jose Salinas on 6/11/2017.
 */

public class NetworkService extends IntentService {

    private static final String TAG = "Network Service";

    public NetworkService() {
        super("Network Service");
    }

    Context context;

    @Override
    public void onCreate() {
        context = this;
        super.onCreate();
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        //return super.onBind(intent);
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            JSONObject test = getResource(new URL(Constants.LIGHTS_ALL_URL));
            Log.i(TAG, test.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static final int READ_TIMEOUT = 3000;
    public static final int CONNECTION_TIMEOUT = 3000;

    private JSONObject getResource(URL url) throws IOException, JSONException {
        InputStream inputStream = null;
        HttpsURLConnection connection = null;
        JSONObject result = null;

        try {
            connection = (HttpsURLConnection)url.openConnection();
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setRequestMethod("GET");
            connection.setDoInput(false);

            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode != HttpsURLConnection.HTTP_OK) {
                throw new IOException("HTTP: " + responseCode);
            }
            inputStream = connection.getInputStream();
            if(inputStream != null) {
                result = new JSONObject(streamToString(inputStream));
            }

        } finally {
            if(inputStream != null) {
                inputStream.close();
            }
            if(connection != null) {
                connection.disconnect();
            }
        }

        return result;
    }

    private static int MAX_STREAM_LEGNTH = 10000;

    private String streamToString(InputStream inputStream) throws IOException {
        String result = null;
        InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
        char[] buffer = new char[MAX_STREAM_LEGNTH];
        int numChars = 0;
        int readSize = 0;
        while(readSize != -1) {
            numChars += readSize;
            readSize = reader.read(buffer, numChars, buffer.length - numChars);
        }
        if(numChars != -1) {
            numChars = Math.min(numChars, MAX_STREAM_LEGNTH);
            result = new String(buffer, 0, numChars);
        }
        return result;
    }
}
