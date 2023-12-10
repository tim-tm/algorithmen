package queue.kiosk;

import queue.Queue;

public class Kiosk {
    private final Queue<Schueler> sekEins;
    private final Queue<Schueler> sekZwei;

    public Kiosk() {
        this.sekEins = new Queue<>();
        this.sekZwei = new Queue<>();
    }

    public void stelleAn(Schueler schueler) {
        System.out.print("Ein Schüler hat sich angestellt: ");
        schueler.printInfo();
        if (schueler.isOberstufe()) {
            this.sekZwei.enqueue(schueler);
        } else {
            this.sekEins.enqueue(schueler);
        }
    }

    public void bedieneErsten() {
        if (!sekZwei.isEmpty()) {
            System.out.println("Schüler wird bedient: " + sekZwei.front().getName());
            sekZwei.dequeue();
        } else if (!sekEins.isEmpty()) {
            System.out.println("Schüler wird bedient: " + sekEins.front().getName());
            sekEins.dequeue();
        } else {
            System.out.println("Kein Schüler in der Schlange!");
        }
    }

    public void pausengong() {
        System.out.println("Die Pause ist vorbei, die Sek1 verlässt die Schlange!");
        if (!sekEins.isEmpty()) {
            Schueler tmp = sekEins.front();
            while (tmp != null) {
                sekEins.dequeue();
                tmp = sekEins.front();
            }
        }
    }

    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.stelleAn(new Schueler("Anton", true));
        kiosk.stelleAn(new Schueler("Berta", false));
        kiosk.stelleAn(new Schueler("Caesar", false));
        kiosk.stelleAn(new Schueler("Dora", true));
        kiosk.bedieneErsten();
        kiosk.bedieneErsten();
        kiosk.pausengong();
        kiosk.bedieneErsten();
    }
}