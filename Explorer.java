 package main;
 import java.util.Scanner;
public class Explorer extends Main{
        public static Scanner reader = new Scanner(System.in);
        public static int food;
        public static int water;
        public static int rest;
        public static int gold;
        public static int day;
    public static void cstmprint(String text){
        System.out.println(text);
    }
    public static void Option(){
        cstmprint("");
        cstmprint("");
        cstmprint("ELIGE UNO: ");
        cstmprint("1. EXPLORAR. (-15 COMIDA, -15 AGUA -20 ENERGIA, +1-20 ORO, CHANCE DE TORMENTA!)");
        cstmprint("2. DESCANSAR. (-10 COMIDA, -10 AGUA, + 20 ENERGIA)");
        cstmprint("3. RACIONAR. (-5 COMIDA, -5 AGUA, - 15 ENERGIA");
        cstmprint("4 TIENDA. (-5 ENERGIA, -10 DE ORO, + 2O DE AGUA O COMIDA)");
        String option = reader.next();
        switch(option){
                    case "1" -> EXPLORAR();
                    case "2" -> DESCANSAR();
                    case "3" -> RACIONAR();
                    case "4" -> TIENDA();
                    default -> Default();
        }
    }
    public static void Default(){
        Option();
    }
    public static void EXPLORAR(){
        food -= 15;
        water -= 15;
        rest -= 20;
        int add =(int) (20*Math.random());
        if (add > 15){
            add -= 5;
        }
        gold += add;
        int chance =(int)(10*Math.random());
        if (chance <= 3){
            cstmprint("");
            cstmprint("TORMENTA! (-10 DE ENERGIA)");
            rest -= 10;
        }
    }
    public static void DESCANSAR(){
        rest += 25;
        food -= 10;
        water -= 10;
    }
    public static void RACIONAR(){
        rest -= 15;
        food -= 5;
        water -= 5;
    }
    public static void TIENDA(){
        if(gold >= 10){
            
            cstmprint("");
            cstmprint("ELIGE UNO:");
            cstmprint("1. +20 AGUA");
            cstmprint("2. +20 COMIDA");
            String option = reader.next();
            if(option.equals("1")){
                water += 20;
                gold -= 10;
            }else{
                food += 20;
                gold -= 10;
            }
        }else{
            cstmprint("");
            cstmprint("NO TIENES SUFICIENE ORO.");
            Option();
      }
    }
    public static void playagain(){
        cstmprint("VOLVER A JUGAR?  (Y/N)");
        String yn = reader.next();
        if(yn.equals("Y") || yn.equals("y")){
            juego();
        }else if(yn.equals("N") || yn.equals("n")){
            System.exit(0);
        }else{
            cstmprint("");
            playagain();
        }
    }
    public static void lose(String cause){
        cstmprint("");
        cstmprint("PERDISTE EN EL DIA " + day + "!");
        cstmprint("TU " + cause + " LLEGO A 0.");
        
        playagain();
    }
    public static void win(){
        cstmprint("");
        cstmprint("GANASTE!");
        playagain();
    }
    public static void limit(){
        if (water > 100){
            water = 100;
        }else if(food > 100){
            food = 100;
        }else if(rest > 100){
            rest = 100;
        }
    }
    public static void check(){
        if (water <= 0){
            lose("AGUA");
        }else if(food <= 0){
            lose("FOOD");
        }else if(rest <= 0){
            lose("ENERGIA");
        }
    }
    public static void juego(){
        food = 100;
        water = 100;
        rest = 100;
        gold = 20;
        cstmprint("----------------- COMENZAR JUEGO ----------------");
        for(day = 1; day != 11; day++){
            cstmprint("DIA: " + day + " AGUA: " + water + " COMIDA: " + food + " ENERGIA: " + rest + " ORO: " + gold);
            Option();
            check();
            limit();
        }
        win();
    }
    public static void main(String[] args){
        juego();
    }
}