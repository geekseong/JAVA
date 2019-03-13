package com.jpa.Webservice.Web;

import com.jpa.Webservice.Service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model){

        /*
            handlebars-spring-boot-start 의 지원 덕분에 파일의 앞뒤에 자동으로 path가 붙는다
            (prefix: src/main/resources/templates, suffix: .hbs)
         */
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
