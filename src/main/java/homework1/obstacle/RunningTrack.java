package homework1.obstacle;

import homework1.participant.Participant;

public class RunningTrack implements Obstacle{

    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    public boolean passObstacle(Participant participant) {
        if (participant.getMaxRunLength() >= this.length) {

            System.out.println("Участник " + participant + " пробежал дистанцию " + this.length);
            return true;
        } else {
            System.out.println("Участник " + participant + " НЕ пробежал дистанцию " + this.length );
            return false;
        }

    }

    @Override
    public String toString() {
        return "RunningTrack " + "length " + length;
    }
}
