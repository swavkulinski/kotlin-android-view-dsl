Android View DSL
====

This library allows to change properties of exisiting view hierarchy using DSL instead of
particular setters on views.

Consider following DSL

```kotlin
    private fun a(product:Product,root: View) = plpWidgetDsl(root){
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

`plpWidgetDsl` is a top level function which bootstraps top level widget class `PlpWidgetDsl`

Each widget may define many children 

```kotlin
class PlpWidgetDsl(root:View) : Widget(root) {
   fun title(init: Title.() -> Unit) = initWidget(Title(root), init)
   fun price(init: Price.() -> Unit) = initWidget(Price(root), init)
}
```

As you can see `title` and `price` map to `Title` and `Price` classes respectively





