package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.exercise.domain.Memo;
import zerobase.weather.exercise.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {

        //given
        Memo newMemo = new Memo(1, "this is new memo~");
        //when
        jdbcMemoRepository.save(newMemo);

        //then
        Optional<Memo> result = jdbcMemoRepository.findById(1);
        assertEquals(result.get().getTxt() , "this is new memo~");
    }

    @Test
    void findAll() {
        List<Memo> memoList = jdbcMemoRepository.findAll();
        System.out.println(memoList.get(0).getId());
        System.out.println(memoList.get(0).getTxt());
        assertNotNull(memoList);
    }
}