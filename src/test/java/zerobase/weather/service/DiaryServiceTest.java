package zerobase.weather.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zerobase.weather.domain.Diary;
import zerobase.weather.repository.DateWeatherRepository;
import zerobase.weather.repository.DiaryRepository;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DiaryServiceTest {

    @Mock
    private DiaryRepository diaryRepository;

    @Mock
    private DateWeatherRepository dateWeatherRepository;

    @InjectMocks
    private DiaryService diaryService;

    @Test
    void updateDiary_success() {
        //given 어떤 데이터가 주어졌을 때
        given(diaryRepository.getFirstByDate(any()))
                .willReturn(Optional.ofNullable(Diary.builder()
                        .date(LocalDate.now())
                        .weather("맑음")
                        .icon("111")
                        .temperature(10.1)
                        .text("테스트")
                        .build()));
        ArgumentCaptor<Diary> captor =
                ArgumentCaptor.forClass(Diary.class);
        //when 어떤 경우에
        diaryService.updateDiary(LocalDate.now(), "테스트1");
        //then 이런 결과가 나온다.
        verify(diaryRepository, times(1)).save(captor.capture());
        assertEquals("2023-02-27", captor.getValue().getDate().toString());
        assertEquals("테스트1", captor.getValue().getText());
        assertEquals("맑음", captor.getValue().getWeather());
        assertEquals("111", captor.getValue().getIcon());
        assertEquals(10.1, captor.getValue().getTemperature());
    }
}