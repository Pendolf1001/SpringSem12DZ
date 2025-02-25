package com.example.Sem12DZ.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {


    @Bean
    public MessageChannel textInChanel(){
        return new DirectChannel();
    }


    @Bean
    public MessageChannel fileWriterChanel(){
        return new DirectChannel();
    }

    @Bean
    @Transformer(inputChannel = "textInChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<String, String> mainTransformer(){
        return text->text;
    }


    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler(){
        FileWritingMessageHandler handler=new FileWritingMessageHandler(new File("D:/обучение/Spring/Семинар 12/files"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }


}
