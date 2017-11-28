package com.tab.lab.dslexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        a(Product("Banana",price = 3.54),findViewById(android.R.id.content))
    }

    private fun a(product:Product,root: View) =

            plpWidgetDsl(root){
                title {
                    text(product.title)
                    visibility(View.VISIBLE)
                }
                price {
                    text(product.price.toString())
                }


}
}
