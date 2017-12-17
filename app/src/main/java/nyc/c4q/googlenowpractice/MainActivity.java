package nyc.c4q.googlenowpractice;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nyc.c4q.googlenowpractice.models.GitHubJob;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements LinkInterface {

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String KEY = "jobs";

    private FeedAdapter feedAdapter;
    private ArrayList<GitHubJob> gitHubJobResponse;
    private GitHubJob randomJob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        feedAdapter = new FeedAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(feedAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        if(savedInstanceState != null) {
            randomJob = savedInstanceState.getParcelable("key");
            feedAdapter.setGitHubJob(randomJob);
            feedAdapter.notifyItemChanged(0);
        }

        else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jobs.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            GitHubJobService service = retrofit.create(GitHubJobService.class);

            Call<ArrayList<GitHubJob>> jobService = service.getJobs();

            jobService.enqueue(new Callback<ArrayList<GitHubJob>>() {

                @Override
                public void onResponse(Call<ArrayList<GitHubJob>> call, Response<ArrayList<GitHubJob>> response) {

                    if (response.isSuccessful()) {

                        gitHubJobResponse = response.body();

                        int listSize = gitHubJobResponse.size();
                        Random random = new Random();
                        int n = random.nextInt(listSize);

                        randomJob = gitHubJobResponse.get(n);
                        feedAdapter.setGitHubJob(randomJob);
                        feedAdapter.notifyItemChanged(0);

                    }
                }

                @Override
                public void onFailure(Call<ArrayList<GitHubJob>> call, Throwable t) {
                    Log.d(TAG, t.getMessage());

                }
            });
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable("key", randomJob);
    }

    @Override
    public void clickLink(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }

    @Override
    public void clickAllJobs(){
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putParcelableArrayListExtra(KEY, gitHubJobResponse);
        startActivity(intent);
    }

}
