package homework1.obstacle;

import homework1.participant.Participant;

public class Wall implements Obstacle{

    private final float height; //Высота стены

    public Wall(float height) {
        this.height = height;
    }

    /**
     * Метод преодоления препятствия
     * @param participant - участник соревнования
     * @return
     */
    public boolean passObstacle(Participant participant) {
        if (participant.reducePowerJumpHeight(this.height)) {
            System.out.println("Участник " + participant + " перепрыгнул через стену высотой " + this.height);
            return true;
        } else {
            System.out.println("Участник " + participant + " НЕ перепрыгнул через стену высотой " + this.height );
            return false;
        }

    }

    @Override
    public String toString() {
        return "Wall " + "height " + height;
    }
}
