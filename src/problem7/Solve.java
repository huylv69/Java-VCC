package problem7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huylv
 */
public class Solve {
    public static void main(String[] args) {
        ArrayList<VanTai> listVehicle = new ArrayList();

        Oto oto1 = new Oto();
        Oto oto2 = new Oto();
        Oto oto3 = new Oto();
        listVehicle.add(oto1);
        listVehicle.add(oto2);
        listVehicle.add(oto3);

        XeDap xeDap1 = new XeDap();
        XeDap xeDap2 = new XeDap();
        XeDap xeDap3 = new XeDap();
        listVehicle.add(xeDap1);
        listVehicle.add(xeDap2);
        listVehicle.add(xeDap3);

        XeTai xeTai1 = new XeTai();
        XeTai xeTai2 = new XeTai();
        XeTai xeTai3 = new XeTai();
        listVehicle.add(xeTai1);
        listVehicle.add(xeTai2);
        listVehicle.add(xeTai3);

        for (VanTai object : listVehicle) {
            object.diChuyen();
        }
    }
}
