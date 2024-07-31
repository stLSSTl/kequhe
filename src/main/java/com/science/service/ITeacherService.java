package com.science.service;

import com.science.dto.ClassInteractionDTO;
import com.science.dto.CourseVideoDTO;
import com.science.entity.ClassInteraction;

public interface ITeacherService {
    public void addVideo(CourseVideoDTO courseVideoDTO);

    public void deleteVideo(int id);

    public void updateVideo(CourseVideoDTO courseVideoDTO);

    public void addInteraction(ClassInteractionDTO classInteractionDTO);

    public void deleteInteraction(int id);

    public void updateInteraction(ClassInteractionDTO classInteractionDTO);
}
