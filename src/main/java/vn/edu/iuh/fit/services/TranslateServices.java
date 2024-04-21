package vn.edu.iuh.fit.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.PluginManager;
import vn.edu.iuh.fit.core.Language;
import vn.edu.iuh.fit.core.entities.Vocabulary;

import java.util.Optional;

@Service
public class TranslateServices {

    public Optional<Vocabulary> translateFromForeignLanguage(String word) {
        return PluginManager.get(Language.class).lookupFromForeignLanguage(word);
    }
    public Optional<Vocabulary> translateFromVietnameseLanguage(String words) {
        return PluginManager.get(Language.class).lookupFromVietnameseLanguage(words);
    }
}
