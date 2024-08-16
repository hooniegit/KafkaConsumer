package com.example.KafkaConsumer.Class;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RAW_HEADER {
	@JsonProperty("LOCATION")
	private String LOCATION;
}