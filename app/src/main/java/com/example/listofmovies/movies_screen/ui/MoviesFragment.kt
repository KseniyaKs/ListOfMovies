package com.example.listofmovies.movies_screen.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.init
import com.example.listofmovies.R
import com.example.listofmovies.movies_screen.MoviesAdapter
import com.example.listofmovies.movies_screen.MoviesViewModel
import com.example.listofmovies.movies_screen.MoviesViewModelFactory
import com.example.listofmovies.network.di.App
import com.example.listofmovies.network.di.AppComponent
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject


class MoviesFragment : Fragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    @Inject
    lateinit var viewModelFactory: MoviesViewModelFactory
    private val viewModel: MoviesViewModel by viewModels { viewModelFactory }

    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        MoviesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as App).component.injectMoviesFragment(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)

        recycler?.layoutManager = LinearLayoutManager(requireContext())
        recycler?.adapter = adapter

        lifecycleScope.launch {
            viewModel.movies.collectLatest(adapter::submitData)
        }
    }
}
