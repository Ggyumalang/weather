# weather(날씨일기) API

## 프로젝트 개요
- 오픈 API를 이용해 날씨 정보를 가져오며 해당 정보를 토대로 날씨 일기를 작성/조회/수정/삭제 하는 백엔드 API를 구현

## API 명세
1. 일기 생성 API ( `Post /create/diary?date={date}`)
- 파라미터 : 날짜 , 일기 내용
- 정책 : 매일 새벽 1시에 Open Weather Map 에서 날씨 데이터를 받아오고 DateWeather 테이블에 해당 날씨 데이터를 저장한다. 그 저장된 데이터로부터 해당 날짜의 날씨를 가져오는데 날씨 정보가 없을 경우 (새벽 1시에 날씨 데이터를 정상적으로 받아오지 못한 경우) 현재 날씨를 가져오도록하고 날씨와 일기 내용을 저장한다.
- 성공 응답 : 없음. (추후 추가예정)

2. 일기 조회 API ( `GET /read/diary?date={date}`)
- 파라미터 : 조회 날짜
- 정책 : 해당 날짜에 작성한 일기들을 가져온다. 조회 날짜가 너무 과거이거나 미래의 날짜인 경우에 실패응답.
- 성공 응답 : Diary(id, 날씨상태, 날씨아이콘, 기온, 일기 내용, 날짜)

3. 시작날짜-종료날짜 일기 조회 API(`GET /read/diaries?startDate={startDate}&endDate={endDate}`)
- 파라미터 : 조회 시작날짜 , 조회 종료날
- 정책 : 시작일부터 종료일까지의 모든 일기 데이터를 가져온다.
- 성공 응답 : List<Diary> (id, 날씨상태, 날씨아이콘, 기온, 일기 내용, 날짜)

4. 일기 수정 API(`PUT /update/diary?date={date}`)
- 파라미터 : 수정할 날짜 , 수정할 일기 내용
- 정책 : 해당 날짜의 가장 첫번째 일기 내용을 받아온 수정 일기 내용으로 수정한다.
해당 날짜의 일기가 없을 경우 RuntimeException Error 발생
- 성공 응답 : 없음. (추후 추가예정)

5. 일기 삭제 API(`PUT /delete/diary?date={date}`)
- 파라미터 : 삭제할 날짜
- 정책 : 해당 날짜에 작성된 일기들을 모두 삭제한다.
- 성공 응답 : 없음. (추후 추가예정)

## 외부 API 사용
- Open Weather Map api

## Dependencies
- Lombok
- JPA
- Spring Web
- MariaDB
- Swagger
