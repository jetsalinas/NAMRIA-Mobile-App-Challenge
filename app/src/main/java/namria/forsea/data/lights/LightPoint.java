package namria.forsea.data.lights;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jose Salinas on 6/3/2017.
 */

public class LightPoint {

    private String name;
    private long index;
    private LatLng coordinates;
    private double altitude;
    private boolean isActive;

    public LightPoint(String data) {
        ArrayList<String> arrayData = new ArrayList<>();
        Collections.addAll(arrayData, data.split(","));

        name = arrayData.get(0);
        index = Long.parseLong(arrayData.get(1)) ;
        coordinates = new LatLng(Double.parseDouble(arrayData.get(2)), Double.parseDouble(arrayData.get(3)));
        altitude = Double.parseDouble(arrayData.get(4));
        isActive = Boolean.parseBoolean(arrayData.get(5));
    }

    public LightPoint(String name, long index, LatLng coordinates, double altitude, boolean isActive) {
        this.name = name;
        this.index = index;
        this.coordinates = coordinates;
        this.altitude = altitude;
        this.isActive = isActive;
    }

    public LightPoint(String name, long index, double latitude, double longitude, double altitude, boolean isActive) {
        this.name = name;
        this.index = index;
        this.coordinates = new LatLng(latitude, longitude);
        this.altitude = altitude;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public double getIndex() {
        return index;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    public double getAltitude() {
        return altitude;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(name);
        stringBuilder.append(",");
        stringBuilder.append(index);
        stringBuilder.append(",");
        stringBuilder.append(coordinates.latitude);
        stringBuilder.append(",");
        stringBuilder.append(coordinates.longitude);
        stringBuilder.append(",");
        stringBuilder.append(altitude);
        stringBuilder.append(",");
        stringBuilder.append(isActive);

        return stringBuilder.toString();
    }
}
