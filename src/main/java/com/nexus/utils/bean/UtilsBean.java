package com.nexus.utils.bean;

import com.nexus.utils.Conditional;
import com.nexus.utils.Readers;
import com.nexus.utils.Utils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UtilsBean {

    @Bean
    public Conditional conditional(){
        return new Conditional<>();
    }

    @Bean
    public Utils utils(){
        return new Utils();
    }

    @Bean
    public Readers readers(){
        return new Readers();
    }
}
