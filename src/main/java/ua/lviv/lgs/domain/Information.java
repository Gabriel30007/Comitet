package ua.lviv.lgs.domain;

import java.util.Objects;

public class Information {
    private Integer id;
    private Integer userId;
    private Integer facultyId;
    private int score;

    public Information(Integer id, Integer userId, Integer facultyId, int score) {
        this.id = id;
        this.userId = userId;
        this.facultyId = facultyId;
        this.score = score;
    }

    public Information(Integer userId, Integer facultyId, int score) {
        this.userId = userId;
        this.facultyId = facultyId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
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
        return score == that.score && Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(facultyId, that.facultyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, facultyId, score);
    }

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", userId=" + userId +
                ", facultyId=" + facultyId +
                ", score=" + score +
                '}';
    }
}
