package jo.sangmyung.kr.put_on_this_dress.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import jo.sangmyung.kr.put_on_this_dress.R
import kotlinx.android.synthetic.main.content_init.*

class InitActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        val intent: Intent = Intent()

        when (p0?.id) {
            R.id.btn_start_consumer -> intent.setClass(applicationContext, ConsumerActivity::class.java)
            R.id.btn_start_ceo -> intent.setClass(applicationContext, CEOActivity::class.java)
        }

        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_init)

        btn_start_ceo.setOnClickListener(this)
        btn_start_consumer.setOnClickListener(this)
    }

}
