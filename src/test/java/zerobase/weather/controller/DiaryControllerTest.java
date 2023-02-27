package zerobase.weather.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DiaryController.class)
class DiaryControllerTest {

    @MockBean
    private DiaryService diaryService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void readDiary_success() throws Exception {
        //given
        List<Diary> diaryList = new ArrayList<>();
        diaryList.add(Diary.builder()
                .id(1)
                .date(LocalDate.now())
                .weather("흐림")
                .icon("1111")
                .temperature(10.0)
                .text("테스트")
                .build());
        given(diaryService.readDiary(any()))
                .willReturn(diaryList);
        //when
        //then
        mockMvc.perform(get("/read/diary?date=2023-02-27"))
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].weather").value("흐림"))
                .andExpect(jsonPath("$[0].icon").value("1111"))
                .andExpect(jsonPath("$[0].temperature").value(10.0))
                .andExpect(jsonPath("$[0].text").value("테스트"))
                .andExpect(jsonPath("$[0].date").value("2023-02-27"))
                .andExpect(status().isOk());
    }

    @Test
    void readDiaries_success() throws Exception {
        //given
        List<Diary> diaryList = new ArrayList<>();
        diaryList.add(Diary.builder()
                .id(1)
                .date(LocalDate.now())
                .weather("흐림")
                .icon("1111")
                .temperature(10.0)
                .text("테스트")
                .build());
        given(diaryService.readDiares(any(), any()))
                .willReturn(diaryList);
        //when
        //then
        mockMvc.perform(get("/read/diaries?startDate=2023-02-27&endDate=2023-02-27"))
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].weather").value("흐림"))
                .andExpect(jsonPath("$[0].icon").value("1111"))
                .andExpect(jsonPath("$[0].temperature").value(10.0))
                .andExpect(jsonPath("$[0].text").value("테스트"))
                .andExpect(jsonPath("$[0].date").value("2023-02-27"))
                .andExpect(status().isOk());
    }
}