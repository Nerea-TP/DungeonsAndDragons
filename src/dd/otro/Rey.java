package dd.otro;

public class Rey extends Personaje {

    /**Estabelce el nombre del personaje, incia la salud a 2000 y establece el tipo de Ataque espada.
     * @param nombre
     */
    public Rey(String nombre) {
        super(nombre);
        setVida(2000);
        setAtaque(new AtaqueEspada());
    }
//el Rey ataca 3 veces, si el enemigo muere antes del segundo o tercer ataque, no haberá ataque
    @Override
    public int[] ataca(Personaje enemigo) {
        int[] ataqueResultado = new int[3];
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
        return "[Rey " + super.toString();
    }

}
