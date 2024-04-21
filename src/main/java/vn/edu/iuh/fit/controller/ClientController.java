package vn.edu.iuh.fit.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.core.entities.Vocabulary;
import vn.edu.iuh.fit.services.TranslateServices;

import java.util.Optional;

@RequestMapping("")
@Controller
@AllArgsConstructor
public class ClientController {
    private TranslateServices translateServices;

    @GetMapping("")
    public String handleOpenTranslatePage() {
        return "index";
    }

    @PostMapping("/translate")
    public String translateFromForeignLanguage(@RequestParam("word") String word, @RequestParam("source") String source, Model model) {
        System.out.println();
        source = source.toLowerCase();
        Optional<Vocabulary> vocabularyOptional;
        if (source.equals("english->vietnamese")){
            vocabularyOptional = translateServices.translateFromForeignLanguage(word);
        } else if (source.equals("vietnamese->english")){
            vocabularyOptional = translateServices.translateFromVietnameseLanguage(word);
        } else {
            model.addAttribute("message", "Chọn ngôn ngữ cần dịch");
            return "index";
        }
        if (vocabularyOptional.isPresent()) {
            model.addAttribute("vocabulary", vocabularyOptional.get());
        } else {
            model.addAttribute("message", "Không tìm thấy từ cần dịch");
        }
        return "index";
    }

}


