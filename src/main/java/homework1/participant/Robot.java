package homework1.participant;

public class Robot implements Participant{

    private final String model; //Имя участника
    private final int maxRunLength; //Максимальное расстояние, которое может пробежать участник
    private int powerRunLength; //Остаток сил участника на бег
    private final float maxJumpHeight; //Максимальная высота, на которую может прыгнуть участник
    private float powerJumpHeight;  //Остаток сил участника на прыжок

    public Robot(String model, int maxRunLength, float maxJumpHeight) {
        this.model = model;
        this.maxRunLength = maxRunLength;
        this.powerRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
        this.powerJumpHeight = maxJumpHeight;
    }

    /**
     * Обновляем силы на бег
     */
    @Override
    public void newPowerRunLength() {
        powerRunLength = maxRunLength;
    }

    /**
     * Обновляем силы на прыжок
     */
    @Override
    public void newPowerJumpHeight() {
        powerJumpHeight = maxJumpHeight;
    }

    /**
     * Участник пытается пробежать рассотяние. После этого его силы убавляются.
     * @param length - расстояние, на которое убавляем силы
     */
    @Override
    public boolean reducePowerRunLength(int length) {
        if (powerRunLength >= length) {
            powerRunLength -= length;
            return true;
        } else {
            powerRunLength = 0;
            return false;
        }
    }

    /**
     * Участник пытается совершить прыжек, если у него хватает сил. После совершения прыжка силы участника убавляются на 0.2 единицы
     * @param height - высота препятствия
     * @return
     */
    @Override
    public boolean reducePowerJumpHeight(float height) {
        if (powerJumpHeight >= height) {
            powerJumpHeight = (powerJumpHeight >= 0.2f) ? (powerJumpHeight - 0.2f) : 0;
            return true;
        } else {
            powerJumpHeight = 0;
            return false;
        }
    }

    @Override
    public String toString() {
        return "Robot " + model;
    }
}
