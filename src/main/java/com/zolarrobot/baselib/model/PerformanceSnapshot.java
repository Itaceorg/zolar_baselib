package com.zolarrobot.baselib.model;

import com.zolarrobot.baselib.utils.Kit;

import java.util.ArrayList;

/**
 * Created by Go on 2018/6/11.
 */

public class PerformanceSnapshot {

    public ArrayList<String> thermals = new ArrayList<String>();

    public ArrayList<ProcessState> processStates = new ArrayList<ProcessState>();

    public static class ProcessState {
        public String cpuRate = "";
        public String threadCount = "";
        public String vss = "";
        public String rss = "";
        public String policy = "";
        public String name = "";


    }

    public String getThermalByIndex(int index) {
        String result = "";

        try {
            if (thermals.size() > index) {
                String sThermal = thermals.get(index);
                if (sThermal.length() >= 4) {
                    StringBuilder sb = new StringBuilder(sThermal);
                    sThermal = sb.insert(2, ".").toString();
                }
                result = Kit.format(Double.valueOf(sThermal), "#.00") + " ℃";
            }
        }
        catch (Exception e) {
//            e.printStackTrace();
        }

        return result;
    }

    public String getProcessByIndex(int index) {
        String result = "";

        if (processStates.size() > index) {
            ProcessState processState = processStates.get(index);
            String pName = processState.name.replace("com.zolarrobot.", "");
            String cpuRate = String.format("%3s", processState.cpuRate).replace(" ", "_");
            String threadCount = String.format("%2s", processState.threadCount).replace(" ", "_");
            String rss = String.format("%7s", processState.rss).replace(" ", "_");

            result = cpuRate +
                    " " + threadCount +
                    " " + rss +
                    " " + pName;
        }

        return result;
    }

}
