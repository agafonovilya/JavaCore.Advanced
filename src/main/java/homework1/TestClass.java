package homework1;

import homework1.obstacle.Obstacle;
import homework1.obstacle.RunningTrack;
import homework1.obstacle.Wall;
import homework1.participant.Cat;
import homework1.participant.Human;
import homework1.participant.Participant;
import homework1.participant.Robot;

public class TestClass {
    public static void main(String[] args) {



        Participant[] players = new Participant[6];
        players[0]  = new Cat("Barsik", 100, 2.1f);
        players[1] = new Cat("Mudakot",150, 2.5f );
        players[2] = new Human("Olga", 500, 1.2f);
        players[3] = new Human("Ivan", 1000, 1.5f);
        players[4] = new Robot("T-500", 2000, 0.5f);
        players[5] = new Robot("T-1000", 3000, 5.5f);

        Obstacle[] obstacles = new Obstacle[8];
        obstacles[0] = new RunningTrack(10);
        obstacles[1] = new Wall(0.3f);
        obstacles[2] = new RunningTrack(90);
        obstacles[3] = new Wall(1f);
        obstacles[4] = new RunningTrack(140);
        obstacles[5] = new Wall(1.4f);
        obstacles[6] = new RunningTrack(900);
        obstacles[7] = new Wall(10f);

        Competition competition = new Competition();
        competition.setObstacles(obstacles);
        competition.setParticipants(players);

        competition.startCompetition();



    }
}
