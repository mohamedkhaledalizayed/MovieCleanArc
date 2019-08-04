package smile.algeria.khadamet.movieapp.view.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import smile.algeria.khadamet.movieapp.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

}
