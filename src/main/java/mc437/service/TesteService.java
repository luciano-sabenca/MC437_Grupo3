package mc437.service;

import org.springframework.stereotype.Service;

@Service
public class TesteService implements TesteInterface {

	@Override
	public void helloWorld() {

		System.out.println("Bananananananan");

	}

}
