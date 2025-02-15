package com.example.Sem12DZ.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;


@MessagingGateway(defaultRequestChannel = "textInChanel")
public interface FileGateaway {



    public void writeToFile(@Header(FileHeaders.FILENAME) String filename, String data);
}
