package namria.forsea.testers;

import namria.forsea.data.lights.LightPoint;

/**
 * Created by Jose Salinas on 6/7/2017.
 */


public class LightsTester {

    public static void main(String[] args) {

        LightPoint lightPoint1 = new LightPoint("Don Galo",0,14.508742,120.974719,30,true);
        LightPoint lightPoint2 = new LightPoint("Taliptip",1,14.711406,120.885578,10,true);
        LightPoint lightPoint3 = new LightPoint("Ipag",2,14.408626,120.498870,0,true);
        LightPoint lightPoint4 = new LightPoint("Bagac",3,14.523982,120.376304,5,true);

        System.out.println(lightPoint1.toString());
        System.out.println(lightPoint2.toString());
        System.out.println(lightPoint3.toString());
        System.out.println(lightPoint4.toString());

        System.out.println(lightPoint1.getName());
        System.out.println(lightPoint1.getIndex());
        System.out.println(lightPoint1.getCoordinates().toString());
        System.out.println(lightPoint1.getAltitude());
        System.out.println(lightPoint1.isActive());
    }
}
