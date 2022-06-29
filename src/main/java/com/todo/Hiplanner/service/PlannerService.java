package com.todo.Hiplanner.service;

import com.todo.Hiplanner.vo.Memo;

import java.util.List;

public interface PlannerService {

    public List<Memo> getMemo(Memo memo);
    public List<Memo> getOtherMemo(Memo memo);
    public void insertMemo(Memo memo);
    public Memo getMemoDetail(Memo memo);
    public void deleteMemo(Memo memo);
    public void updateMemo(Memo memo);
}
