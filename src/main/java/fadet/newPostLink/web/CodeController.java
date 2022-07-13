package fadet.newPostLink.web;

import fadet.newPostLink.domain.Code;
import fadet.newPostLink.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CodeController {

    @Autowired
    CodeService codeService;

    @GetMapping("/")
    public String input(Model model){
        model.addAttribute("form", new InputForm());
        return "input";
    }

    @PostMapping("/")
    public String postCode(@RequestBody InputForm form){
        Code code = new Code(form.getAllCode(), form.getTitleHtmlKeyword(), form.getIndexHtmlKeyword());

        Code savedCode = codeService.saveCode(code);

        return "redirect:/valid/"+savedCode.getId();
    }
}
