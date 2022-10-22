package com.movie.movieclean.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.movie.movieclean.App
import com.movie.movieclean.Constance
import com.movie.movieclean.R
import com.movie.movieclean.databinding.FragmentListBinding
import com.movie.movieclean.domain.model.Movie
import com.movie.movieclean.presentation.adapters.MovieAdapter
import com.movie.movieclean.presentation.viewmodels.ListViewModel
import com.movie.movieclean.presentation.viewmodels.TopRatedViewModel
import com.movie.movieclean.presentation.viewmodels.ViewModelFactory
import com.movie.movieclean.presentation.viewmodels.ViewModelUp
import javax.inject.Inject


class ListFragment : Fragment() {
    private var adapterTop: MovieAdapter? = null
    private var adapterPopular: MovieAdapter? = null
    private var adapterUpComing: MovieAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[ListViewModel::class.java]
    }

    private val viewModelTop by lazy {
        ViewModelProvider(this, viewModelFactory)[TopRatedViewModel::class.java]
    }

    private val viewModelUp by lazy {
        ViewModelProvider(this, viewModelFactory)[ViewModelUp::class.java]
    }

    private val binding by lazy {
        FragmentListBinding.inflate(layoutInflater)
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
        initRecyclerView()
        initViewModels()
    }

    private fun initViewModels() {
        viewModel.popularMovie.observe(viewLifecycleOwner) {
            if (it != null) {
                adapterPopular?.setData(it)
            }
            adapterPopular?.onItemClick = {
                launchDetailFragment(it)
            }
        }
        viewModelTop.listMovieRated.observe(viewLifecycleOwner) {
            if (it != null) {
                adapterTop?.setData(it)
            }
            adapterTop?.onItemClick = {
                launchDetailFragment(it)
            }

        }
        viewModelUp.listUpComing.observe(viewLifecycleOwner) {
            if (it != null) {
                adapterUpComing?.setData(it)
            }
            adapterUpComing?.onItemClick = {
                launchDetailFragment(it)
            }
        }
    }



    private fun initRecyclerView() {
        with(binding) {
            popularRcView.apply {
                adapterPopular = MovieAdapter()
                adapter = adapterPopular
                initLayoutManager()
            }
            topRatedRcView.apply {
                adapterTop = MovieAdapter()
                adapter = adapterTop
                initLayoutManager()
            }
            upComingRcView.apply {
                adapterUpComing = MovieAdapter()
                adapter = adapterUpComing
                initLayoutManager()
            }
        }
    }

    private fun RecyclerView.initLayoutManager() {
        layoutManager = LinearLayoutManager(requireActivity(),
            LinearLayoutManager.HORIZONTAL, false)
        setHasFixedSize(true)
    }

    private fun launchDetailFragment(model: Movie) {
        val bundle = Bundle()
        bundle.putSerializable(Constance.CURRENT_ID, model)
        findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
    }
}