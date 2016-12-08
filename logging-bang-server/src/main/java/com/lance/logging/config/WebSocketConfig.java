package com.lance.logging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Created by perdonare on 2016/12/1.
 */
@Configuration
public class WebSocketConfig {

        @Bean
        public ServerEndpointExporter serverEndpointExporter (){
            return new ServerEndpointExporter();
    }

}
