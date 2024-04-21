public class lab7 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {

            System.out.println(random(5));
            
        }

    }

    public static int random(){
        int value = (int)(Math.random()*(10));
        return value;


    }
    static int random( int max, int min){
        return min + (int)(Math.random()*(max-min+1));

    }

    static char random(char start, char end) {
        return (char)((int)start + Math.random() * ((int)end - (int)start + 1));
    }

    static int random(String length){
        return length.length();
    }

    static  String random(int length){
        String s = "";
        for (int i = 0; i < length; i++) {
            s += random('a','t');

        }
        return s;
    }

    static int random(int a, int b, int c) {
        int number = random();
        if (number == a || number == b || number ==c)
            number = random();
        return number;

    }


}
