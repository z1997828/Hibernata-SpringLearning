package ch01.ioc._02_anno.model.impl;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Component;
import ch01.ioc._02_anno.model.*;

@Component
public class Master implements IMaster {
	IPet pet;

	@Autowired
	@Qualifier("dog")
	public void setPet(IPet pet) {
		this.pet = pet;
	}

	public void keepPet() {
		pet.play();
	}
}
