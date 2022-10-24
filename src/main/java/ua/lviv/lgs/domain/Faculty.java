package ua.lviv.lgs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "mathScore")
    private int mathScore;
    @Column(name = "historyScore")
    private int historyScore;
    @Column(name = "englishScore")
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
