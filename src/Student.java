public class Student {
    private String name;
    private int rollNo;
    private int[] marks;

    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getRollNo() { return rollNo; }
    public int[] getMarks() { return marks; }

    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) total += mark;
        return total;
    }

    public double getAverage() {
        return getTotalMarks() / (double) marks.length;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else return "D";
    }
}
