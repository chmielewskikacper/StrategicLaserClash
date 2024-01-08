package service;

import entity.Gamer;
import org.springframework.stereotype.Service;
import repository.GamerRepository;

@Service
public class GamerService {

    private final GamerRepository gamerRepository;

    public GamerService(GamerRepository gamerRepository) {
        this.gamerRepository = gamerRepository;
    }
}
