/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.Scanner;

/**
 *
 * @author Maximiliano
 */
public class folkytung {
    static boolean endloop;
    static int hp = 120;
    static int e = 0;
    static int c = 0;
    static final int DMG = -30;
    static final int MAXHP = 120;
    static void cstmprint(String text){
        System.out.print(text);
    }
    static void qformat(String question, String answers){
        cstmprint(question);
        cstmprint(answers);
    }
    static boolean check(String which, int i){
        if (which.toLowerCase().equals(rightAnswers[i])){
            return(true);
        }
            return(false);
    }
    static String[] questions = {
                                "1. Cual es el nombre del guia que causa que deje la gorra verde?\n",
                                "2. Cual no es una manera de conseguir mithril?\n",
                                "3. Que monstruo no aparece en la mazmorra?\n",
                                "4. Donde aparece el cerdidragon rosa?\n",
                                "5. En que etapa del juego es mas veloz el esparcimiento del bioma malvado?\n",
                                "6. Como se consigue el Reloj lunar encantado?\n",
                                "7. Que aldeano es el menos querido entre todos los demas aldeanos?\n",
                                "8. Cual es la pintura mas rara de encontrar bajotierra?\n",
                                "9. Cual no es un material de las botas terrachispa?\n",
                                "10. Es posible matar al duque fishron como el primer jefe (1.4.5+)?\n"
                                };
    static String[] answers = {
                            "a) James\n"+
                            "b) Jack\n"+
                            "c) Andrew\n"+
                            "d) Jacob\n",
        
                            "a) Pescando\n" +
                            "b) Tirando oricalco en el resplandor\n" +
                            "c) Minandolo\n" +
                            "d) Extrayendo limon\n",
                            
                            "a) Esqueleto arquero\n" +
                            "b) Huesitos furiosos\n" +
                            "c) Mago siniestro\n" +
                            "d) Bola de pinchos\n",
                            
                            "a) Tundra, bajo tierra\n" +
                            "b) Tundra bendita, bajo tierra\n" +
                            "c) Jungla, bajo tierra\n" +
                            "d) Tundra corrupta, superficie\n",
                            
                            "a) Pre-hardmode\n" +
                            "b) Post-Plantera\n" +
                            "c) Pre-Plantera\n" +
                            "d) Post-Golem\n",
                            
                            "a) Pescando en la noche\n" +
                            "b) Pescando en un lago celestial\n" +
                            "c) Como recompensa de misiones de pesca\n" +
                            "d) Tirando al Resplandor el Reloj de sol encantado\n",
                            
                            "a) Cyborg\n" +
                            "b) Vendedor de armas\n" +
                            "c) Recolector de impuestos\n" +
                            "d) Pescador\n",
                            
                            "a) Noche gloriosa\n"+
                            "b) Guia de Picasso\n"+
                            "c) Gotico terrariano\n"+
                            "d) Wally\n",
                            
                            "a) Botas de caminador de las llamas\n"+
                            "b) Botas del frenesi\n"+
                            "c) Amuleto de lava\n"+
                            "d) Calavera de obsidiana\n",
                            
                            "a) Si\n"+
                            "b) no\n"
                              };
    static String[] rightAnswers = {
                            "c", "b", "a", "b", "c", "d", "c", "d", "a", "a"
                            };
    static void win(){
        c++;
        if(hp != MAXHP){
            hp += 5;
            cstmprint("Respuesta correcta! + 5pv\n"+hp+" pv\n");
        }else
        cstmprint("Respuesta correcta!\n");
    }
    static void lose(){
        hp += DMG;
        e++;
        cstmprint("Respuesta incorrecta! -30 pv\n"+hp+" pv\n");
        checkLose();
    }
    static void checkLose(){
        if(hp<=0){
            cstmprint("Perdiste!\n");
            hp = 0;
            endloop = true;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < questions.length && endloop == false; i++){
            qformat(questions[i], answers[i]);
            if(check(sc.next(), i)){
                win();
            }else{
                lose();
            }
        }
        cstmprint("Quiz terminado!\n");
        cstmprint("Respuestas correctas = " +c+"\n");
        cstmprint("Respuestas incorrectas = " +e+"\n");
        cstmprint("Puntos de vida restantes = "+ hp+"\n");
        if(e != 0){
            cstmprint("\nVuelve a intentar por un mejor puntaje!\n");
        }
        System.exit(0);
    }
}
