public class TeamLeader implements IWorker {
    private House house;

    public TeamLeader(House house) {
        this.house = house;
    }

    @Override
    public void work() {
        house.report();
    }

    public House getHouse() {
        return house;
    }
}