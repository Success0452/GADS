package com.famous.gadsleaderboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.famous.gadsleaderboard.Adapter.LeaarnersAdapt;
import com.famous.gadsleaderboard.Module.Learn;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Skill_IQ_Fragment extends Fragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    LeaarnersAdapt learnersAdapter;
    ViewGroup root;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

            /* recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
*/
        getAllUsers();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = (ViewGroup) inflater.inflate(R.layout.fragment_skill__i_q_, null);

        mSwipeRefreshLayout = root.findViewById(R.id.swiperefresh_items);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                Skill_IQ_Fragment.this.getAllUsers();

                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }, 1000);

            }
        });


        return root;


    }

    private void generateDataList(List<Learn> learnerslist) {
        recyclerView = root.findViewById(R.id.recyclerview);
        learnersAdapter = new LeaarnersAdapt(getContext(), learnerslist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(learnersAdapter);
    }

    public void getAllUsers() {

        LearnService service = Api.getRetrofitInstance().create(LearnService.class);
        Call<List<Learn>> call = service.getTopSkillIQLearners();


        call.enqueue(new Callback<List<Learn>>() {
            @Override
            public void onResponse(@NotNull Call<List<Learn>> call, @NotNull Response<List<Learn>> response) {


                if (response.body() != null) {
                    generateDataList(response.body());
                }


            }

            @Override
            public void onFailure(Call<List<Learn>> call, Throwable t) {
                Log.e("failure", Objects.requireNonNull(t.getLocalizedMessage()));

            }
        });
    }
    }
