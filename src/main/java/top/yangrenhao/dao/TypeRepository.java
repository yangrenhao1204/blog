package top.yangrenhao.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.yangrenhao.po.Type;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Type getTypeById(Long id);

    Type findByName(String name);

    @Query("select t from t_type t")
    List<Type> findTop(Pageable pageable);

}
