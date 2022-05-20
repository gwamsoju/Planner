package com.todo.Hiplanner.Memo;

import com.todo.Hiplanner.mapper.plannerMapper;
import com.todo.Hiplanner.service.MemoService;
import com.todo.Hiplanner.vo.Memo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemoTest {

    @Autowired
    private MemoService memoService;

    // 메모 작성 테스트
    @Test
    public void insertMemo(){
        Memo memo = new Memo();
        memo.setTitle("야구");
        memo.setContent("야구");
        memo.setId("wodud");
        String begin = "2022/05/17";
        memo.setBegin(begin);

        memoService.insertMemo(memo);

        List<Memo> memo2 = memoService.getMemo(memo);
        System.out.println(memo2);
    }

    // 메모 상세보기 테스트
    @Test
    public void getMemoDetail(){
        Memo memo = new Memo();

        memo.setId("wodud");
        memo.setDo_num(1);

        Memo memoDetail = memoService.getMemoDetail(memo);

        assertThat(memoDetail.getTitle()).isEqualTo("공부하기");
    }
}
