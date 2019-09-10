package jp.techacademy.shohei.tsuji.calapp

import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)

        var num1 = 0.0
        var num2 = 0.0

        try {
            //エラーが起こる可能性のある処理
            num1 = editText1.text.toString().toDouble()
            num2 = editText2.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            //エラーが発生したときに行いたい処理
            Snackbar.make(v!!, "何か数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("閉じる") {

                }.show()
            return
        }

        var num = 0.0

        if (v!!.id === R.id.button1) {
            //  -ボタン
            num = num1 - num2
        } else if (v!!.id === R.id.button2) {
            //  +ボタン
            num = num1 + num2
        } else if (v!!.id === R.id.button3) {
            //  *ボタン
            num = num1 * num2
        } else if (v!!.id === R.id.button4) {
            //  /ボタン

            if(num2 == 0.0){
                Snackbar.make(v!!, "0では割り算できません", Snackbar.LENGTH_INDEFINITE)
                    .setAction("閉じる") {

                    }.show()
                return
            }
            num = num1 / num2
        }

        intent.putExtra("VALUE1", num)
        startActivity(intent)
    }

}
