package com.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cat_id;
    private int user_id;
    private String title;
    private String image;
    private String content;
    @Transient              //include insert post but not include show.
    private String created_up;
    @Transient
    private String updated_up;
    @Transient
    MultipartFile file;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id" ,referencedColumnName = "id" ,insertable = false,updatable = false)
    private User user; // Post(Many) -> Users(One) that many to one

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cat_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Category category;

    public Post(String title,int cat_id,String content,MultipartFile file){
        this.title = title;
        this.cat_id = cat_id;
        this.file = file;
        this.content = content;
    }

    public Post(){}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_up() {
        return created_up;
    }

    public void setCreated_up(String created_up) {
        this.created_up = created_up;
    }

    public String getUpdated_up() {
        return updated_up;
    }

    public void setUpdated_up(String updated_up) {
        this.updated_up = updated_up;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", cat_id=" + cat_id +
                ", user_id=" + user_id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", content='" + content + '\'' +
                ", created_up='" + created_up + '\'' +
                ", updated_up='" + updated_up + '\'' +
                '}';
    }
}
