package homework1.obstacle;

import homework1.participant.Participant;

public class Wall implements Obstacle{

    private float height;

    public Wall(float height) {
        this.height = height;
    }

    public boolean passObstacle(Participant participant) {
        if (participant.getMaxJumpHeight() >= this.height) {
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
