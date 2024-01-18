package Facade;

// Subsystem components
class DVDPlayer {
    void on() {
        System.out.println("DVD Player is on");
    }

    void play(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    void off() {
        System.out.println("DVD Player is off");
    }
}

class Projector {
    void on() {
        System.out.println("Projector is on");
    }

    void setInput(DVDPlayer dvdPlayer) {
        System.out.println("Setting projector input to DVD Player");
    }

    void off() {
        System.out.println("Projector is off");
    }
}

class Lights {
    void dim() {
        System.out.println("Dimming the lights");
    }

    void on() {
        System.out.println("Lights are on");
    }

    void off() {
        System.out.println("Lights are off");
    }
}

// Facade class
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Lights lights;

    public HomeTheaterFacade(DVDPlayer dvdPlayer, Projector projector, Lights lights) {
        this.dvdPlayer = dvdPlayer;
        this.projector = projector;
        this.lights = lights;
    }

    // Facade methods
    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie!");
        lights.dim();
        projector.on();
        projector.setInput(dvdPlayer);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down the movie night...");
        lights.on();
        projector.off();
        dvdPlayer.off();
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Create subsystem components
        DVDPlayer dvdPlayer = new DVDPlayer();
        Projector projector = new Projector();
        Lights lights = new Lights();

        // Create facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, projector, lights);

        // Client uses the simplified interface provided by the facade
        homeTheater.watchMovie("Inception");
        System.out.println("\nMovie night is over!\n");
        homeTheater.endMovie();
    }
}

