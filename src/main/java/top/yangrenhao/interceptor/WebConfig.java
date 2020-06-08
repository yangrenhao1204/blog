package top.yangrenhao.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PostInterceptor())
                .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin")
//                .excludePathPatterns("/admin/index")
//                .excludePathPatterns("/admin/types")
//                .excludePathPatterns("/admin/types/**/input")
//                .excludePathPatterns("/admin/types/input")
//                .excludePathPatterns("/admin/tags")
//                .excludePathPatterns("/admin/tags/input")
//                .excludePathPatterns("/admin/tags/**/input")
//                .excludePathPatterns("/admin/blogs")
//                .excludePathPatterns("/admin/blogs/input")
//                .excludePathPatterns("/admin/blogs/**/input")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/register")
                .excludePathPatterns("/admin/blogs/search");
        registry.addInterceptor(new GetInterceptor())
                .addPathPatterns("/admin/**/delete/**");
    }


//    @Override
//    public void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index").setViewName("index");
//        registry.addViewController("/blog").setViewName("blog");
//        registry.addViewController("/types").setViewName("types");
//        registry.addViewController("/tags").setViewName("tags");
//        registry.addViewController("/archives").setViewName("archives");
//        registry.addViewController("/about").setViewName("about");
//        registry.addViewController("/admin/index").setViewName("admin/index");
//        registry.addViewController("/admin/blogs").setViewName("admin/blogs");
//        registry.addViewController("/admin/blogs-input").setViewName("admin/blogs-input");
//        registry.addViewController("/admin/types").setViewName("admin/types");
//        registry.addViewController("/admin/types-input").setViewName("admin/types-input");
//        registry.addViewController("/admin/tags").setViewName("admin/tags");
//        registry.addViewController("/admin/tags-input").setViewName("admin/tags-input");
//        registry.addViewController("/admin/login").setViewName("admin/login");
//        registry.addViewController("/admin/register").setViewName("admin/register");
//    }
}
