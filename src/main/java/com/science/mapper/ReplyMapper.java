package com.science.mapper;

import com.science.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public List<Reply> getRepliesByAnswerId(int answerId);
    public Integer insertReply(Reply reply);
}
