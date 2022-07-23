package fadet.newPostLink.web;

import fadet.newPostLink.domain.Code;
import fadet.newPostLink.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CodeController {

    @Autowired
    CodeService codeService;

    @GetMapping("/")
    public String input(Model model){
        model.addAttribute("form", new InputForm());
        return "input";
    }

    //@ModelAttribute 에서 @RequestBody 변경
    @PostMapping(value = "/")
    public String postCodeJson(@RequestBody InputForm form){
        Code code = new Code(form.getAllCode(), form.getTitleHtmlKeyword(), form.getIndexHtmlKeyword());

        return "redirect:/valid";
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postCodeParam(@ModelAttribute InputForm form){
        Code code = new Code(form.getAllCode(), form.getTitleHtmlKeyword(), form.getIndexHtmlKeyword());

        return "redirect:/valid";
    }

    @GetMapping("/valid")
    public String valid(Model model) {
        Code code = codeService.findLastOne();

        ValidForm validForm = new ValidForm();
        validForm.setAllCode(code.getAllCode());
        validForm.setTitleHtmlKeyword(code.getTitleHtmlKeyword());
        validForm.setIndexHtmlKeyword(code.getIndexHtmlKeyword());

        model.addAttribute("validForm", validForm);
        model.addAttribute("code", code);
        model.addAttribute("titleNum", code.getTitleList().size());

        return "valid";
    }
}
