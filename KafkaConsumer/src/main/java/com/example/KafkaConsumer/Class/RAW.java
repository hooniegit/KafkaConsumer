package com.example.KafkaConsumer.Class;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RAW {
    @JsonProperty("HEADER")
	private RAW_HEADER HEADER;
    
    @JsonProperty("BODY")
	private List<RAW_BODY> BODY;
}