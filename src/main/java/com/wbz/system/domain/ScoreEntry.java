package com.wbz.system.domain;

public class ScoreEntry {
    private Integer id;
    private String semester;
    private String start;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "ScoreEntry{" +
                "id=" + id +
                ", semester='" + semester + '\'' +
                ", start='" + start + '\'' +
                '}';
    }
}
