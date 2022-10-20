package com.example.demo.Dto;

import lombok.Data;

/**
 * Using @Data is equivalent to
 * 		using @code @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode
 * Generates getters for all fields, a useful toString method, and hashCode and
 * 		equals implementations that check all non-transient fields.
 * @author mraj
 */
@Data
public class ResponseDto {

	   private String message;
	    private Object data;

	    public ResponseDto(String message, Object data) {
	        this.message = message;
	        this.data = data;
	    }
	}
