package vn.edu.iuh.fit.core;

import vn.edu.iuh.fit.core.entities.Vocabulary;

import java.util.Optional;

public interface Language extends Plugin {
    String sayHello(String name);

    Optional<Vocabulary> lookupFromForeignLanguage(String word);

    Optional<Vocabulary> lookupFromVietnameseLanguage(String words);

}
