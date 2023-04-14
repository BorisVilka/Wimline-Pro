package com.wimlime.pro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wimlime.pro.databinding.FragmentPlayersBinding
import retrofit2.Call
import retrofit2.Response
import java.lang.IllegalStateException


class TeamFragment : Fragment() {


    private lateinit var binding: FragmentPlayersBinding
    private var adapter = TeamAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPlayersBinding.inflate(inflater,container,false)
        binding.games.adapter = adapter
        Client.getApi().getAns("ayna","12784-OhJLY5mb3BSOx0O","livedata","soccer").enqueue(object : retrofit2.Callback<Answer> {
            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                Log.d("TAG","${response.body()?.games?.size ?: -1}")
                for(i in response.body()!!.games) {
                   try {
                       requireActivity().runOnUiThread {
                           adapter.list.add(i.away)
                           adapter.list.add(i.home)
                           binding.progressBar2.visibility = View.GONE
                           adapter.notifyDataSetChanged()
                       }
                   } catch (e: IllegalStateException) {
                       e.printStackTrace()
                   }
                }
            }

            override fun onFailure(call: Call<Answer>, t: Throwable) {
                t.printStackTrace()
            }

        })
        return binding.root
    }


}