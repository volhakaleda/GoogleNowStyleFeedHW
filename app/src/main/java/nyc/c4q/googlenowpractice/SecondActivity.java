package nyc.c4q.googlenowpractice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import nyc.c4q.googlenowpractice.models.GitHubJob;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivity extends AppCompatActivity implements LinkInterface {

    private SecondAdapter secondAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        ArrayList<GitHubJob> list = intent.getParcelableArrayListExtra(MainActivity.KEY);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.second_recyclerview);
        secondAdapter = new SecondAdapter(list, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setAdapter(secondAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

    }
    @Override
    public void clickLink(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }

    @Override
    public void clickAllJobs(){
    }
}
