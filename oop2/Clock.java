/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Clock {
    private static final int MINUTES_PER_HOUR = 60;
    private static final int HOURS_PER_DAY = 24;

    private int hours;
    private int minutes;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {

        if ((h < 0) || (h >= HOURS_PER_DAY)) {
            throw new IllegalArgumentException("Hours out of bounds");
        }
        else if ((m < 0) || (m >= MINUTES_PER_HOUR)) {
            throw new IllegalArgumentException("Minutes out of bounds.");
        }
        this.hours = h;
        this.minutes = m;

    }

    public Clock(String s) {
        int h;
        int m;
        String[] array = s.split(":");
        int arrayLength = array.length;

        if (arrayLength != 2 || array[0].length() != 2 || array[1].length() != 2) {
            throw new IllegalArgumentException("Inappropriate string formatting");
        }

        try {
            h = Integer.parseInt(array[0]);
            m = Integer.parseInt(array[1]);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("String not in format HH:MM");
        }


        if ((h < 0) || (h >= HOURS_PER_DAY) || (m < 0) || (m >= MINUTES_PER_HOUR)) {
            throw new IllegalArgumentException("Inappropriate string formatting");
        }


        this.hours = h;
        this.minutes = m;

    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = this.hours >= 10 ? "" + this.hours : "0" + this.hours;
        String m = this.minutes >= 10 ? "" + this.minutes : "0" + this.minutes;
        return h + ":" + m;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hours < that.hours) {
            return true;
        }
        else if (this.hours > that.hours) {
            return false;
        }
        return (this.minutes < that.minutes);
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.minutes == MINUTES_PER_HOUR - 1 && this.hours == HOURS_PER_DAY - 1) {
            this.hours = 0;
            this.minutes = 0;
        }
        else if (this.minutes == MINUTES_PER_HOUR - 1) {
            this.hours++;
            this.minutes = 0;
        }
        else {
            this.minutes++;
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Cannot advance clock negative minutes");
        }
        int currentTimeInMinutes = this.hours * MINUTES_PER_HOUR + this.minutes;
        int adjustedTime = currentTimeInMinutes + delta;
        this.hours = (adjustedTime / MINUTES_PER_HOUR) % HOURS_PER_DAY;
        this.minutes = adjustedTime % MINUTES_PER_HOUR;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock1 = new Clock(07, 45);
        Clock clock2 = new Clock("22:45");

        System.out.println("Clock1 : " + clock1.hours + " " + clock1.minutes);
        System.out.println("Clock2 : " + clock2.hours + " " + clock2.minutes);
        System.out.println("IsEarlierThan :" + clock1.isEarlierThan(clock2));
        System.out.println(clock1);
        clock1.tic();
        System.out.println(clock1);
        System.out.println(clock2);
        clock2.toc(24 * 60);
        System.out.println(clock2);
    }
}
