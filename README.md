# weather(날씨일기) API

## 프로젝트 개요
- 날씨, 일기를 작성/조회/수정/삭제 하는 백엔드 API를 구현

## API 명세
✅ POST / create / diary
- Input Parameter
  - 날짜 (date 형식 : yyyy-MM-dd) 
  - 일기 내용
- 외부 API 에서 받아온 날씨 데이터와 함께 DB에 저장

✅ GET / read / diary
- Input Parameter
  - 날짜 (date 형식 : yyyy-MM-dd) 
- 해당 날짜의 일기를 List 형태로 반환

✅ GET / read / diaries
- Input Parameter
  - 시작일 (date 형식 : yyyy-MM-dd) 
  - 종료일 (date 형식 : yyyy-MM-dd) 
- 해당 날짜의 일기를 List 형태로 반환

✅ PUT / update / diary
- Input Parameter
  - 날짜 (date 형식 : yyyy-MM-dd) 
  - 일기 내용

✅ DELETE / delete / diary
- Input Parameter
  - 날짜 (date 형식 : yyyy-MM-dd) 
- 해당 날짜의 모든 일기 삭제

✅ 매일 새벽 1시에 날씨 데이터를 외부 API 에서 받아 DB에 저장 (Scheduler 기능)

✅ logback을 이용하여 프로젝트에 로그 남기기

✅ swagger을 이용한 API documentation

## 외부 API 사용
- Open Weather Map api

## Dependencies
- Lombok
- JPA
- Spring Web
- MariaDB
- Swagger
- Spring Scheduler
- logback
