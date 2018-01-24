package controller;

import java.sql.Time;

public class Timer extends Thread {
    static public Time time = new Time(0,0,0);


    public void start() {
        while (true) {

            /*synchronized (){
                time.wait();
                time.setTime(time.getTime() + 1);
                System.out.println(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}

