package com.tab.lab.dslexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    val state: State = com.tab.lab.dslexample.State()
    lateinit var content: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        content = findViewById(android.R.id.content)
        setState { state.product = Product("Banana", 0.17) }
    }

    private fun setState(handler:()->Unit) {
        handler()
        bindView(state.product,content)
    }

    private fun bindView(product: Product, root: View) =

            rootWidget(root) {
                title {
                    text(product.title)
                    visibility(View.VISIBLE)
                }
                price {
                    text(product.price.toString())
                    onClick { v: View -> setState({state.product = state.product.copy(price = state.product.price + 10)}) }
                }

            }

}

data class State(var product: Product = Product("Empty",0.0))
