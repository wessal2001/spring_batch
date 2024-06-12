package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Player;
import org.springframework.batch.item.ItemProcessor;

public class PlayerItemProcessor implements ItemProcessor<Player,Player> {

    @Override
    public Player process(Player player) throws Exception {
        if(player.getAge()>20)
            player.setAge(player.getAge()+2);
        return player;
    }
}
