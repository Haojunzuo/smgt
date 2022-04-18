package com.wbz.system.domain;


import java.sql.Timestamp;

public class Notice extends BaseEntity {

    private Long id;

    private String noticeno;

    private String title;

//    MySQL的text对应实体类的String
    private String content;

    private String publisher;

    private Timestamp noticetime;

    private String noticetype;

    private String file;

    private String urgency;

    private String status;

    private String institution;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoticeno() {
        return noticeno;
    }

    public void setNoticeno(String noticeno) {
        this.noticeno = noticeno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Timestamp getNoticetime() {
        return noticetime;
    }

    public void setNoticetime(Timestamp noticetime) {
        this.noticetime = noticetime;
    }

    public String getNoticetype() {
        return noticetype;
    }

    public void setNoticetype(String noticetype) {
        this.noticetype = noticetype;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", noticeno='" + noticeno + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", publisher='" + publisher + '\'' +
                ", noticetime=" + noticetime +
                ", noticetype='" + noticetype + '\'' +
                ", file='" + file + '\'' +
                ", urgency='" + urgency + '\'' +
                ", status='" + status + '\'' +
                ", institution='" + institution + '\'' +
                '}';
    }
}
