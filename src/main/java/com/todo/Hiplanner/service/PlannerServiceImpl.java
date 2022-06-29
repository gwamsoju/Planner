package com.todo.Hiplanner.service;

import com.todo.Hiplanner.mapper.PlannerMapper;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlannerServiceImpl implements PlannerService {

    private final PlannerMapper plannerMapper;

    @Override
    public List<Memo> getMemo(Memo memo) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String begin = localDate.format(formatter);
        memo.setBegin(begin);
        return plannerMapper.getMemo(memo);
    }

    @Override
    public List<Memo> getOtherMemo(Memo memo) {
        return plannerMapper.getMemo(memo);
    }

    @Override
    public void insertMemo(Memo memo) {

        plannerMapper.insertMemo(memo);
    }

    @Override
    public Memo getMemoDetail(Memo memo) {
        return plannerMapper.getMemoDetail(memo);
    }

    @Override
    public void deleteMemo(Memo memo) {
        plannerMapper.deleteMemo(memo);
    }

    @Override
    public void updateMemo(Memo memo) {
        plannerMapper.updateMemo(memo);
    }

}
