package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="posts")
public class Posts implements Serializable {
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=16, nullable=false)
    private String title;

    @Column()
    private String content;

    @DateTimeFormat(pattern = "yyy-MM-dd HH:mm:ss")
    private Date create_time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return create_time;
    }

    public void setDate(Date dateTime) {
        create_time = dateTime;
    }

    public Posts(
        Long id,
        String title,
        String content,
        Date create_time
    ) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.create_time = create_time;
    }
}
