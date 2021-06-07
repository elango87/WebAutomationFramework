package extent;

public class ThreadLocalExtentReport {

    private static ThreadLocal<ExtentManager> threadLocalExtentManager = new ThreadLocal<>();

    public static ExtentManager getExtent() {
        return threadLocalExtentManager.get();
    }

    private static void setExtent(ExtentManager manager) {
        threadLocalExtentManager.set(manager);
    }

    private static void unload() {
        threadLocalExtentManager.remove();
    }
}