// DESPUÉS: aplicando el patrón State.

// 1. Interfaz State: el comportamiento común a todos los estados
interface Estado {
    void play(Reproductor r);
    void pausa(Reproductor r);
    void detener(Reproductor r);
}

// 2. Context: guarda el estado actual y le delega el trabajo
class Reproductor {
    private Estado estado = new Detenido();

    public void setEstado(Estado nuevo) {
        this.estado = nuevo;
    }

    public void play()    { estado.play(this); }
    public void pausa()   { estado.pausa(this); }
    public void detener() { estado.detener(this); }
}

// 3. ConcreteStates: cada estado decide qué hacer y a cuál pasar
class Detenido implements Estado {
    public void play(Reproductor r) {
        System.out.println("Iniciando reproducción");
        r.setEstado(new Reproduciendo());
    }
    public void pausa(Reproductor r) {
        System.out.println("No se puede pausar: está detenido");
    }
    public void detener(Reproductor r) {
        System.out.println("Ya está detenido");
    }
}

class Reproduciendo implements Estado {
    public void play(Reproductor r) {
        System.out.println("Ya se está reproduciendo");
    }
    public void pausa(Reproductor r) {
        System.out.println("Pausando");
        r.setEstado(new Pausado());
    }
    public void detener(Reproductor r) {
        System.out.println("Deteniendo");
        r.setEstado(new Detenido());
    }
}

class Pausado implements Estado {
    public void play(Reproductor r) {
        System.out.println("Reanudando canción");
        r.setEstado(new Reproduciendo());
    }
    public void pausa(Reproductor r) {
        System.out.println("Ya está en pausa");
    }
    public void detener(Reproductor r) {
        System.out.println("Deteniendo");
        r.setEstado(new Detenido());
    }
}

public class Despues {
    public static void main(String[] args) {
        Reproductor r = new Reproductor();
        r.play();     // Iniciando reproducción
        r.pausa();    // Pausando
        r.play();     // Reanudando canción
        r.detener();  // Deteniendo
        r.pausa();    // No se puede pausar: está detenido
    }
}
