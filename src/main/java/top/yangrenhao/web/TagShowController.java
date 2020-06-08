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
import top.yangrenhao.po.Tag;
import top.yangrenhao.service.BlogService;
import top.yangrenhao.service.TagService;

import java.util.List;

/**
 * Created by limi on 2017/10/23.
 */
@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                       @PathVariable Long id, Model model) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort); // （当前页， 每页记录数， 排序方式）
        List<Tag> tags = tagService.listTagTop(10000);
        if (id == -1) {
            // id = tags.get(0).getId();
            model.addAttribute("page", blogService.listBlog(pageable));
        } else {
            model.addAttribute("page", blogService.listBlog(pageable, id));
        }
        model.addAttribute("tags", tags);
        model.addAttribute("activeId", id);
        return "tags";
    }
}