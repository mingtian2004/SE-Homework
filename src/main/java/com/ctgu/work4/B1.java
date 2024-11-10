package src.main.java.com.ctgu.work4;

public class B1 {

    // 定义状态
    private enum State {
        SLEEP, TURN_OFF_POWER, TURN_ON_POWER, MAINTENANCE
    }

    private State currentState;
    private boolean hasWater;
    private int temperature;
    private boolean isBurnedOut;
    private int currentTime;  // 使用24小时制的整点表示，如23表示晚上11点，7表示早上7点

    public B1() {
        // 初始状态为休眠
        this.currentState = State.SLEEP;
        this.hasWater = true;
        this.temperature = 20;
        this.isBurnedOut = false;
    }

    // 更新水量、温度、是否损坏、时间等信息
    public void updateState(boolean hasWater, int temperature, boolean isBurnedOut, int currentTime) {
        this.hasWater = hasWater;
        this.temperature = temperature;
        this.isBurnedOut = isBurnedOut;
        this.currentTime = currentTime;

        // 根据当前状态和条件进行状态转移
        switch (currentState) {
            case SLEEP:
                if (currentTime == 7) {
                    currentState = State.TURN_OFF_POWER;
                    System.out.println("早上7点，切换到状态：关闭电源");
                }
                break;

            case TURN_OFF_POWER:
                if (!hasWater) {
                    System.out.println("无水，保持状态：关闭电源");
                } else if (temperature < 20) {
                    currentState = State.TURN_ON_POWER;
                    System.out.println("温度低于20°且有水，切换到状态：打开电源");
                } else if (currentTime == 23) {
                    currentState = State.SLEEP;
                    System.out.println("晚上11点，切换到状态：休眠");
                }
                break;

            case TURN_ON_POWER:
                if (isBurnedOut) {
                    currentState = State.MAINTENANCE;
                    System.out.println("水箱烧坏，切换到状态：维修");
                } else if (temperature >= 100) {
                    currentState = State.TURN_OFF_POWER;
                    System.out.println("温度达到100°，切换到状态：关闭电源");
                } else if (currentTime == 23) {
                    currentState = State.SLEEP;
                    System.out.println("晚上11点，切换到状态：休眠");
                }
                break;

            case MAINTENANCE:
                if (!isBurnedOut) {
                    currentState = State.TURN_OFF_POWER;
                    System.out.println("维修完成，切换到状态：关闭电源");
                }
                break;
        }
    }
    public static void main(String[] args) {
        B1 waterTank = new B1();

        // 模拟状态变化
        waterTank.updateState(true, 15, false, 7);    // 早上7点，有水，温度15度
        waterTank.updateState(true, 15, false, 12);   // 中午12点，有水，温度15度
        waterTank.updateState(true, 101, false, 12);  // 中午12点，有水，温度101度
        waterTank.updateState(true, 10, true, 12);    // 中午12点，有水，温度10度，水箱烧坏
        waterTank.updateState(true, 10, false, 23);   // 晚上11点，有水，温度10度
    }
}
