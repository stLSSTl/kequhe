package com.science.mapper;

import com.science.entity.ClassInteraction;
import com.science.entity.CourseVideo;

public interface TeacherMapper {

    /**
     * 老师上传视频
     * @param courseVideo
     */
    public Integer InsertVideo(CourseVideo courseVideo);

    /**
     * 老师根据视频名称删除视频
     * @param name
     * @return
     */
    public Integer DeleteVideoByName(String name);

    /**
     * 老师修改视频信息
     * @param courseVideo
     */
    public void ModifyVideo(CourseVideo courseVideo);

    /**
     * 上传课堂互动记录
     * @param classInteraction
     */
    public Integer InsertInteraction(ClassInteraction classInteraction);

    /**
     * 老师根据视频名称删除视频
     * @param name
     * @return
     */
    public Integer DeleteInteractionByName(String name);

    /**
     * 对课堂互动记录进行修改
     * @param classInteraction
     */
    public void ModifyInteraction(ClassInteraction classInteraction);
}
