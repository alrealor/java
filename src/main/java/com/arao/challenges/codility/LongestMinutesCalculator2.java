package com.arao.challenges.codility;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * THIS SOLUTION APPROACH IS CALCULATING MINUTES USING MANUAL CALCULATIONS INSTEAD OF DATES
 *
 *  James is a businessman. He is on a tight schedule this week. The week starts
 *  on Monday at 00:00 and ends on Sunday at 24:00.
 *  His schedule consists of M meetings he needs to take part in. Each of them will take place in a period of
 *  time, beginning and ending on the same day (there are no two ongoing meetings at the same time).
 *  James is very tired, thus he needs to find the longest possible time slot to sleep.
 *  In other words, he wants to find the longest period of time when there are no ongoing meetings.
 *  The sleeping break can begin and end on different days and should begin and end in the same week.
 *
 *  You are given a string containing M lines. Each line is a substring
 *  representing one meeting in the schedule, in the format "Ddd hh:mm-hh:mm".
 *
 *  "Ddd" is a three-letter abbreviation for the day of the week when the meeting
 *  takes place: "Mon" (Monday), "Tue", "Wed", "Thu", "Fri", "Sat", "Sun".
 *   "hh:mm-hh:mm" means the beginning time and the ending time of the meeting
 *  (from 00:00 to 24:00 inclusive).
 *
 *  The given times represent exact moments of time. So, there are exactly five
 *  minutes between 13:40 and 13:45.
 *
 *  For example, given a string:
 *    "Sun 10:00-20:00
 *     Fri 05:00-10:00
 *     Fri 16:30-23:50
 *     Sat 10:00-24:00
 *     Sun 01:00-04:00
 *     Sat 02:00-06:00
 *     Tue 03:30-18:15
 *     Tue 19:00-20:00
 *     Wed 04:25-15:14
 *     Wed 15:14-22:40
 *     Thu 00:00-23:59
 *     Mon 05:00-13:00
 *     Mon 15:00-21:00"
 *
 *    The longest time slot when James can sleep is 505 minutes, since James can
 *    sleep from Tuesday 20:00 to Wednesday 04:25, which gives 8 hours and 25
 *    minutes = 505 minutes.
 *
 *  Also, for a string:
 *    "Mon 01:00-23:00
 *     Tue 01:00-23:00
 *     Wed 01:00-23:00
 *     Thu 01:00-23:00
 *     Fri 01:00-23:00
 *     Sat 01:00-23:00
 *     Sun 01:00-21:00"
 *
 *  James should sleep on Sunday from 21:00 to 24:00 (180 minutes).
 *
 *  Write a function:
 *      object Solution { def solution(s: String): Int }
 *  that, given a string S representing the schedule, returns the length of the
 *  longest time slot when James can sleep (in minutes).
 *  Assume that:
 *    M is an integer within the range [1..100];
 *    Each line of the input string is in the format "Ddd hh:mm-hh:mm" and lines are separated with newline characters;
 *    There cannot be two ongoing meetings at any time;
 *    Each meeting lasts at least 1 minute.
 *    In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */
public class LongestMinutesCalculator2 {

    /**
     * Class that represents the meeting schedule
     */
    public class MeetingSchedule {
        private String dayDesc;
        private Integer dayNumber;
        private Integer startHour;
        private Integer startMinute;
        private Integer endHour;
        private Integer endMinute;

        public Integer getDayNumber() {return dayNumber;}

        public void setDayNumber(Integer dayNumber) {this.dayNumber = dayNumber;}

        public String getDayDesc() {return dayDesc;}

        public void setDayDesc(String dayDesc) {this.dayDesc = dayDesc;}

        public Integer getStartHour() {return startHour;}

        public void setStartHour(Integer startHour) {this.startHour = startHour;}

        public Integer getStartMinute() {return startMinute;}

        public void setStartMinute(Integer startMinute) {this.startMinute = startMinute;}

        public Integer getEndHour() {return endHour;}

        public void setEndHour(Integer endHour) {this.endHour = endHour;}

        public Integer getEndMinute() {return endMinute;}

        public void setEndMinute(Integer endMinute) {this.endMinute = endMinute;}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MeetingSchedule that = (MeetingSchedule) o;
            return Objects.equals(dayDesc, that.dayDesc) && Objects.equals(dayNumber, that.dayNumber) && Objects.equals(startHour, that.startHour) && Objects.equals(startMinute, that.startMinute) && Objects.equals(endHour, that.endHour) && Objects.equals(endMinute, that.endMinute);
        }

        @Override
        public int hashCode() {
            return Objects.hash(dayDesc, dayNumber, startHour, startMinute, endHour, endMinute);
        }

        @Override
        public String toString() {
            return dayDesc + " " + String.format("%02d", startHour) +":" + String.format("%02d", startMinute)
                    + "-" + String.format("%02d", endHour) + ":" + String.format("%02d", endMinute);
        }
    }

    /**
     * Solution to the get best amount of time in minutes to sleep given a string schedule
     *
     * @param S meeting schedule of type {@ String}
     * @return best amount of time in minutes of type {@ int}
     */
    public int solution(String S) throws Exception {

        List<Integer> minutes = new ArrayList<>();

        try {
            //adding edges for init and end week time
            S  = "Mon 00:00-00:00\n" + S + "Sun 24:00-24:00\n";

            // Split Strings to a map where key = weekday and value = meeting time
            String[] days = S.split("\n");

            List<MeetingSchedule> schedulers = new ArrayList<>();
            List<String> existing = new ArrayList<>();
            int counter = 0;
            for (String day: days) {
                // only get the meetings that start in different date-time
                if (!existing.contains(days[counter].split(" ")[0]+days[counter].split(" ")[1])) {
                    existing.add(days[counter].split(" ")[0]+days[counter].split(" ")[1]);
                    schedulers.add(this.transformSchedule(day));
                } else {
                    throw new Exception("There are two meetings with the same start time " + day);
                }
                counter++;
            }

            // sorting scheduler comparing init dates
            Collections.sort(schedulers, Comparator.comparing(MeetingSchedule::getDayNumber)
                    .thenComparing(MeetingSchedule::getStartHour)
                    .thenComparing(MeetingSchedule::getStartMinute));

            // Get the period in minutes between meeting scheduler endDate of element N VS initDate of element N+1
            minutes = new ArrayList<>();
            for (int x=0; x<schedulers.size()-1; x++) {
                minutes.add(calcMinutes(schedulers.get(x), schedulers.get(x+1)));
            }
        } catch (Exception e) {
            throw e;
        }

        return Collections.max(minutes).intValue();
    }

    /**
     * Method to calculate the minutes between end of last meeting and start of next meeting
     *
     * @param date0 last meeting scheduled {@ MeetingSchedule}
     * @param date1 upcoming meeting schedule {@ MeetingSchedule}
     * @return minutes between ending last meeting and start of next meeting {@ int}
     * @throws Exception
     */
    private int calcMinutes(MeetingSchedule date0, MeetingSchedule date1) throws Exception{
        // verify two meetings are not scheduled at the same
        if (date1.getStartHour() == date1.getEndHour()
                && date1.getStartMinute() == date1.getEndMinute()
                && (date1.getEndHour() != 0)
                && (date1.getEndHour() != 24))
            throw new Exception("start and end time is the same for " + date1);

        if (date0.getDayNumber() == date1.getDayNumber()) {
            return ((date1.getStartHour() - date0.getEndHour()) * 60) + (date0.getEndMinute() + date1.getStartMinute());
        } else {
            // calc hours from last meeting to the new meeting when meeting is not the same day
            // sum-up:
            // minutes from end of last meeting to end of the day
            // + minutes in case more than 1 day between meetings
            // + minutes from starting of day to next meeting
            return (date0.getEndMinute() > 0 ? ((24 - (date0.getEndHour()-1)) * 60) + date0.getEndMinute() : ((24 - date0.getEndHour()) * 60))
                    + (date1.getDayNumber() - date0.getDayNumber() > 1 ? (date1.getDayNumber() - date0.getDayNumber()) * 24 * 60 : 0)
                    + ((date1.getStartHour() * 60) + date1.getStartMinute());
        }
    }

    /**
     * This method receives a schedule as String and transform into a Meeting Schedule type
     *
     * @param meeting meeting schedule as String
     * @return Meeting Schedule class
     */
    private MeetingSchedule transformSchedule(String meeting) throws Exception {
        String meetDay  = meeting.split(" ")[0];
        // get time data
        String meetTime[] = meeting.split(" ")[1].split("-");
        String meetStart[] = meetTime[0].split(":");
        String meetEnd[] = meetTime[1].split(":");
        // create en return meeting schedule
        MeetingSchedule meetingSchedule = new MeetingSchedule();
        meetingSchedule.setDayDesc(meetDay);
        meetingSchedule.setDayNumber(this.getDayOfWeek(meetDay));
        meetingSchedule.setStartHour(Integer.parseInt(meetStart[0]));
        meetingSchedule.setStartMinute(Integer.parseInt(meetStart[1]));
        meetingSchedule.setEndHour(Integer.parseInt(meetEnd[0]));
        meetingSchedule.setEndMinute(Integer.parseInt(meetEnd[1]));
        return meetingSchedule;
    }

    /**
     * Get day of week based on the three first letters of week day
     *
     * @param dayDesc day of week identifier using three letters of type {@ String}
     * @return day of week of type {@link DayOfWeek}
     */
    private int getDayOfWeek(String dayDesc) throws Exception {
        return switch(dayDesc.toUpperCase()){
            case "MON" -> 1;
            case "TUE" -> 2;
            case "WED" -> 3;
            case "THU" -> 4;
            case "FRI" -> 5;
            case "SAT" -> 6;
            default -> 7;
        };
    }
}
