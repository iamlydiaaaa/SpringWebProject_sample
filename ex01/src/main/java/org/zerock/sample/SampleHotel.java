package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Component
@ToString
@Getter
@AllArgsConstructor
public class SampleHotel {
	@NonNull Chef chef;
	
	/*
	 * public SampleHotel(Chef chef) { this.chef = chef; }
	 */
}
