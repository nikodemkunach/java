public class TV {
    public static void main(String[] args) {
        Television tv = new Television();
        tv.powerOn();
        tv.powerOff();
        tv.changeChannel (1);
        tv.changeVolume (2);

        tv.printStatus ();
        System.out.println("Changing status: ");
        tv.powerOff();
        System.out.println("TV is off. Turn it on: ");
        System.out.println("Changing status: ");
        tv.powerOn();
        tv.printStatus();
        System.out.println("Changing volume: ");
        tv.changeVolume(20);
        tv.printStatus();
        System.out.println("Changing channels: ");
        tv.printStatus();
        tv.changeChannel(4);
        tv.printStatus();
        tv.changeChannel(18);
        tv.printStatus();

        System.out.println("Turning off the tv...");
        tv.powerOff();
        System.out.println("TV is off");

    }
}
class Television {

    int channel=0;
    int volume=0;
    boolean power = true;

    void powerOn(){
        power = true;
    }
    void powerOff (){
    }
    void changeChannel (int newValue){
        if (power==true)
            channel = newValue;
    }
    void changeVolume (int newValue){
        if (power==true)
            volume = newValue;
    }
    void printStatus(){
        System.out.println("TV status powerOn: " + "Channel: " + channel + " Volume: " + volume);
    }
}