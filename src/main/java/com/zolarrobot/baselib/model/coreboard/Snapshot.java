package com.zolarrobot.baselib.model.coreboard;

/**
 * Created by Go on 2019/1/3.
 */

public class Snapshot {
    public String Battery = "";
    public String Emergencybt = "";
    public String HighEnergy = "";
    public boolean Charge = false;

    public Snapshot() { }

//    public void update(Snapshot p) {
//        this.Battery = (p.Battery != null) ? p.Battery : this.Battery;
//        this.Emergencybt = (p.Emergencybt != null) ? p.Emergencybt : this.Emergencybt;
//        this.HighEnergy = (p.HighEnergy != null) ? p.HighEnergy : this.HighEnergy;
//    }

    public boolean isNaviOn() {
        if (this.HighEnergy != null) {
            return this.HighEnergy.equals("wake");
        }
        else {
            return false;
        }
    }

    public boolean isEmergencyOn() {
        if (this.Emergencybt != null) {
            return this.Emergencybt.equals("1");
        }
        else {
            return false;
        }
    }

}

//{"Battery": "88", "HighEnergy": "wake", "Charge": true, "Emergencybt": "0"}