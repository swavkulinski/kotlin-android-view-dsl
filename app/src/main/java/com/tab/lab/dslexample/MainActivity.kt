package com.tab.lab.dslexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindView(Product("Banana",price = 3.54),findViewById(android.R.id.content))
    }

    private fun bindView(product:Product,root: View) =

            rootWidget(root){
                title {
                    text(product.title)
                    visibility(View.VISIBLE)
                }
                price {
                    text(product.price.toString())
                }


}
}
