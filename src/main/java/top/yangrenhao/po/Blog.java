package top.yangrenhao.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "t_blog")
@Table
@Data
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    private String firstPicture;
    private String flag;
    private Integer views;
    private boolean appreciation;
    private boolean shareStatement;
    private boolean commentabled;
    private boolean published;
    private boolean recommend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    private String description;

    @Transient
    private List<String> tagIds;

    public void init() {
        this.tagIds = tagsToIds(this.getTags());
    }

    private List<String> tagsToIds(List<Tag> tags){
        List<String> ids = new ArrayList<>();
        if (!tags.isEmpty()){
            for(Tag t : tags){
                ids.add(Long.toString(t.getId()));
            }
        }
        return ids;
    }
}
