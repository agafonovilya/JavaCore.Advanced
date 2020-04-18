package homework1;

import homework1.obstacle.Obstacle;
import homework1.participant.Participant;

import java.util.ArrayList;

public class Competition {
    private Obstacle[] obstacles;
    private Participant[] participants;
    private ArrayList lastWinnerParticipants = new ArrayList();
    private ArrayList stageParticipants = new ArrayList();
    private ArrayList newStageParticipant = new ArrayList();
   // private ArrayList allStageWinners = new ArrayList();
    private Participant[][] allStageWinners;

    public Competition() {
    }

    public void setParticipants(Participant... participants) {
        this.participants = participants;
    }

    public void setObstacles(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void startCompetition(){
        System.out.println("Начинаем соревнования!");
        System.out.println();

        allStageWinners = new Participant[obstacles.length][participants.length]; //инициализируем массив

        for (int i = 0; i < participants.length; i++) {     //Передаем всех участников на нулевой этап(старт)
            allStageWinners[0][i] = participants[i];
        }

        int stage = -1;
        int countStageWinners = 0;
        int stageLength = participants.length;

        for (Obstacle obstacle: obstacles) {
            stage++;
            System.out.println("Препятствие "+ (stage + 1) + " " + obstacle);

            countStageWinners = 0;
            for (int i = 0; i < stageLength; i++) {
                if ((allStageWinners[stage][i] != null) && obstacle.passObstacle(allStageWinners[stage][i])) {
                    allStageWinners[stage + 1][countStageWinners] = allStageWinners[stage][i];
                    countStageWinners++;
                } else {
                    System.out.println("Участник " + allStageWinners[stage][i] + " выбывает из соревнования ");
                }
            }
            stageLength = countStageWinners;
            System.out.println();

            if(countStageWinners == 0) {
                System.out.println("Соревнования окончено!");
                System.out.println("Победители: ");
                for (int i = 0; i < allStageWinners[stage].length; i++) {
                    if((allStageWinners[stage][i] != null)) {
                        System.out.println(allStageWinners[stage][i]);
                    }
                }
                return;
            }
        }
    }
}
