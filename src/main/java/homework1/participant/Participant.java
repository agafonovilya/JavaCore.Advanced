package homework1.participant;

public interface Participant {

    int getMaxRunLength();
    float getMaxJumpHeight();

    void newPowerRunLength();
    void newPowerJumpHeight();

    void reducePowerRunLength(int length);
    void reducePowerJumpHeight();

    int getPowerRunLength();
    float getPowerJumpHeight();

}