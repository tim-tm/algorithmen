package queue.kiosk;

public class Schueler {
    private final String name;
    private final boolean oberstufe;

    public Schueler(String name, boolean oberstufe) {
        this.name = name;
        this.oberstufe = oberstufe;
    }

    public String getName() {
        return name;
    }

    public boolean isOberstufe() {
        return oberstufe;
    }

    public void printInfo() {
        System.out.print(name);
        if (oberstufe) {
            System.out.println(" Sek2");
        } else {
            System.out.println(" Sek1");
        }
    }
}
