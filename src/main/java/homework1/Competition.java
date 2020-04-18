package homework1;

import homework1.obstacle.Obstacle;
import homework1.participant.Participant;

import java.util.ArrayList;

public class Competition {
    private Obstacle[] obstacles; //массив препятствий
    private Participant[] participants; //массив участников

    public Competition() {
    }

    public void setParticipants(Participant... participants) {
        this.participants = participants;
    }

    public void setObstacles(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    /**
     * Метод начинает новое соревнование.
     */
    public void startCompetition(){
        int stage = 0; //переменной этап устанавливаем значение -1, т.к. в следущем цикле оно инкрементируется.
        int countStageWinners = 0; // Счетчик победителей текущего этапа
        int stageLength = participants.length; //Кол-во участников текущего этапа
        Participant[][] allStageWinners = new Participant[obstacles.length + 1][participants.length]; //инициализируем массив турнирной таблицы

        System.out.println("Начинаем соревнования!");
        System.out.println();

        for (int i = 0; i < participants.length; i++) {     //Передаем всех участников на нулевой этап(старт) allStageWinners[0]
            allStageWinners[0][i] = participants[i];
        }

        for (Obstacle obstacle: obstacles) { //Проходим по массиву препятствий
            System.out.println("Препятствие "+ (stage + 1) + " " + obstacle); //Выводим информацию о препятствии в консоль

            countStageWinners = 0; //Обнуляем счетчик победителей перед началом этапа
            for (int i = 0; i < stageLength; i++) { // проходим по массиву участников текущего этапа
                if (obstacle.passObstacle(allStageWinners[stage][i])) { //метод прохождения препятствия
                    allStageWinners[stage + 1][countStageWinners] = allStageWinners[stage][i];  //если участник прошел препятствие,
                                                                                                // то перерходит на следующий этап
                    countStageWinners++; //инкрементируем счетчик победителей
                } else {
                    System.out.println("Участник " + allStageWinners[stage][i] + " выбывает из соревнования ");
                }
            }

            stageLength = countStageWinners; //Предаем победителей на следующий этап
            stage++; //Переходим на следующий этап соревнования
            System.out.println();

            if(countStageWinners == 0) { //Проверяем есть ли победители в текущем этапе
                System.out.println("Соревнования окончено!");
                System.out.println("Победители: ");
                for (int i = 0; i < allStageWinners[stage-1].length; i++) {
                    if((allStageWinners[stage-1][i] != null)) {
                        System.out.println(allStageWinners[stage-1][i]);
                    }
                }
                return; //если победителей нет, то прерываем соревнование
            }

            if(stage == allStageWinners.length - 1) {   //Если это было последнее препятствие в соревновании, то выводим победителей
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
