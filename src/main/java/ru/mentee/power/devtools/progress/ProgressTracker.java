package ru.mentee.power.devtools.progress;

import org.w3c.dom.ls.LSOutput;

public class ProgressTracker {

    /**
     * Вычисляет суммарный прогресс группы mentee.
     *
     * @param mentees массив mentee
     * @return строка с информацией о суммарном прогрессе (пройдено/осталось уроков)
     */
    public String calculateTotalProgress(Mentee[] mentees) {
        // TODO: Реализовать логику подсчёта суммарного прогресса с использованием цикла while
        if(mentees.length > 0){
            //Инициализация аккумуляторов
            int totalCompleted = 0, totalTotal = 0, index = 0;
            while(index < mentees.length){
                totalCompleted += mentees[index].completedLessons();
                totalTotal += mentees[index].totalLessons();
                index++;
            }
            int totalRemaining = totalTotal - totalCompleted;
            return("Суммарно: пройдено " + totalCompleted + " из " + totalTotal + " уроков, осталось " + totalRemaining + " уроков");
        }
        throw new UnsupportedOperationException("Метод calculateTotalProgress ещё не реализован");
    }

    public static void main(String[] args) {
        ProgressTracker tracker = new ProgressTracker();

        // Создаём массив mentee (продолжение DVT-2: добавляем прогресс к личной карточке)
        Mentee[] mentees = {
                new Mentee("Иван", "Москва", "Backend разработка", 5, 12),
                new Mentee("Мария", "Санкт-Петербург", "Fullstack", 8, 12),
                new Mentee("Пётр", "Казань", "Java Backend", 12, 12)
        };

        String progress = tracker.calculateTotalProgress(mentees);
        System.out.println(progress);
    }
}