import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


// @author Furkan Tosun Date: 06.04.24
public class HW04_20220808025 {


    public static void main(String[] args) {

       


    }
}













    class Computer {
        protected CPU cpu;
        protected RAM ram;

        public Computer(CPU cpu, RAM ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public void run() throws ComputationException, MemoryException,InterruptedException {
            int i=0;
            try {
                int sum = 0;

                for (i=0; i < ram.getCapacity(); i++) {

                        sum =cpu.compute(ram.getValue(i, i),sum);

                }
                ram.setValue(0, 0, sum);
            } catch (ComputationException e) {
                e.fixComputation(i,i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        @Override
        public String toString() {
            return "Computer: " + cpu + " " + ram;
        }
    }

    class Laptop extends Computer {
        private int milliAmp;
        private int battery;

        public Laptop(CPU cpu, RAM ram, int milliAmp) {
            super(cpu, ram);
            this.milliAmp = milliAmp;
            this.battery = milliAmp * 30 / 100;
        }

        public int batteryPercentage() {
            return (battery * 100) / milliAmp;
        }

        public void charge() {
            while (battery < milliAmp * 90 / 100) {
                battery += milliAmp * 2 / 100;
            }
        }

        @Override
        public void run() throws InterruptedException {
            if (batteryPercentage() > 5) {
                try {
                    super.run();
                    battery -= milliAmp * 3 / 100;
                } catch (ComputationException | MemoryException e) {
                    e.printStackTrace();
                }
            } else {
                charge();
            }
        }

        @Override
        public String toString() {
            return super.toString() + " " + battery;
        }
    }

    class Desktop extends Computer {
        private ArrayList<String> peripherals;

        public Desktop(CPU cpu, RAM ram, String... peripherals) {
            super(cpu, ram);
            this.peripherals = new ArrayList<>(Arrays.asList(peripherals));
        }


        @Override
        public void run() throws ComputationException, MemoryException, InterruptedException{
            int sum = 0;
            for (int i = 0; i < ram.getCapacity(); i++) {

                    sum = cpu.compute(sum, ram.getValue(i, i));

            }
            ram.setValue(0, 0, sum);
        }

        public void plugIn(String peripheral) {
            peripherals.add(peripheral);
        }

        public String plugOut() {

            String temp;
            if (!peripherals.isEmpty()) {
                temp= peripherals.getLast();
                peripherals.remove(peripherals.size() - 1);
                return temp;
            }
            return null;
        }

        public String plugOut(int index) {
            String temp;
            if (index >= 0 && index < peripherals.size()) {
                temp= peripherals.get(index);
                return temp;
            }
            return null;
        }

        @Override
        public String toString() {
            return super.toString() + " " + String.join(" ", peripherals);
        }
    }

    class CPU {
        private String name;
        private double clock;

        public CPU(String name, double clock) {
            setName(name);
            setClock(clock);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setClock(double clock) {
            this.clock = clock;
        }

        public String getName() {
            return name;
        }

        public double getClock() {
            return clock;
        }

        public int compute(int a, int b) throws ComputationException, InterruptedException {
            try {
                Thread.sleep((long) (5 / clock * 1000));
                int result = a + b;
                if (result < 0) {
                    throw new ComputationException(this, a, b);
                }
                return result;
            } catch (InterruptedException e) {
                throw new InterruptedException("Exception occurred due to internal clock speed: " + clock);
            }
        }

        @Override
        public String toString() {
            return "CPU: " + name + " " + clock + "Ghz";
        }
    }

    class RAM {
        private String type;
        private int capacity;
        private int[][] memory;

        public RAM(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
            initMemory();
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }

        private void initMemory() {
            memory = new int[capacity][capacity];
            Random rand = new Random();
            for (int i = 0; i < capacity; i++) {
                for (int j = 0; j < capacity; j++) {
                    memory[i][j] = rand.nextInt(11);
                }
            }
        }

        private boolean check(int i, int j) throws MemoryException {
            if (i >= 0 && i < capacity && j >= 0 && j < capacity) {
                return true;
            } else {
                throw new MemoryException(this, i, j);
            }
        }

        public int getValue(int i, int j) throws MemoryException {
            if (check(i, j)) {
                return memory[i][j];
            }
            return -1; // Return a default value if out of bounds
        }

        public void setValue(int i, int j, int value) throws MemoryException {
            if (check(i, j)) {
                memory[i][j] = value;
            }
        }

        @Override
        public String toString() {
            return "RAM: " + type + " " + capacity + "GB";
        }
    }

    class MemoryException extends RuntimeException {
        private RAM ram;
        private int address1;
        private int address2;

        public MemoryException(RAM ram, int address1, int address2) {
            super("Memory out of range! With addresses #" + address1 + ", " + address2);
            this.ram = ram;
            this.address1 = address1;
            this.address2 = address2;
        }
    }

    class ComputationException extends Exception {
        private CPU cpu;
        private int value1;
        private int value2;

        public ComputationException(CPU cpu, int value1, int value2) {
            super("Computation exception occurred on " + cpu + " with values: (" + value1 + ", " + value2 + ")");
            this.cpu = cpu;
            this.value1 = value1;
            this.value2 = value2;
        }

        public ComputationException(ComputationException e) {
            super("Unhandled exception occurred at " + e.cpu + " with values " + e.value1 + " and " + e.value2 + ":\n\t" + e.getMessage());
            this.cpu = e.cpu;
            this.value1 = e.value1;
            this.value2 = e.value2;
        }

        public int fixComputation(int val1, int val2) throws ComputationException, InterruptedException {
            try {
                // Take absolute values
                int absVal1 = Math.abs(val1);
                int absVal2 = Math.abs(val2);

                // Perform computation using CPU
                return this.cpu.compute(absVal1,absVal2);
            } catch (ComputationException e) {
                // Re-throw ComputationException
                throw e;
            } catch (InterruptedException e) {
                // Print stack trace and re-throw InterruptedException
                e.printStackTrace();
                throw e;
            }
        }





    }








