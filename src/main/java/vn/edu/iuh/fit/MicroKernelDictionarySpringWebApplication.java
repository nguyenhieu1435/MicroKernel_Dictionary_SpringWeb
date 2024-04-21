package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vn.edu.iuh.fit.EnglishModule.EnglishLanguage;
import vn.edu.iuh.fit.core.Language;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

@SpringBootApplication
public class MicroKernelDictionarySpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroKernelDictionarySpringWebApplication.class, args);

		try {
			Properties properties = new Properties();
			String path = new File("src/main/resources/application.properties").getAbsolutePath();
			properties.load(new FileReader(path));
			properties.forEach((key, value) -> {
				if (value.toString().toLowerCase().contains("jar")){
					System.out.println("The value " + value);
					PluginManager.loadPlugin(value.toString());
					System.out.println( PluginManager.get(Language.class).sayHello("Some people " + key));
				}

			});
//			PluginManager.get(Language.class).lookupFromVietnameseLanguage("hello");

			PluginManager.printHashMap();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
