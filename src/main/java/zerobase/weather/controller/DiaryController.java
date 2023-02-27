package zerobase.weather.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService diaryService;

    @ApiOperation(value = "일기 텍스트와 날씨를 이용해서 DB에 일기 저장" , notes = "API에 대한 긴 설명")
    @PostMapping("/create/diary")
    void createDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @ApiParam(value="저장할 날짜 입니다.", example = "2023-01-01") LocalDate date
            , @RequestBody String text
    ){
        diaryService.createDiary(date , text);
    }

    @ApiOperation(value = "선택한 날짜의 모든 일기 데이터를 가져온다.")
    @GetMapping("/read/diary")
    List<Diary> readDiary(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @ApiParam(value="조회할 날짜 입니다.", example = "2023-01-01") LocalDate date
    ){
        return diaryService.readDiary(date);
    }

    @ApiOperation(value = "시작일부터 종료일까지의 모든 일기 데이터를 가져온다.")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @ApiParam(value="조회할 기간의 시작날 입니다.", example = "2023-01-01") LocalDate startDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        @ApiParam(value="조회할 기간의 마지막날 입니다.", example = "2023-01-01") LocalDate endDate
    ){
        return diaryService.readDiares(startDate, endDate);
    }

    @ApiOperation(value = "선택한 날짜의 일기와 일기 내용을 수정한다.")
    @PutMapping("/update/diary")
    void updateDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @ApiParam(value="조회할 날짜 입니다.", example = "2023-01-01")LocalDate date
            , @RequestBody  @ApiParam(value="일기 내용입니다.") String text
    ){
        diaryService.updateDiary(date, text);
    }

    @ApiOperation(value = "선택한 날짜의 일기들을 모두 삭제한다.")
    @DeleteMapping("/delete/diary")
    void deleteDiary(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @ApiParam(value="삭제할 날짜 입니다.", example = "2023-01-01") LocalDate date
    ){
        diaryService.deleteDiary(date);
    }
}
