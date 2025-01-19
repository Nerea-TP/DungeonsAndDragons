package dd.otro;

public class AtaqueEspada implements Ataque {

    private final int ATAQUE = 100;
//el arco causa 100 de daño, usamos el metodo static y luego actualizamos la salud del enemigo
    @Override
    public int lanzaAtaque(Personaje enemigo) {
        int daño = (int) (ATAQUE * Ataque.getAciertoFactor());
        enemigo.saludActualizada(daño);
        return daño;
    }

    @Override
    public String toString() {
        return "espada";
    }

}
