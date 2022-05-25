package com.todo.Hiplanner.Memo;

import com.todo.Hiplanner.mapper.plannerMapper;
import com.todo.Hiplanner.service.MemoService;
import com.todo.Hiplanner.vo.Memo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class MemoTest {

    @Autowired
    private plannerMapper plannerMapper;

    @Test
    public void 메모작성(){

        Memo memo = new Memo();

        memo.setTitle("야구");
        memo.setContent("야구");
        memo.setId("wodud");
        String begin = "2022/05/17";
        String end = "2022/05/17";
        memo.setBegin(begin);
        memo.setEnd(end);


        plannerMapper.insertMemo(memo);

        List<Memo> memo2 = plannerMapper.getMemo(memo);
        Memo memo1 = memo2.get(0);
        assertThat(memo1.getTitle()).isEqualTo("야구");
    }

    @Test
    public void 메모상세보기(){
        Memo memo = new Memo();

        memo.setTitle("야구");
        memo.setContent("야구");
        memo.setId("wodud");
        String begin = "2022/05/17";
        String end = "2022/05/17";
        memo.setBegin(begin);
        memo.setEnd(end);
        memo.setPlanno(3);

        Memo memoDetail = plannerMapper.getMemoDetail(memo);

        assertThat(memoDetail.getTitle()).isEqualTo("야구");
    }

    @Test
    public void 메모삭제(){
        Memo memo = new Memo();

        memo.setTitle("야구");
        memo.setContent("야구");
        memo.setId("wodud");
        String begin = "2022/05/17";
        String end = "2022/05/17";
        memo.setBegin(begin);
        memo.setEnd(end);

        plannerMapper.insertMemo(memo);

        Memo memo2 = new Memo();
        memo2.setTitle("야구");
        memo2.setContent("야구");
        memo2.setId("wodud");
        memo2.setBegin(begin);
        memo2.setEnd(end);
        memo2.setPlanno(1);

        plannerMapper.deleteMemo(memo2);
        List<Memo> memo1 = plannerMapper.getMemo(memo2);

        assertThat(memo1.size()).isEqualTo(0);


    }

    @Test
    public void 메모변경(){
        Memo memo = new Memo();
        memo.setId("wodud");
        memo.setTitle("기능구현");
        memo.setContent("메모 수정");
        memo.setPlanno(2);
        plannerMapper.updateMemo(memo);

        Memo memoDetail = plannerMapper.getMemoDetail(memo);

        assertThat(memoDetail.getContent()).isEqualTo("메모 수정");
    }

}
