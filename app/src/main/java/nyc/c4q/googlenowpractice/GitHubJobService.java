package nyc.c4q.googlenowpractice;

import java.util.List;

import nyc.c4q.googlenowpractice.models.GitHubJob;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubJobService {

    @GET ("/positions.json")
    Call<List<GitHubJob>> getJobs();
}
