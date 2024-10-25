/* 8. Write a program using Swings & JavaFX components that displays the calendar for the current
month. Use Prior and Next buttons to show the calendar of the previous or next month. Display the dates
in the current month in black, and the dates in the previous and next month in gray. */

package WS09;

import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.border.Border;

class MyCalendar extends JFrame {
    Calendar cal1 = new GregorianCalendar();
    Calendar cal2 = new GregorianCalendar(cal1.get(Calendar.YEAR), cal1.get(Calendar.MONTH), 1);
    CalendarPanel dc = new CalendarPanel(cal2);
    JButton previous = new JButton("Previous");
    JButton next = new JButton("Next");

    MyCalendar() {
        JPanel panel = new JPanel();
        panel.add(previous);
        panel.add(next);

        add(dc, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        next.addActionListener(e -> {
            remove(dc);
            dc = dc.moveToNextMonth();
            add(dc, BorderLayout.CENTER);
            repaint();
            revalidate();
        });

        previous.addActionListener(e -> {
            remove(dc);
            dc = dc.moveToPreviousMonth();
            add(dc, BorderLayout.CENTER);
            repaint();
            revalidate();
        });
    }

    public static void main() {
        JFrame frame = new MyCalendar();
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class CalendarPanel extends JPanel {
    Calendar calendar;
    int currentYear, currentMonth, numOfDaysInMonth, starDay, previousMonth;

    CalendarPanel(Calendar calendar) {
        this.calendar = calendar;
        setLayout(new BorderLayout());

        currentYear = calendar.get(Calendar.YEAR);
        currentMonth = calendar.get(Calendar.MONTH);
        numOfDaysInMonth = getMaximum(currentMonth);
        starDay = calendar.get(Calendar.DAY_OF_WEEK);
        previousMonth = getPreviousMonth(currentMonth);

        JLabel calendarHeader = new JLabel((currentMonth + 1) + "/" + currentYear);
        calendarHeader.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel(new GridLayout(0, 7, 0, 0));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);

        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (String day : days) {
            JLabel label = new JLabel(day, JLabel.CENTER);
            label.setBorder(border);
            panel.add(label);
        }

        int i, previousMonthDayToDisplay = getMaximum(previousMonth) - starDay + 2;
        for (i = 1; i < starDay; i++) {
            JLabel label = new JLabel(previousMonthDayToDisplay++ + "", JLabel.RIGHT);
            label.setBorder(border);
            label.setForeground(Color.LIGHT_GRAY);
            panel.add(label);
        }

        for (int j = 1; j <= numOfDaysInMonth; j++, i++) {
            JLabel label = new JLabel(j + "", JLabel.RIGHT);
            label.setBorder(border);
            panel.add(label);
        }

        for (int j = 1; i <= 42; j++, i++) {
            JLabel label = new JLabel(j + "", JLabel.RIGHT);
            label.setBorder(border);
            label.setForeground(Color.LIGHT_GRAY);
            panel.add(label);
        }

        add(calendarHeader, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
    }

    private int getPreviousMonth(int month) {
        return month == 0 ? 11 : month - 1;
    }

    private int getMaximum(int month) {
        return switch (month) {
            case 0, 2, 4, 6, 7, 9, 11 -> 31;
            case 3, 5, 8, 10 -> 30;
            case 1 -> isLeap() ? 29 : 28;
            default -> 0;
        };
    }

    private boolean isLeap() {
        return (currentYear % 4 == 0 && currentYear % 100 != 0) || currentYear % 400 == 0;
    }

    CalendarPanel moveToPreviousMonth() {
        return new CalendarPanel(new GregorianCalendar(currentYear, currentMonth - 1, 1));
    }

    CalendarPanel moveToNextMonth() {
        return new CalendarPanel(new GregorianCalendar(currentYear, currentMonth + 1, 1));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500, 200);
    }
}
