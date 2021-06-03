package com.divesh.myphotos

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.divesh.myphotos.databinding.FragmentLayoutBinding

class GalleryFragment : Fragment(R.layout.fragment_layout) {

    private var _binding : FragmentLayoutBinding? = null
    private val binding get() = _binding!!

    val viewModel by viewModels<GalleryViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentLayoutBinding.bind(view)
        val photoAdapter =  GalleryAdapter()

        binding.apply {
                recyclerview.apply {
                    setHasFixedSize(true)
                    layoutManager = GridLayoutManager(activity,2)
                    adapter = photoAdapter
                }
        }

        viewModel.dogsList.observe(viewLifecycleOwner, Observer {
            photoAdapter.setListData(it)
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}