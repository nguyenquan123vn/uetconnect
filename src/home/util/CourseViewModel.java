package home.util;

public class CourseViewModel {

    private String week, date, fileName;

    public CourseViewModel(String week, String date, String fileName) {
        this.week = week;
        this.date = date;
        this.fileName = fileName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
