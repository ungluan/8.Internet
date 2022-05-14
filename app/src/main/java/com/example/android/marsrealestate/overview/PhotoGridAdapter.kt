/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.overview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsrealestate.databinding.GridViewItemBinding
import com.example.android.marsrealestate.network.MarsProperty

class PhotoGridAdapter : ListAdapter<MarsProperty, PhotoGridAdapter.ViewHolder>(DiffCallback()){

    class ViewHolder(val binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: MarsProperty){
            binding.property = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = GridViewItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
class DiffCallback : DiffUtil.ItemCallback<MarsProperty>(){
    override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
        return newItem.id == oldItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
        return newItem == oldItem
    }

}