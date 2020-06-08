package top.yangrenhao.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "t_type")
@Table
@Data
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "类别名称不能为空")
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}
