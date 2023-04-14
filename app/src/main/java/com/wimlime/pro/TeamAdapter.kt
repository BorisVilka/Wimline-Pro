package com.wimlime.pro

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.wimlime.pro.databinding.GameItemBinding
import com.wimlime.pro.databinding.TeamItemBinding
import java.lang.Exception

class TeamAdapter(val list: MutableList<Team>): RecyclerView.Adapter<TeamAdapter.Companion.TeamHolder>() {



    companion object {
        class TeamHolder(val binding: TeamItemBinding): RecyclerView.ViewHolder(binding.root) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        return TeamHolder(TeamItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.binding.name1.text = list[position].name
        var t = position
        Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[position].id}.png")).into(holder.binding.photo1, object : Callback {
            override fun onSuccess() {

            }

            override fun onError(e: Exception?) {
                Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[t].image_id}.png")).into(holder.binding.photo1, object : Callback {
                    override fun onSuccess() {

                    }

                    override fun onError(e: Exception?) {
                        Picasso.get().load(Uri.parse("https://spoyer.com/api/team_img/soccer/${list[t].id}.png")).into(holder.binding.photo1, object : Callback {
                            override fun onSuccess() {

                            }

                            override fun onError(e: Exception?) {
                                Picasso.get().load(Uri.parse("https://spoyer.com/api/icons/countries/${list[position].cc}.svg")).into(holder.binding.photo1, object : Callback {
                                    override fun onSuccess() {

                                    }

                                    override fun onError(e: Exception?) {

                                    }

                                })
                            }

                        })
                    }

                })
            }

        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}