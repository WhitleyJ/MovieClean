package com.movie.movieclean.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.movie.movieclean.App
import com.movie.movieclean.Constance
import com.movie.movieclean.R
import com.movie.movieclean.databinding.FragmentDetailBinding
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.presentation.viewmodels.ListViewModel
import com.movie.movieclean.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject


class DetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }
    private val viewModelDetail by lazy {
        ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]
    }
    private val component by lazy {
        (requireActivity().application as App).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgs()
    }

    private fun getArgs() {
        val currentMovie = arguments?.getSerializable(Constance.CURRENT_ID) as Movie
        viewModelDetail.popularMovie.observe(viewLifecycleOwner) {
            with(binding) {
                Log.d("Image", it.toString())
                tvMovieName.text = currentMovie.title
                tvDuration.text = currentMovie.release_date
                textView6.text = currentMovie.adult.toString()
                tvDetailDesc.text = currentMovie.overview
                tvDirectorName.text = currentMovie.popularity.toString()
                Glide.with(root.context)
                    .load("https://image.tmdb.org/t/p/w342" + currentMovie.poster_path)
                    .placeholder(R.drawable.img)
                    .into(ivShadow)
            }
        }
    }
}