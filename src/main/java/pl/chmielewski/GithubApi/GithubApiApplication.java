package pl.chmielewski.GithubApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class GithubApiApplication {
	public static void main(String[] args){
		SpringApplication.run(GithubApiApplication.class, args);
	}

//	@Bean
//	public Docket get(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.paths(PathSelectors.ant("/api/**"))
//				.build();
//	}
}
