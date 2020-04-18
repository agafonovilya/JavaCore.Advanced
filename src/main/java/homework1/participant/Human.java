package homework1.participant;

public class Human implements Participant {

    private String name;
    private int maxRunLength;
    private int powerRunLength;
    private float maxJumpHeight;
    private float powerJumpHeight;

    public Human(String name, int maxRunLength, float maxJumpHeight) {
        this.name = name;
        this.maxRunLength = maxRunLength;
        this.powerRunLength = maxRunLength;
        this.maxJumpHeight = maxJumpHeight;
        this.powerJumpHeight = maxJumpHeight;

    }

    @Override
    public int getMaxRunLength() {
        return maxRunLength;
    }

    @Override
    public float getMaxJumpHeight() {
        return maxJumpHeight;
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
     * Убавляем силы на бег
     * @param length - расстояние, на которое убавляем силы
     */
    @Override
    public void reducePowerRunLength(int length) {
        powerRunLength -= length;
    }

    /**
     * Убавляем силы на прыжок на 0.2 метра
     */
    @Override
    public void reducePowerJumpHeight() {
        if (powerJumpHeight >= 0.2f) {
            powerJumpHeight -= 0.2f;
        }
    }

    @Override
    public int getPowerRunLength() {
        return powerRunLength;
    }

    @Override
    public float getPowerJumpHeight() {
        return powerJumpHeight;
    }

    @Override
    public String toString() {
        return "Human " + name;
    }
}
