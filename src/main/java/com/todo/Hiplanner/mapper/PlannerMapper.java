package com.todo.Hiplanner.mapper;

import com.todo.Hiplanner.vo.Memo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlannerMapper {

    public List<Memo> getMemo(Memo memo);
    public void insertMemo(Memo memo);
    public Memo getMemoDetail(Memo memo);
    public void deleteMemo(Memo memo);
    public void updateMemo(Memo memo);
}
