// ANTES: sin patrón State. Todo depende de condicionales.
public class Antes {

    static class Reproductor {
        private String estado = "DETENIDO";

        public void play() {
            if (estado.equals("DETENIDO")) {
                System.out.println("Iniciando reproducción");
                estado = "REPRODUCIENDO";
            } else if (estado.equals("PAUSADO")) {
                System.out.println("Reanudando canción");
                estado = "REPRODUCIENDO";
            } else {
                System.out.println("Ya se está reproduciendo");
            }
        }

        public void pausa() {
            if (estado.equals("REPRODUCIENDO")) {
                System.out.println("Pausando");
                estado = "PAUSADO";
            } else {
                System.out.println("No se puede pausar");
            }
        }

        public void detener() {
            if (estado.equals("DETENIDO")) {
                System.out.println("Ya está detenido");
            } else {
                System.out.println("Deteniendo");
                estado = "DETENIDO";
            }
        }
    }

    public static void main(String[] args) {
        Reproductor r = new Reproductor();
        r.play();
        r.pausa();
        r.play();
        r.detener();
    }
}
