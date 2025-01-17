public class Worker implements IWorker {
    private IPart[] partsToBuild;

    public Worker(IPart[] partsToBuild) {
        this.partsToBuild = partsToBuild;
    }

    @Override
    public void work() {
        for (IPart part : partsToBuild) {
            if (!part.isBuilt()) {
                part.build();
                return;
            }
        }
    }
}