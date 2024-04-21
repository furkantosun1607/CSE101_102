import java.time.Duration;

public class Lab05_20220808025 {

    public static void main(String[] args) {
        CPUe cpu = new CPUe("Amd Radeon 5600h", 3.6);
        RAMe ram= new RAMe("Kingston", 16);
        Laptope lenovo= new Laptope(cpu,ram,1800);
        lenovo.run();

    }

}
abstract class Computere {
    protected CPUe cpu;
    protected RAMe ram;


    Computere(CPUe cpu, RAMe ram){
        setCpu(cpu);
        setRam(ram);
    }

    public void setCpu(CPUe cpu) {
        this.cpu = cpu;
    }

    public void setRam(RAMe ram) {
        this.ram = ram;
    }

    public void run(){
        for (int i = 0; i < ram.getCapacity() ; i++) {
            int adress1=ram.getValue(0,0);
            int adress2=ram.getValue(i,i);
            int result=0;
            try {
                result= cpu.compute(adress1,adress2);
                System.out.println(result);
            }catch (RuntimeException e){e.printStackTrace();}
            ram.setValue(i,i,result);



        }

    }

    @Override
    public String toString() {
        return "computer "+cpu+" "+ram;
    }




}

class Laptope extends Computere{
    private int milliAmp;
    private int battery;



    public void setMilliAmp(int milliAmp) {
        this.milliAmp = milliAmp;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public Laptope(CPUe cpu, RAMe ram, int milliAmp) {
        super(cpu, ram);
        this.milliAmp = milliAmp;
        this.battery = (int) (0.3 * milliAmp);
    }

    public int batteryPercentage() {
        return (int) (((double) battery / milliAmp) * 100);
    }

    public void charge(){
        while(batteryPercentage()<90){
            battery++;
        }

    }

    @Override
    public void run() {

        while(batteryPercentage()>5) {
            ram.initmem();
            super.run();
            battery-=3;
        }

    }

    @Override
    public String toString() {
        return super.toString()+" "+battery;
    }
}






class CPUe {
    private String name;
    private double clock;
    CPUe(String name, double clock){
        setClock(clock);
        setName(name);

    }

    public String getName() {
        return name;
    }

    public double getClock() {
        return clock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClock(double clock) {
        this.clock = clock;
    }

    public int compute(int a, int b){
        try {Thread.sleep((int)((4/clock)*1000));

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    return a+b;

    }



    @Override
    public String toString() {
        return "CPU "+name+" clock "+clock;
    }






}







class RAMe{
    private String type;
    private int capacity;
    private int[][] memory;

    public RAMe(String type, int capacity){
        setCapacity(capacity);
        setType(type);
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
    public void initmem(){
        initMemory();
    }
    private void initMemory(){
        this.memory=new int[getCapacity()][getCapacity()];
        for (int i = 0; i < memory.length; i++) {

            for (int j = 0; j < memory.length; j++) {
                memory[i][j]=(int)(Math.random()*10);
            }

        }

    }
    private boolean check(int i, int j) throws ArrayIndexOutOfBoundsException{
        try {
           if( memory[i][j]==memory[i][j]){return true;}
        }catch (Exception e){return false;}
        return true;
    }
    public int getValue(int i , int j){

        if(check(i, j)){
            return memory[i][j];
        }
        else {return -1;}
    }
    public void setValue(int i, int j ,int value){
        if(true){
            memory[i][j]=value;
        }
        else {throw new RuntimeException("setvalue fonksiyonu hatalı");}

    }

    @Override
    public String toString() {
        return "RAM : "+type+" capacity "+capacity+" gb ";
    }
    public void rameyaz(int a){
        memory[0][0]=a;
    }


}

class Memoryxceptions extends RuntimeException{
    private RAMe ram;
    Memoryxceptions(RAMe ram, int i, int j){
        super("indexes are out of bounds");
        this.ram=ram;
    }



}
class ComputationExceptione extends Exception{
    private CPUe cpu;
    ComputationExceptione(CPUe cpu){
        super("an exception occured during computation");
        this.cpu=cpu;
    }


}


































































































