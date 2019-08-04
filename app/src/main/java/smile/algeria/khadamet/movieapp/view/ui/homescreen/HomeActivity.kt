package smile.algeria.khadamet.movieapp.view.ui.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import kotlinx.android.synthetic.main.activity_main.*
import smile.algeria.khadamet.movieapp.R
import smile.algeria.khadamet.movieapp.ViewState
import smile.algeria.khadamet.movieapp.view.base.BaseActivity
import smile.algeria.khadamet.movieapp.view.uimodel.MovieUiModel
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var homeViewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configViewModel()

        configUI()

        getMovies()
    }

    private fun configViewModel() {
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override val screenName: String
        get() = this@HomeActivity.localClassName


    private fun configUI() {

        title = getString(R.string.home_title)

        movie_recycler_view_list.apply {
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        person_recycler_view_list.apply {
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
//            adapter = personAdapter
        }

        tv_recycler_view_list.apply {
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
//            adapter = tvAdapter
        }

        movieAdapter.onMovieClickListener = object : MovieAdapter.OnMovieClickListener {
            override fun setOnMovieClickListener(movieId: Int) {
//                MovieDetailsActivity.start(this@HomeActivity, movieId)
            }
        }

        movie_more_btn.setOnClickListener {
//            MovieListActivity.start(this)
        }
        person_more_btn.setOnClickListener {
//            PersonListActivity.start(this)
        }
        tv_more_btn.setOnClickListener {
//            TVListActivity.start(this)
        }

    }

    private fun getMovies() {

        fun setVisibility(isLoading: Boolean, errorMessage: String? = null) {
            movie_loading.visibility = if (isLoading) View.VISIBLE else View.GONE
            movie_recycler_view_list.visibility = if (isLoading) View.GONE else View.VISIBLE
            errorMessage?.let {
                movie_error.visibility = if (isLoading) View.GONE else View.VISIBLE
                movie_error.text = it
            }
        }

        homeViewModel.getMovies(1).observe(this,
            Observer<ViewState<List<MovieUiModel>>> { movieViewState ->
                when (movieViewState.status) {
                    ViewState.Status.LOADING -> {
                        setVisibility(isLoading = true)
                    }

                    ViewState.Status.SUCCESS -> {
                        setVisibility(isLoading = false)
                        movieAdapter.submitList(movieViewState.data)
                    }

                    ViewState.Status.ERROR -> {
                        setVisibility(isLoading = false, errorMessage = movieViewState.message)
                    }
                }
            }
        )

    }
}