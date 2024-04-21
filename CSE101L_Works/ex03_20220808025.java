import java.util.Random;
import java.util.Scanner;

public class ex03_20220808025 {
    public static void main(String[] args) {
        // exercise one

        System.out.println(" Please enter number of what "+
                " you want to eat:");
        Scanner scanner = new Scanner(System.in);
        int mainmealprice = scanner.nextInt();
        int  beverageprice;
        String mainmeal= "";
        String beverage = "";
        if (mainmealprice == 1){ mainmealprice = 80;  mainmeal = "Doner ";}
        else if (mainmealprice== 2) { mainmealprice = 110;  mainmeal = "Kebab ";}
        else if (mainmealprice == 3) { mainmealprice = 75;  mainmeal = "Lahmacun ";}
        System.out.println("Please enter number of what"+
                                " you want to drink: ");
        beverageprice = scanner.nextInt();
        if      (beverageprice==1) { beverageprice = 10;  beverage = "and Ayran";}
        else if (beverageprice==2) { beverageprice = 20;  beverage = "and Kola";}
        else if (beverageprice==3) { beverageprice = 15;  beverage = "and Salgam";}
        int hesap = mainmealprice + beverageprice;
        System.out.println(mainmeal + beverage +" "+ hesap);

        // exercise two

        System.out.print("Enter the package you are using (1 or 2): ");
        int PacketType = scanner.nextInt();
        System.out.print("Enter your internet usage in GB: ");
        int internetUsage = scanner.nextInt();

        double Packetprice =0;
        double GBprices =0;
        double Taxrate = 0;
        if (PacketType == 1) {
            Packetprice = 80;
            GBprices = 3;
            Taxrate = 15./100;
             if (internetUsage<=100) {
                 System.out.println("The total amount you have to pay: 92.5 liras");}
             if (internetUsage > 100) {
                 double cprice = (internetUsage - 100) * GBprices + Packetprice;
                 double taxi = cprice * 15 / 100;
                 double ddd = taxi + cprice;
                 System.out.println("The total amount you have to pay:"+ddd +" liras");
             }

        } else if (PacketType == 2) {
            Packetprice = 140;
            GBprices = 5;
            Taxrate = 10./100;
             if (internetUsage>200){
                 double cprice = (internetUsage - 200) * GBprices + Packetprice;
                 double taxi = cprice * 10 / 100;
                 double ddd = taxi + cprice;
                 System.out.println("The total amount you have to pay:"+ddd + " liras");
             }
             if (internetUsage<=200) {
                 System.out.println("The total amount you have to pay: 161 liras");
          }  } else {
            System.out.println(" invalid value");
             }



        // exercise three

        System.out.println("Please enter attack type (1 or 2)");
        int attacktype= scanner.nextInt();
        int min = 0;
        int max = 3;

        int randomNumber = (int) (Math.random() * (max - min)) + min;
        if (attacktype==1 && randomNumber==2){
            System.out.println(" the damage dealt by the attack: 60");
            }
        else if (attacktype==1 && randomNumber !=2.){
            System.out.println("the damage dealt by the attack: 0");
        }
        else if (attacktype==2 && randomNumber ==0.){
            System.out.println("the damage dealt by the attack 50");
        }
        else if (attacktype==2 && randomNumber ==1.){
            System.out.println("the damage dealt by the attack 70");
    }
        else if (attacktype==2 && randomNumber ==2.){
            System.out.println("the damage dealt by the attack 90");
}

    }
}










