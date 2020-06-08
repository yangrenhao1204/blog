package top.yangrenhao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import top.yangrenhao.po.Type;
import top.yangrenhao.service.BlogService;
import top.yangrenhao.service.TypeService;
import top.yangrenhao.vo.BlogQuery;

import java.util.List;

@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                        @PathVariable Long id, Model model){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort); // （当前页， 每页记录数， 排序方式）
        List<Type> types = typeService.listTypeTop(10000);
        if (id == -1) {
            // id = types.get(0).getId();
            model.addAttribute("page", blogService.listBlog(pageable));
        } else {
            BlogQuery blogQuery = new BlogQuery();
            blogQuery.setTypeId(id);
            model.addAttribute("page", blogService.listBlog(pageable, blogQuery));
        }
        model.addAttribute("types", types);
        model.addAttribute("activeId", id);
        return "types";
    }

}
