public class House {
    private IPart basement;
    private IPart[] walls = new IPart[4];
    private IPart door;
    private IPart[] windows = new IPart[4];
    private IPart roof;

    public House() {
        basement = new Basement();
        for (int i = 0; i < 4; i++) {
            walls[i] = new Wall();
        }
        door = new Door();
        for (int i = 0; i < 4; i++) {
            windows[i] = new Window();
        }
        roof = new Roof();
    }

    public boolean isBuilt() {
        return basement.isBuilt() && allWallsBuilt() && door.isBuilt() && allWindowsBuilt() && roof.isBuilt();
    }

    private boolean allWallsBuilt() {
        for (IPart wall : walls) {
            if (!wall.isBuilt()) {
                return false;
            }
        }
        return true;
    }

    private boolean allWindowsBuilt() {
        for (IPart window : windows) {
            if (!window.isBuilt()) {
                return false;
            }
        }
        return true;
    }

    public IPart getBasement() {
        return basement;
    }

    public IPart[] getWalls() {
        return walls;
    }

    public IPart getDoor() {
        return door;
    }

    public IPart[] getWindows() {
        return windows;
    }

    public IPart getRoof() {
        return roof;
    }

    public void report() {
        if (basement.isBuilt()) {
            System.out.println("Фундамент побудований.");
        }
        for (IPart wall : walls) {
            if (wall.isBuilt()) {
                System.out.println("Стіна побудована.");
            }
        }
        if (door.isBuilt()) {
            System.out.println("Двері побудовані.");
        }
        for (IPart window : windows) {
            if (window.isBuilt()) {
                System.out.println("Вікно побудовано.");
            }
        }
        if (roof.isBuilt()) {
            System.out.println("Дах побудований.");
        }
        if (isBuilt()) {
            System.out.println("Будівництво завершено.");
        }
    }
}
