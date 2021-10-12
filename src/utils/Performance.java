package utils;

public class Performance {
    private static long mStartMem = 0;
    private static Runtime mRun = Runtime.getRuntime();

    public static void startMem() {
        mRun.gc();
        mStartMem = mRun.freeMemory();
    }

    public static void endMem() {
        long l = mStartMem - mRun.freeMemory();
        System.out.println("内存消耗：" + l/1024d/1024d+"M");
    }
}
