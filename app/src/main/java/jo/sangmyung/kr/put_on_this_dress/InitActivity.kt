package jo.sangmyung.kr.put_on_this_dress

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.content_init.*

class InitActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        val intent: Intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_init)

        btn_start_ceo.setOnClickListener(this)
        btn_start_consumer.setOnClickListener(this)
    }

}
