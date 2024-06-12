package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Player;
import com.example.technomakers.springbatch.exercice.model.Student;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class PlayerItemReader extends FlatFileItemReader<Player> {
    public PlayerItemReader() {
        setResource(new ClassPathResource("players.csv"));
        setLinesToSkip(1);
        setLineMapper(new DefaultLineMapper<Player>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("name","team","position","height","weight","age"
                );
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Player>() {{
                setTargetType(Player.class);
            }});
        }});
    }
}
