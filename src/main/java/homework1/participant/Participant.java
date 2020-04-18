package homework1.participant;

public interface Participant {

    void newPowerRunLength(); //Обновляем силы участника на бег до его максимальных сил
    void newPowerJumpHeight(); //Обновляем силы участника на бег до его максимальных сил

    boolean reducePowerRunLength(int length); //Уменьшаем силы участника на бег
    boolean reducePowerJumpHeight(float height); //Уменьшаем силы участника на прыжок.

}