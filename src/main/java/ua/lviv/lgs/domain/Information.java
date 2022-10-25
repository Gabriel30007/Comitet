package ua.lviv.lgs.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;
@Entity
@Table(name = "information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    private Faculty faculty;
    @Column(name = "score")
    private int score;
    @Column(name = "mathScore")
    private int mathScore;
    @Column(name = "historyScore")
    private int historyScore;
    @Column(name = "englishScore")
    private int englishScore;


    public Information(Integer id, User user, Faculty faculty, int score, int mathScore, int historyScore, int englishScore) {
        this.id = id;
        this.user = user;
        this.faculty = faculty;
        this.score = score;
        this.mathScore = mathScore;
        this.historyScore = historyScore;
        this.englishScore = englishScore;
    }

    public Information() {
    }

    public Information(User user, Faculty faculty, int score, int mathScore, int historyScore, int englishScore) {
        this.user = user;
        this.faculty = faculty;
        this.score = score;
        this.mathScore = mathScore;
        this.historyScore = historyScore;
        this.englishScore = englishScore;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Information that = (Information) o;
        return score == that.score && Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(faculty, that.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, faculty, score);
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", user=" + user +
                ", faculty=" + faculty +
                ", score=" + score +
                '}';
    }
}
