package src.main.java.com.ctgu.work4;

public class B2 {


        private enum State {
            READ, COMPARE_PASSWORD, FUNCTION_SELECTION, LOCKED
        }

        private State currentState = State.READ;
        private final String correctPassword = "1234"; // 假设正确密码是 "1234"
        private int retryCount = 0;
        private final int maxRetryCount = 3;
        private long startTime;
        private final int timeoutSeconds = 120;

        public B2() {
            this.startTime = System.currentTimeMillis();
        }

        public void inputPassword(String inputPassword) {
            while (true) {
                switch (currentState) {
                    case READ:
                        if (isTimeout()) {
                            System.out.println("超时，请重新开始");
                            reset();
                            break;
                        }
                        System.out.println("请输入密码：");
                        currentState = State.COMPARE_PASSWORD;
                        break;

                    case COMPARE_PASSWORD:
                        if (inputPassword.equals(correctPassword)) {
                            System.out.println("密码正确，进入系统功能选择");
                            currentState = State.FUNCTION_SELECTION;
                        } else {
                            retryCount++;
                            if (retryCount > maxRetryCount) {
                                System.out.println("重试次数过多，系统已锁定");
                                currentState = State.LOCKED;
                            } else {
                                System.out.println("密码错误，请重新输入。剩余重试次数：" + (maxRetryCount - retryCount));
                                currentState = State.READ;
                            }
                        }
                        break;

                    case FUNCTION_SELECTION:
                        System.out.println("进入系统功能选择");
                        // 这里可以实现系统功能选择的逻辑
                        return;

                    case LOCKED:
                        System.out.println("系统已锁定，请稍后再试");
                        return;

                    default:
                        throw new IllegalStateException("未知状态: " + currentState);
                }
            }
        }

        private boolean isTimeout() {
            long currentTime = System.currentTimeMillis();
            return (currentTime - startTime) / 1000 > timeoutSeconds;
        }

        private void reset() {
            currentState = State.READ;
            retryCount = 0;
            startTime = System.currentTimeMillis();
        }

        public static void main(String[] args) {
            B2 machine = new B2();
            machine.inputPassword("123");  // 测试密码输入
            machine.inputPassword("1245"); // 测试密码输入
            machine.inputPassword("1234"); // 输入正确密码
        }




}
