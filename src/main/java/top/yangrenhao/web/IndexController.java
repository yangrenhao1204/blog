package top.yangrenhao.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.yangrenhao.service.BlogService;
import top.yangrenhao.service.TagService;
import top.yangrenhao.service.TypeService;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping(value = {"", "/", "index"})
    public String index(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                        Model model){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNumber - 1, 4, sort); // （当前页， 每页记录数， 排序方式）
        model.addAttribute("page", blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("recommendBlogs",blogService.listRecommendBlogTop(8));
        return "index";
    }

    @PostMapping("/search")
    public String searchByPost(@RequestParam String query,
                               @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                               Model model){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort); // （当前页， 每页记录数， 排序方式）
        model.addAttribute("page", blogService.listBlog(pageable, "%"+query+"%"));
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/search")
    public String searchByGet(@RequestParam(value = "query", defaultValue = "") String query,
                              @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
                              Model model){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort); // （当前页， 每页记录数， 排序方式）
        if (!"".equals(query)){
            model.addAttribute("page", blogService.listBlog(pageable, "%"+query+"%"));
        } else {
            model.addAttribute("page", blogService.listBlog(pageable));
        }
        model.addAttribute("query", query);
        return "search";
    }

    @GetMapping("/blogs/{id}")
    public String blogs(@PathVariable Long id, Model model){
        model.addAttribute("blog", blogService.getAndConvert(id));
        return "blog";
    }

    @GetMapping("/aside/newblog")
    public String newblogs(Model model) {
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(6));
        return "_blogFragments::newblogList";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
