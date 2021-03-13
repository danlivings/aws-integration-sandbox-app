package com.danlivings.aws.sandbox.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue
    @Type(type = "pg-uuid")
    private UUID id;

    @Column(nullable = false)
    @CreationTimestamp
    private ZonedDateTime postedAt;

    @Column(nullable = false)
    private String author;

    @Lob
    @Column(nullable = false)
    private String text;
}
