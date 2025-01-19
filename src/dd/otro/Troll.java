package dd.otro;

public class Troll extends Personaje {

    /**Estabelce el nombre del personaje, incia la salud a 1500 y establece el tipo de Ataque con arco, espada y cuchillo
     * @param nombre
     */
    public Troll(String nombre) {
        super(nombre);
        setVida(1000);
        setAtaque(new AtaqueArco());
        setAtaque(new AtaqueEspada());
        setAtaque(new AtaqueCuchillo());
    }
//el Caballero ataca 1 vez, si el enemigo muere antes del segundo ataque, no haberá ataque
    @Override
    public int[] ataca(Personaje enemigo) {
        int[] ataqueResultado = new int[1];
        for (int i = 0; i < ataqueResultado.length; i++) {
            if (enemigo.getVida() > 0) {
                ataqueResultado[i] = getAtaque().lanzaAtaque(enemigo);
            } else {
                break;
            }
        }
        return ataqueResultado;
    }
    @Override
    public String toString() {
        return "[" + super.toString();
    }

}
