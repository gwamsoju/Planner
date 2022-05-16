package com.todo.Hiplanner.service;

import com.todo.Hiplanner.mapper.plannerMapper;
import com.todo.Hiplanner.repository.MemoRepository;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoServiceImpl implements MemoService{

    private final plannerMapper plannerMapper;

    @Override
    public List<Memo> getMemo(Memo memo) {
        return plannerMapper.getMemo(memo);
    }


}
