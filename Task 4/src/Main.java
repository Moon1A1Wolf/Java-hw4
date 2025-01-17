public class Main {
    public static void main(String[] args) {
        House house = new House();

        Worker worker1 = new Worker(new IPart[] { house.getBasement(), house.getWalls()[0], house.getWalls()[1], house.getWalls()[2], house.getWalls()[3], house.getDoor(), house.getWindows()[0], house.getWindows()[1], house.getWindows()[2], house.getWindows()[3], house.getRoof() });

        TeamLeader leader = new TeamLeader(house);

        Team team = new Team(new IWorker[] { worker1, leader });

        team.startWork();
    }
}