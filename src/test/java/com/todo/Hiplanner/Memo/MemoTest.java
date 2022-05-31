package com.todo.Hiplanner.Memo;

import com.todo.Hiplanner.mapper.plannerMapper;
import com.todo.Hiplanner.vo.Memo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MemoTest {

    @Autowired
    private plannerMapper plannerMapper;

    // 메모 작성 테스트
    @Test
    public void 메모_작성(){
        //given
        Memo memo = Memo.builder()
                .title("야구")
                .content("야구")
                .id("wodud")
                .begin("2022/05/17")
                .end("2022/05/17")
                .build();
        //when
        plannerMapper.insertMemo(memo);
        List<Memo> memo2 = plannerMapper.getMemo(memo);
        Memo memo1 = memo2.get(0);
        //then
        assertThat(memo1.getTitle()).isEqualTo("야구");
    }

    // 메모 상세보기 테스트
    @Test
    public void 메모_상세보기(){
        //given
        Memo memo = Memo.builder()
                .title("야구")
                .content("야구")
                .id("wodud")
                .begin("2022/05/17")
                .end("2022/05/17")
                .planno(3)
                .build();
        //when
        Memo memoDetail = plannerMapper.getMemoDetail(memo);
        //then
        assertThat(memoDetail.getTitle()).isEqualTo("야구");
    }

    //메모 삭제 테스트
    @Test
    public void 메모_삭제() {
        //given
        Memo memo = Memo.builder()
                .title("야구")
                .content("야구")
                .id("wodud")
                .begin("2022/05/17")
                .end("2022/05/17")
                .planno(1)
                .build();
        //when
        plannerMapper.insertMemo(memo);
        plannerMapper.deleteMemo(memo);
        List<Memo> memo1 = plannerMapper.getMemo(memo);
        //then
        assertThat(memo1.size()).isEqualTo(0);

    }

    // 메모 내용 변경 테스트
    @Test
    public void 메모_변경(){
        //given
        Memo memo = Memo.builder()
                .title("기능구현")
                .content("기능구현")
                .id("wodud")
                .planno(1)
                .build();
        //when
        plannerMapper.updateMemo(memo);
        Memo memoDetail = plannerMapper.getMemoDetail(memo);
        //then
        assertThat(memoDetail.getContent()).isEqualTo("메모 수정");
    }

}
