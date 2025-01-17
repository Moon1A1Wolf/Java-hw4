public class Team {
    private IWorker[] workers;

    public Team(IWorker[] workers) {
        this.workers = workers;
    }

    public void startWork() {
        while (!allPartsBuilt()) {
            for (IWorker worker : workers) {
                worker.work();
                System.out.println();
            }
        }
    }

    private boolean allPartsBuilt() {
        House house = null;
        for (IWorker worker : workers) {
            if (worker instanceof TeamLeader) {
                house = ((TeamLeader) worker).getHouse();
                break;
            }
        }

        if (house != null) {
            return house.isBuilt(); 
        }
        return false;
    }
}
