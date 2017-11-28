Android View DSL
====

This sample show how to change properties of existing view hierarchy using DSL instead of
particular setters on views.

Consider following DSL

```kotlin
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
```

Calling above will set text on title and price widgets and also ensure title is visible

How does it work?

`rootWidget` is a top level function which bootstraps root widget class `RootWidget`

Each widget may define many children 

```kotlin
class RootWidget(root:View) : Widget(root) {
   fun title(init: Title.() -> Unit) = initWidget(Title(root), init)
   fun price(init: Price.() -> Unit) = initWidget(Price(root), init)
}
```

As you can see `title` and `price` map to `Title` and `Price` classes respectively

Both classes map to views existing in the 'root' hierarchy

```kotlin
class Title(root:View) : TextWidget(root.findViewById(R.id.product_name))
class Price(root:View) : TextWidget(root.findViewById(R.id.product_price))
```





