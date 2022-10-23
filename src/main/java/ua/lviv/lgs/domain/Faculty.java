package ua.lviv.lgs.domain;

import java.util.Objects;

public class Faculty {
    private Integer id;
    private String name;
    private int mathScore;
    private int historyScore;
    private int englishScore;

    public Faculty(String name, int mathScore, int historyScore, int englishScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.historyScore = historyScore;
        this.englishScore = englishScore;
    }

    public Faculty() {
    }

    public Faculty(Integer id, String name, int mathScore, int historyScore, int englishScore) {
        this.id = id;
        this.name = name;
        this.mathScore = mathScore;
        this.historyScore = historyScore;
        this.englishScore = englishScore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getHistoryScore() {
        return historyScore;
    }

    public void setHistoryScore(int historyScore) {
        this.historyScore = historyScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return mathScore == faculty.mathScore && historyScore == faculty.historyScore && englishScore == faculty.englishScore && id.equals(faculty.id) && Objects.equals(name, faculty.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, mathScore, historyScore, englishScore);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mathScore=" + mathScore +
                ", historyScore=" + historyScore +
                ", englishScore=" + englishScore +
                '}';
    }
}
