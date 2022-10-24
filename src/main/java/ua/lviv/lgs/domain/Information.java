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

    public Information(Integer id, User user, Faculty faculty, int score) {
        this.id = id;
        this.user = user;
        this.faculty = faculty;
        this.score = score;
    }

    public Information(User user, Faculty faculty, int score) {
        this.user = user;
        this.faculty = faculty;
        this.score = score;
    }

    public Information() {
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

    public Faculty getFacultyId() {
        return faculty;
    }

    public void setFacultyId(Faculty faculty) {
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
