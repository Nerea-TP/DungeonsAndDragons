package dd.main;

import dd.otro.*;
public class Basico {
    public static void main(String[] args) {
        //pruebas sin ejercitos ni victorias
        Personaje p1= new Rey("Arturo");
        p1.setAtaque(new AtaqueEspada());
        Personaje p2= new Troll("Troll 1");
        p2.setAtaque(new AtaqueArco());
        System.out.println(p1+","+p1.getAtaque());
        System.out.println(p2+","+p2.getAtaque());
        int[] valoresAtaque=p1.ataca(p2);
        for(int valor:valoresAtaque){
            System.out.println("p1 ataca a p2 y el valor del ataque es: "+
            (valor>0?valor:"falla"));
        }
        System.out.println("comprobar salud actualizada de p2");
        //con salud <=0 lo considero muerto
        System.out.println(p2.getVida()<=0?"MUERTO" + p2.getNombre():p2);
       
        System.out.println("Vamos a repetir el ataque pero ahora forzando que p2 muera poniendo salud a 1");
        //si todos los ataques son fallidos se salva!!!
        p2.setVida(1);

        valoresAtaque=p1.ataca(p2);
        //si el ataque puede tener valor 0 para simular un fallo
        for(int valor:valoresAtaque){
            System.out.println("p1 ataca a p2 y el valor del ataque es: "+
            (valor>0?valor:"falla"));
        }

        System.out.println("comprobar salud actualizada de p2");
        System.out.println(p2.getVida()<0?"MUERTO maldito " + p2.getNombre():p2);
    }

}
