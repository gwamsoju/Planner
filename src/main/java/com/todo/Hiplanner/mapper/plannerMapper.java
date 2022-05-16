package com.todo.Hiplanner.mapper;

import com.todo.Hiplanner.vo.Memo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface plannerMapper {

    public Memo getMemo(Memo memo);

}
