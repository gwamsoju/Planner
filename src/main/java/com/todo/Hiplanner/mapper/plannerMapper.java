package com.todo.Hiplanner.mapper;

import com.todo.Hiplanner.vo.Memo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface plannerMapper {

    public List<Memo> getMemo(Memo memo);

}
