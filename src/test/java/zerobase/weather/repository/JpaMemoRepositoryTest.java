package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.exercise.domain.Memo;
import zerobase.weather.exercise.repository.JpaMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        //given 어떤 데이터가 주어졌을 때
        Memo memo = new Memo(1,"안녕하세요");
        //when 어떤 경우에
        jpaMemoRepository.save(memo);
        //then 이런 결과가 나온다.
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
        assertEquals(1, memoList.get(0).getId());
        assertEquals("안녕하세요", memoList.get(0).getTxt());
    }

    @Test
    void findByIdTest() {
        //given 어떤 데이터가 주어졌을 때
        Memo memo = new Memo(11,"안녕하세요");
        //when 어떤 경우에
        Memo memo1 = jpaMemoRepository.save(memo);
        //then 이런 결과가 나온다.
        Optional<Memo> result = jpaMemoRepository.findById(memo1.getId());
//        assertEquals(1, result.get().getId());
        assertEquals("안녕하세요", result.get().getTxt());
    }
}