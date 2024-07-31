package com.science.mapper;

import com.science.entity.ClassInteraction;
import com.science.entity.CourseVideo;
import com.science.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TeacherMapper {
    public Integer findByUserId(int UserId);
    public Integer insert(Teacher teacher);
    /**
     * 根据id查找视频
     * @param videoId
     * @return
     */
    public CourseVideo findVideoById(@Param("videoId") int videoId);
    /**
     * 老师上传视频
     * @param courseVideo
     */
    public Integer insertVideo(CourseVideo courseVideo);

    /**
     * 老师根据视频id删除视频
     * @param id
     * @return
     */
    public Integer deleteVideoById(int id);


    /**
     * 根据id查找课堂互动表
     * @param id
     * @return
     */
    public ClassInteraction findInteractionById(@Param("id") int id);

    /**
     * 上传课堂互动记录
     * @param classInteraction
     */
    public Integer insertInteraction(ClassInteraction classInteraction);

    /**
     * 老师根据视频名称删除视频
     * @param id
     * @return
     */
    public Integer deleteInteractionById(int id);

    /**
     * 对课堂互动记录进行修改
     * @param classInteraction
     */
    public Integer modifyInteraction(ClassInteraction classInteraction);
}
