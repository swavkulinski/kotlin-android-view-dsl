package com.tab.lab.dslexample

/**
 * Dsl for Android Views
 */


import android.view.View
import android.widget.TextView

@DslMarker
annotation class WidgetTagMarker


interface Renderable {
    fun render(root: View)
}

@WidgetTagMarker
abstract class Widget(val root:View) : Renderable {
    private val children = arrayListOf<Renderable>()
    fun <R:Renderable>initWidget( widget: R, init: R.() -> Unit):R{
        widget.init()
        children.add(widget)
        return widget
    }

    override fun render(root: View) {
        children.forEach{it.render(root)}
    }

    fun visibility(visibility:Int) {
         root.visibility = visibility
    }

    fun onClick(onClickListener: (View) -> Unit) {
        root.setOnClickListener(onClickListener)
    }

}

open class TextWidget(root: View) : Widget(root) {
    fun text (t: String) { (root as TextView).text = t}

}

class RootWidget(root:View) : Widget(root) {
   fun title(init: Title.() -> Unit) = initWidget(Title(root), init)
   fun price(init: Price.() -> Unit) = initWidget(Price(root), init)
}

fun rootWidget(root:View, init: RootWidget.() -> Unit): RootWidget {
    val plp = RootWidget(root)
    plp.init()
    return plp
}

class Title(root:View) : TextWidget(root.findViewById(R.id.product_name))
class Price(root:View) : TextWidget(root.findViewById(R.id.product_price))



