package vn.edu.iuh.fit.EnglishModule;
import vn.edu.iuh.fit.core.Language;
import vn.edu.iuh.fit.core.entities.Type;
import vn.edu.iuh.fit.core.entities.Vocabulary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

public class EnglishLanguage implements Language{
    private final String anhVietDictionaryDataPath = "data/anhviet109K.txt";
    private final String vietAnhDictionaryDataPath = "data/vietanh.txt";

    private TreeMap<String, Vocabulary> anhVietDictionary;
    private TreeMap<String, Vocabulary> vietAnhDictionary;


    @Override
    public Optional<Vocabulary> lookupFromForeignLanguage(String word) {
        if (anhVietDictionary == null){
            anhVietDictionary = new TreeMap<>();
            handleReadDataFile(anhVietDictionary, anhVietDictionaryDataPath);
        }
        return lookupFromDictionary(anhVietDictionary, word);
    }
    private Optional<Vocabulary> lookupFromDictionary(TreeMap<String, Vocabulary> dictionary, String word){
        Vocabulary vocabulary = dictionary.get(word);
        System.out.println("Vocabulary: " + vocabulary);
        return vocabulary == null ? Optional.empty() : Optional.of(vocabulary);
    }
    @Override
    public Optional<Vocabulary> lookupFromVietnameseLanguage(String words) {
        if (vietAnhDictionary == null){
            vietAnhDictionary = new TreeMap<>();
            handleReadDataFile(vietAnhDictionary, vietAnhDictionaryDataPath);
        }
        return lookupFromDictionary(vietAnhDictionary, words);
    }

    private void handleReadDataFile(TreeMap<String, Vocabulary> dictionary, String filePath){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            int i = 0;
            int j = 0;
            Vocabulary vocabulary = new Vocabulary();
            String word = "";
            Type type = new Type();
            while ((line = reader.readLine()) != null){
                if (line.contains("@")){
                    if (i != 0){
                        vocabulary.getDestination().add(type);
                        dictionary.put(word.trim(), vocabulary);
                        vocabulary = new Vocabulary();
                        type = new Type();
                    } else {
                        i++;
                    }
                    int startIndexOfSlash = line.indexOf("/");
                    int lastIndexOfSlash = line.lastIndexOf("/");
                    if (startIndexOfSlash != -1){
                        word = line.substring(1, startIndexOfSlash);
                    } else {
                        word = line.substring(1);
                    }
                    if (startIndexOfSlash != -1 && startIndexOfSlash != lastIndexOfSlash){
                        String phoneticTranscription = line.substring(startIndexOfSlash, lastIndexOfSlash + 1);
                        vocabulary.setPhoneticTranscription(phoneticTranscription);
                    }
                    vocabulary.setSource(word.trim());
                } else if (line.contains("*")){
                    if (type.getTypeName() != null){{
                        vocabulary.getDestination().add(type);
                        type = new Type();
                    }}


                    String typeName = line.substring(1);
                    type.setTypeName(typeName.trim());
                } else if (line.contains("-")){
                    String meaning = line.substring(1);
                    type.getMeanings().add(meaning.trim());
                } else if (line.contains("=")){
                    String example = line.substring(1);
                    type.getExample().add(example.trim());
                }

            }
            if (!word.isEmpty()){
                vocabulary.getDestination().add(type);
                dictionary.put(word, vocabulary);
            }
//            System.out.println("End of file");
        } catch (IOException e){
            System.err.println("Error reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }
    @Override
    public String name() {
        return "English";
    }


}
