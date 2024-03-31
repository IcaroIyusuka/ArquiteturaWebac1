package me.icaro.Ac1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

@RestController

@RequestMapping("/api/alunos")
public class Ac1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
