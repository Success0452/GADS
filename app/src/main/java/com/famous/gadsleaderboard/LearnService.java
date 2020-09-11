package com.famous.gadsleaderboard;

import com.famous.gadsleaderboard.Module.Learn;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LearnService
{

    @GET("/api/skilliq")
    Call<List<Learn>> getTopSkillIQLearners();

    @GET("/api/hours")
    Call<List<Learn>> getTopHoursLearners();
}
