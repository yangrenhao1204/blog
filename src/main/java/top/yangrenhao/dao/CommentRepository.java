package top.yangrenhao.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import top.yangrenhao.po.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment getCommentById(Long id);

    List<Comment> findByBlogIdAndParentCommentNull(Long id, Sort sort);


}
