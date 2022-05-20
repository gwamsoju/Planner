package com.todo.Hiplanner.service;

import com.todo.Hiplanner.vo.Memo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MemoService {

    public List<Memo> getMemo(Memo memo);
    public void insertMemo(Memo memo);
    public Memo getMemoDetail(Memo memo);
}
