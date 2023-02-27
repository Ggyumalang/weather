package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherApplicationTests {

	@Test
	void equalTest() {
	    //given 어떤 데이터가 주어졌을 때
	    //when 어떤 경우에
	    //then 이런 결과가 나온다.
		assertEquals(1,1);
	}

	@Test
	void nullTest() {
		//given 어떤 데이터가 주어졌을 때
		//when 어떤 경우에
		//then 이런 결과가 나온다.
		assertNull(null);
	}

	@Test
	void trueTest() {
	    //given 어떤 데이터가 주어졌을 때
	    //when 어떤 경우에
	    //then 이런 결과가 나온다.
		assertTrue(true);
	}
}
