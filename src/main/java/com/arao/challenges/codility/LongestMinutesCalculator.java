package com.arao.challenges.codility;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import static java.time.temporal.TemporalAdjusters.next;

/**
 * THIS SOLUTION APPROACH IS USIND DATE TO CALC MINUTES BETWEEN THEM
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

public class LongestMinutesCalculator {

    /**
     * Class that represents the meeting scheduler
     */
    public class MeetingSchedule {

        private LocalDateTime initDate;
        private LocalDateTime endDate;

        public MeetingSchedule(LocalDateTime initDate, LocalDateTime endDate) {
            this.initDate = initDate;
            this.endDate = endDate;
        }

        public LocalDateTime getInitDate() {
            return initDate;
        }
        public LocalDateTime getEndDate() {
            return endDate;
        }
    }

    /**
     * Solution to the get best amount of time in minutes to sleep given a string schedule
     *
     * @param S meeting schedule of type {@ String}
     * @return best amount of time in minutes of type {@ int}
     */
    public int solution(String S) throws Exception {

        List<Long> minutes;

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
            Collections.sort(schedulers, (o1,t1) -> o1.getInitDate().compareTo(t1.getInitDate()));

            // Get the period in minutes between meeting scheduler endDate of element N VS initDate of element N+1
            minutes = new ArrayList<>();
            for (int x=0; x<schedulers.size()-1; x++) {
                minutes.add(Math.abs(Duration.between(schedulers.get(x+1).getInitDate(), schedulers.get(x).getEndDate()).toMinutes()));
            }
        } catch (Exception e) {
            throw e;
        }

        return Collections.max(minutes).intValue();
    }

    /**
     * This method receives a schedule as String and transform into a Meeting Schedule type
     *
     * @param meetingSchedule meeting schedule as String
     * @return Meeting Schedule class
     */
    private MeetingSchedule transformSchedule(String meetingSchedule) throws Exception {
        // get day of the week
        DayOfWeek meetingDay = getDayOfWeek(meetingSchedule.split(" ")[0]);
        // get time data
        String meetTime[] = meetingSchedule.split(" ")[1].split("-");
        String meetStart[] = meetTime[0].split(":");
        String meetEnd[] = meetTime[1].split(":");
        // get time data as numeric values
        int initHour = Integer.parseInt(meetStart[0]);
        int initMinute = Integer.parseInt(meetStart[1]);
        int endHour = Integer.parseInt(meetEnd[0]);
        int endMinute = Integer.parseInt(meetEnd[1]);
        int extraMinute = 0;
        // validate rules
        if ((initHour == endHour && initMinute == endMinute)
                && (initHour != 0 && endHour != 0)
                && (initHour != 24 && endHour != 24))
            throw new Exception("start and end time is the same for " + meetingSchedule);
        // set correct hours and minutes for 24:00
        if (endHour == 24 && endMinute == 0) {
            endHour = 23;
            endMinute = 59;
            extraMinute = 1;
        }
        if (initHour == 24 && initMinute == 0) {
            initHour = 23;
            initMinute = 59;
            extraMinute = 1;
        }
        // get day of the week as a date
        LocalDateTime today = LocalDateTime.now().toLocalDate().atStartOfDay();
        var weekDay = DayOfWeek.SUNDAY.equals(meetingDay)
                ? next(meetingDay) : meetingDay.getValue()  <= today.getDayOfWeek().getValue()
                ? previousOrSame(meetingDay) : nextOrSame(meetingDay);
        // create en return meeting schedule
        return new MeetingSchedule(
                 today.with(weekDay).withHour(initHour).withMinute(initMinute).plusMinutes(extraMinute)
                ,today.with(weekDay).withHour(endHour).withMinute(endMinute).plusMinutes(extraMinute));
    }

    /**
     * Get day of week based on the three first letters of week day
     *
     * @param dayLetter day of week identifier using three letters of type {@ String}
     * @return day of week of type {@link DayOfWeek}
     */
    private DayOfWeek getDayOfWeek(String dayLetter) throws Exception {
        return switch(dayLetter.toUpperCase()) {
            case "MON" -> DayOfWeek.MONDAY;
            case "TUE" -> DayOfWeek.TUESDAY;
            case "WED" -> DayOfWeek.WEDNESDAY;
            case "THU" -> DayOfWeek.THURSDAY;
            case "FRI" -> DayOfWeek.FRIDAY;
            case "SAT" -> DayOfWeek.SATURDAY;
            default -> DayOfWeek.SUNDAY;
        };
    }
}
