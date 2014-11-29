package mc437.service;

import mc437.service.Interface.TesteInterface;

import org.springframework.stereotype.Service;

@Service
public class TesteService implements TesteInterface {

	@Override
	public void helloWorld() {

		System.out.println("Bananananananan");

	}

}
