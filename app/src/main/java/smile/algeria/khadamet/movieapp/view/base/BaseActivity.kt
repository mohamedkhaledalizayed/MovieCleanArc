package smile.algeria.khadamet.movieapp.view.base


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created at Tito on 3/16/19
 *
 * Base Activity that contains some shared methods allover the activities of the app.
 */

abstract class BaseActivity : AppCompatActivity() {

    abstract val screenName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun buildNavigateUpArrow() {
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}