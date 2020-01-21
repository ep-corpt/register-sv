package com.ep.registersv;

import com.ep.registersv.model.MessageModel;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
public class RegisterSvApplication {
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(RegisterSvApplication.class, args);
	}

	@Bean
	public KafkaTemplate<String, MessageModel> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, MessageModel> producerFactory(){
		return new DefaultKafkaProducerFactory<>(properties());
	}

	private Map<String, Object> properties() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, environment.getProperty("spring.kafka.bootstrap-servers"));
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
		return props;
	}
}
